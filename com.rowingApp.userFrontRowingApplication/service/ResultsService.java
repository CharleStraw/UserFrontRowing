package src.service;

import src.domain.UserScore;

import java.util.List;
import java.util.Optional;

public interface ResultsService {


    List<UserScore> findResultList();
    List<UserScore> findByDivision(String division);
    Optional<UserScore> findByName(String filename);
}
