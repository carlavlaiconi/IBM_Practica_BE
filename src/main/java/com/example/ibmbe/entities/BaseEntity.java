package com.example.ibmbe.entities;

import jakarta.persistence.*;


import java.time.LocalDateTime;


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

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
