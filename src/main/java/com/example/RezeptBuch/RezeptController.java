package com.example.RezeptBuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/") // Basis-URL für den Controller geändert auf "/"
public class RezeptController {

    @Autowired
    private RezeptService service;

    // Zeigt die Liste der Rezepte an
    @GetMapping("rezepte")
    public String getRezepte(Model model) {
        model.addAttribute("rezepte", service.findAll());
        return "rezepte"; // Rendert die View "rezepte.html"
    }

    // Fügt ein neues Rezept hinzu
    @PostMapping("rezepte/neu")
    public String addRezept(@ModelAttribute Rezept rezept) {
        service.save(rezept);
        return "redirect:/rezepte"; // Leitet zurück zur Liste der Rezepte
    }

    // Löscht ein Rezept basierend auf der ID
    @PostMapping("rezepte/loeschen")
    public String deleteRezept(@RequestParam("id") Long id) {
        service.deleteById(id);
        return "redirect:/rezepte"; // Leitet zurück zur Liste der Rezepte
    }
}

