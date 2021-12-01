package src.controller;


import src.service.UserServiceImpl.ResultsServiceImpl;
import src.service.UserServiceImpl.UserScoreServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Autowired
    UserScoreServiceImpl userService;

    @Autowired
    ResultsServiceImpl userServiceResults;



//
//    @Autowired
//    RoleDao roleDao;

    @RequestMapping("/")
    public String home() {
        logger.info("home controller method");
        logger.error("home controller method");

        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {


        return "index";
    }


    @RequestMapping(value = "/login")
    public String login() {


        return "login";
    }

    @RequestMapping(value = "/signup")
    public String signup() {
        ;

        return "signup";
    }

    @RequestMapping(value = "/w")
    public String test() {
        ;

        return "test";
    }











//    @RequestMapping(value = "/signup", method = RequestMethod.GET)
//    public String signup(Model model) {
//        User user = new User();
//
//        model.addAttribute("user", user);
//
//        return "signup";
//    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public String signupPost(@ModelAttribute("user") User user, Model model) {
//
//        if(userService.checkUserExists(user.getUsername(), user.getEmail()))  {
//
//            if (userService.checkEmailExists(user.getEmail())) {
//                model.addAttribute("emailExists", true);
//            }
//
//            if (userService.checkUsernameExists(user.getUsername())) {
//                model.addAttribute("usernameExists", true);
//            }
//
//            return "signup";
//        } else {
//            Set<UserRole> userRoles = new HashSet<>();
//            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
//
//            userService.createUser(user, userRoles);
//
//            userService.save(user);
//            return "redirect:/";
//        }
//    }
//
//    @RequestMapping("/userFront")
//    public String userFront(HttpSession session, Principal principal, Model model) {
//
//        User user = userService.findByUsername(principal.getName());
//        PrimaryAccount primaryAccount = user.getPrimaryAccount();
//        SavingsAccount savingsAccount = user.getSavingsAccount();
//
//        session.setAttribute("mySessionAttribute", user);
//        model.addAttribute("primaryAccount", primaryAccount);
//        model.addAttribute("savingsAccount", savingsAccount);
//
//
//
//        return "userFront";
//    }

    @RequestMapping("/contact")
    public String contact() {

        return "contact";
    }

}
