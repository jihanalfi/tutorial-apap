package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(HttpServletRequest request,
                       Model model
    ){
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.getUser(principal.getName());

        model.addAttribute("role", user.getRole().getRole());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}