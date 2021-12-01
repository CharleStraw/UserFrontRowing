package com.rowingApp.service.UserServiceImpl;

import com.rowingApp.dao.UserScoreDao;
import com.rowingApp.domain.UserScore;
import com.rowingApp.service.UserScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserScoreServiceImpl implements UserScoreService {

    private static final Logger LOG = LoggerFactory.getLogger(UserScoreServiceImpl.class);

    @Autowired
    private UserScoreDao userScoreDao;



    @Override
    public void saveUser(UserScore userScore) {

        userScoreDao.save(userScore);

        System.out.println("dao methode");
    }
}
