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

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/pilot")
public class PilotController {

    @Autowired
    private UserService userService;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private LogbookEntryRepository logbookEntryRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User pilot = userService.getUserByUsername(auth.getName()).orElse(null);
        
        model.addAttribute("title", "Pilot Dashboard");
        model.addAttribute("flights", flightRepository.findAll());
        model.addAttribute("pilot", pilot);
        
        if (pilot != null) {
            List<LogbookEntry> recentEntries = logbookEntryRepository.findByPilotOrderByFlightDateDesc(pilot);
            model.addAttribute("recentEntries", recentEntries.subList(0, Math.min(recentEntries.size(), 5)));
        }
        
        return "layout";
    }

    @GetMapping("/logbook")
    public String logbook(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User pilot = userService.getUserByUsername(auth.getName()).orElse(null);
        
        model.addAttribute("title", "Pilot Logbook");
        
        if (pilot != null) {
            model.addAttribute("entries", logbookEntryRepository.findByPilotOrderByFlightDateDesc(pilot));
        }
        
        return "layout";
    }

    @GetMapping("/logbook/add")
    public String addLogbookEntry(Model model) {
        model.addAttribute("title", "Add Logbook Entry");
        model.addAttribute("entry", new LogbookEntry());
        return "layout";
    }

    @PostMapping("/logbook/add")
    public String saveLogbookEntry(@ModelAttribute LogbookEntry entry) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User pilot = userService.getUserByUsername(auth.getName()).orElse(null);
        
        if (pilot != null) {
            entry.setPilot(pilot);
            logbookEntryRepository.save(entry);
        }
        
        return "redirect:/pilot/logbook";
    }

    @PostMapping("/logbook/{id}/delete")
    public String deleteLogbookEntry(@PathVariable Long id) {
        logbookEntryRepository.deleteById(id);
        return "redirect:/pilot/logbook";
    }
}
