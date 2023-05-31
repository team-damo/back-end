package com.example.damo.domains.user.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(unique = true)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column()
    private String email;

    @Column()
    private String image;

    @Column()
    private String link;

    @Column()
    private String job;

    @Column()
    private String oauth;

//    @Enumerated(EnumType.STRING)
//    private RoleType role;

    @CreationTimestamp
    private Timestamp createdAt;
}
