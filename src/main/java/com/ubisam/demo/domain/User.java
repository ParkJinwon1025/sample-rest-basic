package com.ubisam.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
// MSSQL 일 때 => user가 MSSQL의 시스템 예약어이기 때문에 users로 테이블명을 변경
// @Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phone;

}
