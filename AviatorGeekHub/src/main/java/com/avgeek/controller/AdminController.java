package com.avgeek.controller;

import com.avgeek.model.*;
import com.avgeek.repository.*;
import com.avgeek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private SpotterSubmissionRepository spotterSubmissionRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("title", "Admin Dashboard");
        
        // Add statistics
        model.addAttribute("totalUsers", userService.getAllUsers().size());
        model.addAttribute("totalFlights", flightRepository.count());
        model.addAttribute("pendingSubmissions", spotterSubmissionRepository.findByApproved(false).size());
        model.addAttribute("totalResources", resourceRepository.count());
        
        return "layout";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("title", "Manage Users");
        model.addAttribute("users", userService.getAllUsers());
        return "layout";
    }

    @GetMapping("/flights")
    public String flights(Model model) {
        model.addAttribute("title", "Manage Flights");
        model.addAttribute("flights", flightRepository.findAll());
        return "layout";
    }

    @GetMapping("/sightings")
    public String sightings(Model model) {
        model.addAttribute("title", "Manage Sightings");
        model.addAttribute("submissions", spotterSubmissionRepository.findAll());
        return "layout";
    }

    @GetMapping("/resources")
    public String resources(Model model) {
        model.addAttribute("title", "Manage Resources");
        model.addAttribute("resources", resourceRepository.findAll());
        return "layout";
    }

    @PostMapping("/sightings/{id}/approve")
    public String approveSighting(@PathVariable Long id) {
        SpotterSubmission submission = spotterSubmissionRepository.findById(id).orElse(null);
        if (submission != null) {
            submission.setApproved(true);
            spotterSubmissionRepository.save(submission);
        }
        return "redirect:/admin/sightings";
    }

    @PostMapping("/sightings/{id}/reject")
    public String rejectSighting(@PathVariable Long id) {
        spotterSubmissionRepository.deleteById(id);
        return "redirect:/admin/sightings";
    }
}
