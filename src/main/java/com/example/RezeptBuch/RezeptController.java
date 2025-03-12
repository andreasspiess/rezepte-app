package com.example.RezeptBuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rezepte")
public class RezeptController {
    @Autowired
    private RezeptService service;

    @GetMapping
    public String getRezepte(Model model) {
        model.addAttribute("rezepte", service.findAll());
        return "rezepte";
    }

    @PostMapping("/neu")
    public String addRezept(@ModelAttribute Rezept rezept) {
        service.save(rezept);
        return "redirect:/rezepte";
    }

    @PostMapping("/loeschen")
    public String deleteRezept(@RequestParam("id") Long id) {
        service.deleteById(id);
        return "redirect:/rezepte";
    }
}
