package uk.co.breschbrothers.fencingcalc.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import uk.co.breschbrothers.fencingcalc.entity.Admin;
import uk.co.breschbrothers.fencingcalc.repositories.AdminRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@SessionAttributes("username")
public class AdminController {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminController(final AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    public String validateLogin(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (checkAdminData(username, password)) {
            model.addAttribute("username", username);
            return "redirect:/admin";
        } else {
            return "login";
        }
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin";
    }

    private boolean checkAdminData(String username, String password) {
        Optional<Admin> adminList = adminRepository.findById((long) 1);
        Admin admin = adminList.orElse(null);
        if (admin.getUsername().equals(username) && BCrypt.checkpw(password, admin.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
