package com.rowingApp.service.UserServiceImpl;

import com.rowingApp.dao.UserScoreDao;
import com.rowingApp.domain.UserScore;
import com.rowingApp.service.ResultsService;
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
    public Optional<UserScore> findByName(String filename) {

        Optional<UserScore> resultUser = userScoreDao.findByName(filename);

       return resultUser;
    }
}
