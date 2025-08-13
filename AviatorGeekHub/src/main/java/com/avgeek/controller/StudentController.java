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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("title", "Student Resources");
        model.addAttribute("resources", resourceRepository.findAll());
        model.addAttribute("quizzes", quizRepository.findAll());
        return "layout";
    }

    @GetMapping("/resources")
    public String resources(Model model) {
        model.addAttribute("title", "Learning Resources");
        model.addAttribute("resources", resourceRepository.findAll());
        return "layout";
    }

    @GetMapping("/quiz")
    public String quiz(Model model) {
        model.addAttribute("title", "Take Quiz");
        model.addAttribute("quizzes", quizRepository.findAll());
        return "layout";
    }

    @PostMapping("/quiz/submit")
    public String submitQuiz(@RequestParam("answers") String[] answers, Model model) {
        List<Quiz> quizzes = quizRepository.findAll();
        int correctAnswers = 0;
        int totalQuestions = quizzes.size();
        
        for (int i = 0; i < Math.min(answers.length, totalQuestions); i++) {
            Quiz quiz = quizzes.get(i);
            if (quiz.getCorrectAnswer().equals(answers[i])) {
                correctAnswers++;
            }
        }
        
        double score = (double) correctAnswers / totalQuestions * 100;
        
        model.addAttribute("title", "Quiz Results");
        model.addAttribute("score", score);
        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("totalQuestions", totalQuestions);
        
        return "layout";
    }
}
