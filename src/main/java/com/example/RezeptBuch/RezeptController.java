package com.example.RezeptBuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RezeptController {

    @Autowired
    private RezeptService service;

    @GetMapping
    public String getRezepte(Model model) {
        model.addAttribute("rezepte", service.findAll());
        return "rezepte"; // Rendert die View "rezepte.html"
    }

    @PostMapping("/neu")
    public String addRezept(@ModelAttribute Rezept rezept) {
        service.save(rezept);
        return "redirect:/";
    }

    @PostMapping("/loeschen")
    public String deleteRezept(@RequestParam("id") Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}

