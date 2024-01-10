package com.bluebird.bluebird.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {

    @Id
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
