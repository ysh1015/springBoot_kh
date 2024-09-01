package com.kh.boot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "MEMBER")
@Data
public class MemberEntity {

    @Id
    @Column(name = "member_key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberKey;

    @Column(name = "id", nullable = false, length= 100)
    private String id;

    @Column(name = "password", nullable = false, length= 100)
    private String password;

    @Column(name = "phone", nullable = false, length= 100)
    private String phone;
}
