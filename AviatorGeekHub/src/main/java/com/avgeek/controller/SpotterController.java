package com.avgeek.controller;

import com.avgeek.model.*;
import com.avgeek.repository.*;
import com.avgeek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/spotter")
public class SpotterController {

    @Autowired
    private UserService userService;

    @Autowired
    private SpotterSubmissionRepository spotterSubmissionRepository;

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User spotter = userService.getUserByUsername(auth.getName()).orElse(null);
        
        model.addAttribute("title", "Spotter Hub");
        
        if (spotter != null) {
            model.addAttribute("mySubmissions", spotterSubmissionRepository.findBySpotterOrderBySubmissionDateDesc(spotter));
            model.addAttribute("approvedSightings", spotterSubmissionRepository.findByApproved(true));
        }
        
        return "layout";
    }

    @GetMapping("/sightings")
    public String sightings(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User spotter = userService.getUserByUsername(auth.getName()).orElse(null);
        
        model.addAttribute("title", "My Sightings");
        
        if (spotter != null) {
            model.addAttribute("submissions", spotterSubmissionRepository.findBySpotterOrderBySubmissionDateDesc(spotter));
        }
        
        return "layout";
    }

    @GetMapping("/sightings/add")
    public String addSighting(Model model) {
        model.addAttribute("title", "Add New Sighting");
        return "layout";
    }

    @PostMapping("/sightings/add")
    public String saveSighting(@RequestParam("aircraft") String aircraft,
                              @RequestParam("location") String location,
                              @RequestParam("description") String description,
                              @RequestParam(value = "photo", required = false) MultipartFile photo) {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User spotter = userService.getUserByUsername(auth.getName()).orElse(null);
        
        if (spotter != null) {
            SpotterSubmission submission = new SpotterSubmission(spotter, aircraft, location, description);
            
            if (photo != null && !photo.isEmpty()) {
                try {
                    // Create upload directory if it doesn't exist
                    File uploadDir = new File(UPLOAD_DIR);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs();
                    }
                    
                    // Generate unique filename
                    String originalFilename = photo.getOriginalFilename();
                    String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
                    String filename = UUID.randomUUID().toString() + fileExtension;
                    
                    // Save file
                    Path filePath = Paths.get(UPLOAD_DIR + filename);
                    Files.write(filePath, photo.getBytes());
                    
                    submission.setPhotoPath(filename);
                } catch (IOException e) {
                    // Handle file upload error
                }
            }
            
            spotterSubmissionRepository.save(submission);
        }
        
        return "redirect:/spotter/sightings";
    }

    @PostMapping("/sightings/{id}/delete")
    public String deleteSighting(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User spotter = userService.getUserByUsername(auth.getName()).orElse(null);
        
        SpotterSubmission submission = spotterSubmissionRepository.findById(id).orElse(null);
        if (submission != null && submission.getSpotter().equals(spotter)) {
            spotterSubmissionRepository.deleteById(id);
        }
        
        return "redirect:/spotter/sightings";
    }
}
