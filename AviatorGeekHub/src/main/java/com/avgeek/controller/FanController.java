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

import java.util.List;

@Controller
@RequestMapping("/fan")
public class FanController {

    @Autowired
    private UserService userService;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FavouriteRepository favouriteRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User fan = userService.getUserByUsername(auth.getName()).orElse(null);
        
        model.addAttribute("title", "Fan Flights");
        model.addAttribute("flights", flightRepository.findAll());
        
        if (fan != null) {
            List<Favourite> favourites = favouriteRepository.findByFan(fan);
            model.addAttribute("favourites", favourites);
        }
        
        return "layout";
    }

    @GetMapping("/flights")
    public String flights(Model model) {
        model.addAttribute("title", "Browse Flights");
        model.addAttribute("flights", flightRepository.findAll());
        return "layout";
    }

    @GetMapping("/favourites")
    public String favourites(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User fan = userService.getUserByUsername(auth.getName()).orElse(null);
        
        model.addAttribute("title", "My Favourites");
        
        if (fan != null) {
            model.addAttribute("favourites", favouriteRepository.findByFan(fan));
        }
        
        return "layout";
    }

    @PostMapping("/favourite")
    public String addFavourite(@RequestParam("flightId") Long flightId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User fan = userService.getUserByUsername(auth.getName()).orElse(null);
        
        if (fan != null) {
            Flight flight = flightRepository.findById(flightId).orElse(null);
            if (flight != null && !favouriteRepository.existsByFanAndFlightId(fan, flightId)) {
                Favourite favourite = new Favourite(fan, flight);
                favouriteRepository.save(favourite);
            }
        }
        
        return "redirect:/fan/dashboard";
    }

    @PostMapping("/favourite/{id}/remove")
    public String removeFavourite(@PathVariable Long id) {
        favouriteRepository.deleteById(id);
        return "redirect:/fan/favourites";
    }
}
