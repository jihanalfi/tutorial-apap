package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        if (userService.checkPassword(user.getPassword())){
            userService.addUser(user);
        } else {
            List<RoleModel> listRole = roleService.findAll();
            model.addAttribute("message", "password harus mengandung minimal 1 angka, 1 huruf besar, 1 huruf kecil, 1 simbol, dan lebih dari 8 karakter.");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("nama", user.getNama());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("listRole", listRole);
            return "form-add-user";
        }
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value = "/viewall")
    private String viewAllUser(Model model){
        List<UserModel> listUser = userService.getAllUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping(value = "/delete/{username}")
    private String deleteUser(
            @PathVariable String username,
            Model model){
        UserModel user = userService.getUser(username);
        if (user == null){
            return "error-notfound";
        }
        model.addAttribute("username", username);
        return "delete-user";
    }

    @PostMapping(value = "/delete")
    private String deleteUserSubmit(
            @ModelAttribute UserModel user,
            Model model){
        userService.deleteUser(user);
        model.addAttribute("username", user.getUsername());
        return "delete-user";
    }

    @GetMapping(value = "/change-password")
    private String updatePassword(Model model){
        return "form-update-password";
    }

    @PostMapping(value = "/change-password")
    public String updatePasswordSubmit(
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "confirmNewPassword") String confirmNewPassword,
            HttpServletRequest request,
            Model model){
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.getUser(principal.getName());

        if (!newPassword.equals(confirmNewPassword)) {
            model.addAttribute("notif_gagal", "Password baru tidak cocok, mohon input ulang");
            return "update-password";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            boolean pw = userService.checkPassword(newPassword);
            if(pw == true){
                userService.updatePassword(user, newPassword);
                model.addAttribute("message", "Password berhasil diubah");
            }else if(pw == false){
                model.addAttribute("message", "Password tidak valid");
            }
        }
        else {
            model.addAttribute("message", "Password lama tidak cocok, mohon input ulang");
            return "update-password";
        }

        if (newPassword.equals(oldPassword)){
            model.addAttribute("message", "Password baru tidak boleh sama dengan password lama");
            return "update-password";
        }
        return "update-password";
    }
}