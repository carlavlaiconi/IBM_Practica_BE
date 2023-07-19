package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
