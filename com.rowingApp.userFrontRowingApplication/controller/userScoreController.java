package src.controller;

import src.domain.UserScore;
import src.service.UserServiceImpl.UserScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class userScoreController {



    @Autowired
    UserScoreServiceImpl userService;



    @RequestMapping(value = "/submitScore", method = RequestMethod.GET)
    public String submitScore(Model model) {
        UserScore userScore = new UserScore();
        model.addAttribute("userScore", userScore);

        return "submitScore";
    }

    @PostMapping("/submitScore")
    public String uploadFile(@RequestParam("myfile") MultipartFile myfile, @ModelAttribute("userScore") UserScore newUserScore, Model model) throws IOException {

        System.out.println("Name " + newUserScore.getName());
        System.out.println("Wats" + newUserScore.getWats());
        System.out.println("Division" + newUserScore.getDivision());
        System.out.println("Image Size in Bytes - " + myfile.getBytes().length);

        UserScore userScore = new UserScore();

        userScore.setDivision(newUserScore.getDivision());
        userScore.setName(newUserScore.getName());
        userScore.setWats(newUserScore.getWats());
        userScore.setDivision(newUserScore.getDivision());
        userScore.setPicture(myfile.getBytes());

        System.out.println("weszło 2");

        userService.saveUser(userScore);

        model.addAttribute("userScore", userScore);

        System.out.println("weszło 3");

        return "submitScore";
    }

}
