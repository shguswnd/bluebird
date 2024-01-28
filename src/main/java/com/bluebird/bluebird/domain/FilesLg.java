package com.bluebird.bluebird.domain;

import com.bluebird.bluebird.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


/*
* getOriginalFilename():

업로드된 파일의 원래 이름을 반환합니다.
getSize():

업로드된 파일의 크기를 반환합니다.
getContentType():

업로드된 파일의 컨텐츠 타입(MIME 타입)을 반환합니다.
getBytes():

업로드된 파일의 내용을 바이트 배열로 반환합니다.
isEmpty():

업로드된 파일이 비어있는지 여부를 반환합니다.
getInputStream():

업로드된 파일의 InputStream을 반환합니다.
* */
@Entity
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilesLg extends BaseTimeEntity {

    @Id
    private String fileNum;
    @ManyToOne
    @JoinColumn  (name = "MEMBER_ID")
    private Member fileId;
    private String fileName;
    private Long fileSize;
    private String upName;
}