package com.icia.test.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@javax.persistence.Entity
@Table(name="member_test_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long member_id;

    @Column(length = 30, unique = true)
    private String member_email;

    @Column(length=50, nullable = false)
    private String member_password;

    @Column(length=20)
    private String member_name;

    @OneToMany(mappedBy="memberEntity", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<BoardEntity> boardEntityList = new ArrayList<>();

}
