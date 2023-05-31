package com.example.damo.application.controllers;


// 중복 테스트 코드를 줄이기 위한 static import
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.example.damo.application.controllers.GroupController;
import com.example.damo.application.usecases.groups.GroupUseCase;
import com.example.damo.domains.group.entities.Group;
import com.example.damo.domains.group.interfaces.GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface;
import com.example.damo.domains.group.services.GroupJoinHistoryReadService;
import com.example.damo.domains.group.services.GroupJoinHistoryWriteService;
import com.example.damo.domains.group.services.GroupReadService;
import com.example.damo.domains.group.services.GroupWriteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(controllers = GroupController.class)
// @AutoConfigureWebMvc 이 어노테이션을 사용하면 MockMvc를 Builder 없이 주입받을 수 있음
public class GroupControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // GroupController에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체를 생성해줌
    @MockBean
    GroupJoinHistoryReadService groupJoinHistoryReadService;

    @MockBean
    GroupWriteService groupWriteService;

    @MockBean
    GroupReadService groupReadService;

    @MockBean
    GroupUseCase groupUseCase;

    @MockBean
    GroupJoinHistoryWriteService groupJoinHistoryWriteService;

    @Test
    @DisplayName("그룹 - 없는 그룹 조회")
    void findAllMissingGroup() throws Exception {
        given(groupJoinHistoryReadService.getAllJoinMembersByGroupId((long) 10000000)).willReturn(new ArrayList<>());

        int typeId = 10000000;
        mockMvc.perform(get("/api/v1/groups/" + typeId)).andExpect(status().isOk()).andDo(print());
    }
}
