package com.example.RezeptBuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/") // Basis-URL für den Controller
public class RezeptController {

    @Autowired
    private RezeptService service;

    // Zeigt die Liste der Rezepte an
    @GetMapping
    public String getRezepte(Model model) {
        try {
            model.addAttribute("rezepte", service.findAll());
            return "rezepte"; // Rendert die View "rezepte.html"
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Rendert eine Fehlerseite, falls ein Problem auftritt
        }
    }

    // Fügt ein neues Rezept hinzu
    @PostMapping("/neu")
    public String addRezept(@ModelAttribute Rezept rezept) {
        service.save(rezept);
        return "redirect:/"; // Leitet zurück zur Startseite mit der Liste der Rezepte
    }

    // Löscht ein Rezept basierend auf der ID
    @PostMapping("/loeschen")
    public String deleteRezept(@RequestParam("id") Long id) {
        service.deleteById(id);
        return "redirect:/"; // Leitet zurück zur Startseite mit der Liste der Rezepte
    }
}
