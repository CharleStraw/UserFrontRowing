package src.dao;

import src.domain.UserScore;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserScoreDao   extends CrudRepository<UserScore,Long> {
    List<UserScore> findAll();
    List<UserScore> findByDivision(String division);
    Optional<UserScore> findByName(String filename);
}
