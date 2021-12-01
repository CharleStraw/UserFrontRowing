package com.rowingApp.service;

import com.rowingApp.domain.UserScore;

import java.util.List;
import java.util.Optional;

public interface ResultsService {


    List<UserScore> findResultList();
    Optional<UserScore> findByName(String filename);

}
