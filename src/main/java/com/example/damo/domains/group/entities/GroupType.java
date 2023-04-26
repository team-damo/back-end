package com.example.damo.domains.group.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "group_types")
public class GroupType {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(length = 10)
    private String name;
}
