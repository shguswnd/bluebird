package com.bluebird.bluebird.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter //@Setter
@NoArgsConstructor  //인자 없는 기본 생성자
@AllArgsConstructor //모든 인자를 가지는 생성자
@Builder            //빌더 패턴
public class Member {

    @Id //pk 필드
    @GeneratedValue
    private String id;
    private String pwd;
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;
    private String frtName;
    private String ltName;
    private String mailAccept;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String profile;
}
