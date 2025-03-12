package com.example.RezeptBuch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezeptService {
    @Autowired
    private RezeptRepository repository;

    public List<Rezept> findAll() {
        return repository.findAll();
    }

    public Rezept save(Rezept rezept) {
        return repository.save(rezept);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
