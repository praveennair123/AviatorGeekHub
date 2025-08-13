package com.avgeek.controller;

import com.avgeek.model.User;
import com.avgeek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        User user = userService.getUserByUsername(username).orElse(null);
        if (user == null) {
            return "redirect:/login";
        }

        switch (user.getRole()) {
            case ADMIN:
                return "redirect:/admin/dashboard";
            case PILOT:
                return "redirect:/pilot/dashboard";
            case SPOTTER:
                return "redirect:/spotter/dashboard";
            case STUDENT:
                return "redirect:/student/dashboard";
            case FAN:
                return "redirect:/fan/dashboard";
            default:
                return "redirect:/login";
        }
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }
}
