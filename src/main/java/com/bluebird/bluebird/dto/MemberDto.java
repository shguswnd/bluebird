package com.bluebird.bluebird.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class MemberDto {
    private String id;
    private String pwd;
    private String name;
    //Dto 날짜 포맷 jpa랑 다르다!
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date birthDay;
    private String email;
    private String phoneNum;
    private String profile;
}
