package com.example.ibmbe.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @Version
//    @Column(name = "databaseVersion", nullable = true)
//    private Long databaseVersion;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "createDate", updatable = false, nullable = true)
//    private LocalDateTime createDate = LocalDateTime.now();
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "updateDate", nullable = true)
//    private LocalDateTime updateDate;
//
//
//    @PrePersist
//    private void setUpdateDate() {
//        updateDate = LocalDateTime.now();
//    }
}
