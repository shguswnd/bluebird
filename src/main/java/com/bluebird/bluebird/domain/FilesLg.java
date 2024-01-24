package com.bluebird.bluebird.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilesLg {

    @Id
    private String fileNum;
    @ManyToOne
    @JoinColumn  (name = "id")
    private String id;
    private String fileName;
    private Integer fileSize;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date upDate;
    private String upName;
}
