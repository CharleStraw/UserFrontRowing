package com.rowingApp.controller;

import com.rowingApp.domain.UserScore;
import com.rowingApp.service.UserServiceImpl.UserScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class userScoreController {

    @Autowired
    UserScoreServiceImpl userService;


    @RequestMapping(value = "/submitScore", method = RequestMethod.GET)
    public String submitScore(Model model,@RequestParam(value = "filename", required = false) String filename) {
        UserScore userScore = new UserScore();
        model.addAttribute("userScore", userScore);
        model.addAttribute("filename", filename);
        return "submitScore";
    }

//    public String uploadFile(@RequestParam("myfile") MultipartFile myfile) throws IOException {
//        System.out.println("Image Size in Bytes - " + myfile.getBytes().length);
//        ImageGallary img = new ImageGallary();
//        img.setName(myfile.getOriginalFilename());
//        img.setType(myfile.getContentType());
//        img.setFileByte(myfile.getBytes());
//        imageRepository.save(img);
//        return "redirect:/";

    @RequestMapping(value = "/submitScore", method = RequestMethod.POST)
    public String submitScorePost(
            @RequestParam("myfile") MultipartFile myfile,
            @ModelAttribute("userScore") UserScore newUserScore, Model model) throws IOException {

        System.out.println("weszło 1 " + newUserScore.getDivision());
        System.out.println("weszło 1 " + newUserScore.getName());
        System.out.println("weszło 1 " + newUserScore.getWats());
        System.out.println("weszło 1 " + newUserScore.getPicture());
        UserScore userScore = new UserScore();

        userScore.setDivision(newUserScore.getDivision());
        userScore.setName(newUserScore.getName());
        userScore.setWats(newUserScore.getWats());
        userScore.setPicture(myfile.getBytes());
        System.out.println("weszło 2");

        userService.saveUser(userScore);

        model.addAttribute("userScore", userScore);

        System.out.println("weszło 3");

        return "submitScore";
    }

}
