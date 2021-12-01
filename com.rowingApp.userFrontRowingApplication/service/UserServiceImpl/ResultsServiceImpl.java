package src.service.UserServiceImpl;

import src.dao.UserScoreDao;
import src.domain.UserScore;
import src.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ResultsServiceImpl implements ResultsService {

    @Autowired
    private UserScoreDao userScoreDao;



    @Override
    public List<UserScore> findResultList() {


        List<UserScore> resultList = userScoreDao.findAll();


        return resultList;
    }

    @Override
    public List<UserScore> findByDivision(String division) {

        List<UserScore> resultList = userScoreDao.findByDivision(division);

        return resultList;
    }

    @Override
    public Optional<UserScore> findByName(String filename) {
        return userScoreDao.findByName(filename);
    }
}
