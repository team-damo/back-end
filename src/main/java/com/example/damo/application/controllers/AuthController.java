package com.example.damo.application.controllers;

import com.example.damo.domains.user.dtos.KakaoProfile;
import com.example.damo.domains.user.dtos.OAuthToken;
import com.example.damo.domains.user.entities.User;
import com.example.damo.domains.user.services.UserReadService;
import com.example.damo.domains.user.services.UserWriteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Value("${kakao.client_id}")
    private String CLIENT_ID;
    @Value("${kakao.redirect}")
    private String REDIRECT_URL;

    @Autowired
    private UserWriteService userWriteService;
    @Autowired
    private UserReadService userReadService;

    @GetMapping()
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/kakao")
    public ModelAndView loginKakao(@RequestParam("code") String code) {
        ModelAndView mav = new ModelAndView();
        RestTemplate rt = new RestTemplate();

        // HTTP 헤더 오브젝트
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP 바디 오브젝트
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", CLIENT_ID);
        params.add("redirect_url", REDIRECT_URL);
        params.add("code", code);

        // HTTP 헤더와 바디를 하나의 오브젝트로
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        // HTTP 요청하기
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );


        // Gson, Json Simple, Object Mapper
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = null;
        try {
            oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        RestTemplate rt2 = new RestTemplate();

        assert oAuthToken != null;
        // HTTP 헤더 오브젝트
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization", "Bearer " + oAuthToken.getAccess_token());
        headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP 헤더와 바디를 하나의 오브젝트로
        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);

        // HTTP 요청하기
        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        // Gson, Json Simple, Object Mapper
        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        assert kakaoProfile != null;
        User user = userReadService.findById(kakaoProfile.getId());
        if(user == null) {
            user = User.builder()
                    .id(kakaoProfile.getId())
                    .username(kakaoProfile.getProperties().getNickname())
                    .email(kakaoProfile.getKakao_account().getEmail())
                    .image(kakaoProfile.getProperties().getProfile_image())
                    .oauth("KAKAO")
                    .build();
            userWriteService.save(user);
        }

        mav.addObject("userId", user.getId());
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping("/kakao/logout")
    public ModelAndView logout() {
        System.out.println("logout");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("index");
        return mav;
    }
}
