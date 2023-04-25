package com.example.damo.domains.group.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "group_types")
public class GroupType {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 10)
    private String name;

    @Builder
    public GroupType(Long id, String name) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
    }
}
