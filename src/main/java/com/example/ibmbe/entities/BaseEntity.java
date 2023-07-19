package com.example.ibmbe.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "id_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Version
    @Column(name = "databaseVersion", nullable = false)
    private Long databaseVersion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDate", updatable = false, nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateDate", nullable = false)
    private LocalDateTime updateDate;


    @PrePersist
    private void setUpdateDate() {
        updateDate = LocalDateTime.now();
    }
}
