package com.rowingApp.dao;

import com.rowingApp.domain.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserScoreDao   extends JpaRepository<UserScore,Long> {
    Optional<UserScore> findByName(String filename);
    List<UserScore> findAll();
}
