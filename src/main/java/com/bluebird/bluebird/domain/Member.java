package com.bluebird.bluebird.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

//@Setter
@Entity
@ToString
@Getter
@NoArgsConstructor  //인자 없는 기본 생성자
@AllArgsConstructor //모든 인자를 가지는 생성자
@Builder            //빌더 패턴
public class Member {

    //    @GeneratedValue
    @Id //pk 필드
    private String id;
    private String pwd;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    private String email;
    private String phoneNum;
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String profile;
}
