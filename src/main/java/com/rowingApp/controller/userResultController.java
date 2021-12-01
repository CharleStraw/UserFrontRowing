package com.rowingApp.controller;

import com.rowingApp.dao.ImageRepository;
import com.rowingApp.domain.ImageGallary;
import com.rowingApp.domain.UserScore;
import com.rowingApp.service.UserServiceImpl.ResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
public class userResultController {


    @Autowired
    ResultsServiceImpl userServiceResults;

    @RequestMapping("/resultsPage")
    public String primaryAccount(Model model) {
        List<UserScore> resultList = userServiceResults.findResultList();

        Collections.sort(resultList, Collections.reverseOrder());

        long a = 1;

        for (UserScore ResultList : resultList) {

            ResultList.setNumber(a++);

//            System.out.println(ResultList.getNumber());
        }


        model.addAttribute("resultList", resultList);

        return "resultsPage";
    }

    @GetMapping(value = "/test/{filename}")
    public void getImage(@PathVariable("filename") String filename,HttpServletResponse response) throws Exception {

        System.out.println("ASDASDASDASDA "+filename);

        Optional<UserScore> img = userServiceResults.findByName(filename);
        if (img.isPresent()) {
            System.out.println("returning file:"+img.get().getPicture());
            byte[] bytes = img.get().getPicture();
            InputStream is = new BufferedInputStream(new ByteArrayInputStream(bytes));
            String mimeType = URLConnection.guessContentTypeFromStream(is);
            response.setContentType(mimeType);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();



        }

    }}


//
//
//    @PostMapping("/uploadFile")
//    public String uploadFile(@RequestParam("myfile") MultipartFile myfile) throws IOException {
//        System.out.println("Image Size in Bytes - " + myfile.getBytes().length);
//        ImageGallary img = new ImageGallary();
//        img.setName(myfile.getOriginalFilename());
//        img.setType(myfile.getContentType());
//        img.setFileByte(myfile.getBytes());
//        imageRepository.save(img);
//        return "redirect:/";
//    }
//
//    @GetMapping("/images/{filename}")
//    public void getImage(@PathVariable("filename") String filename, HttpServletResponse response) throws Exception {
//        Optional<ImageGallary> img = imageRepository.findByName(filename);
//        if(img.isPresent()) {
//            System.out.println("returning file:"+filename);
//            byte[] bytes = img.get().getFileByte();
//            InputStream is = new BufferedInputStream(new ByteArrayInputStream(bytes));
//            String mimeType = URLConnection.guessContentTypeFromStream(is);
//            response.setContentType(mimeType);
//            OutputStream outputStream = response.getOutputStream();
//            outputStream.write(bytes);
//            outputStream.flush();
//            outputStream.close();
//        }


//    @GetMapping("/")
//    public String home(Model model){
//        List<ImageGallary> images = imageRepository.findAll();
//        model.addAttribute("images",images);
//        return "index";
//    }


