package src.controller;

import src.domain.UserScore;
import src.service.UserServiceImpl.ResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class ResultController {


    @Autowired
    ResultsServiceImpl userServiceResults;


    @RequestMapping("/resultsPage")
    public String primaryAccount(Model model) {


        List<UserScore> resultListMan=userServiceResults.findByDivision("Man");
        List<UserScore> resultListWoman=userServiceResults.findByDivision("Woman");

        Collections.sort(resultListMan, Collections.reverseOrder());
        Collections.sort(resultListWoman, Collections.reverseOrder());

        long man = 1;

        for (UserScore ResultList : resultListMan) {

            ResultList.setNumber(man++);

            System.out.println(ResultList.getNumber());
        }

        long woman = 1;
        for (UserScore ResultList : resultListWoman) {

            ResultList.setNumber(woman++);

            System.out.println(ResultList.getNumber());
        }

        model.addAttribute("resultListMan", resultListMan);
        model.addAttribute("resultListWoman", resultListWoman);

        return "resultsPage";
    }
//    @RequestMapping(value = "/submitScore", method = RequestMethod.GET)
//    public String submitScore(Model model) {
//        UserScore userScore = new UserScore();
//        model.addAttribute("userScore", userScore);
//
//        return "submitScore";
//    }

    @RequestMapping(value="test/id", method = RequestMethod.POST)
    public void  deleteUser (@RequestParam Long id) {

        System.out.println("asdasdasdasd   " + id);
    }


//    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
//    public void getImage(HttpServletResponse response, @PathVariable long id) throws Exception {
//
//        System.out.println(id+ "asdasdasdasdasdasdasd");
//
//        List<UserScore> resultListMan=userServiceResults.findByDivision("Man");
//
//        for (UserScore ResultList : resultListMan) {
//
//            byte[] img = ResultList.getPicture();
//
//            System.out.println(ResultList.getNumber());
//
//
//
//
//            InputStream is = new BufferedInputStream(new ByteArrayInputStream(img));
//            String mimeType = URLConnection.guessContentTypeFromStream(is);
//            response.setContentType(mimeType);
//            OutputStream outputStream = response.getOutputStream();
//            outputStream.write(img);
//            outputStream.flush();
//            outputStream.close();
//        }
//    }


}
