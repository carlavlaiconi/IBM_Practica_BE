package com.example.ibmbe.repositories;

import com.example.ibmbe.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByTeamId(Long teamId);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.team.id=:teamId and u.email = :email  ")
    boolean existsByTeamIdAndEmail(@Param("teamId") Long teamId, @Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.team.id = :teamId AND u.email = :email")
    User findIdByTeamIdAndEmail(Long teamId, String email);
}