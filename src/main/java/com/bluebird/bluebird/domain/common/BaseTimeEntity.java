package com.bluebird.bluebird.domain.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 다른 엔티티들이 BaseTimeEntity를 상속할 경우 BaseTimeEntity의 필드를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)//Auditing 기능 포함
public abstract class BaseTimeEntity {
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime firstDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime upDate;
}
