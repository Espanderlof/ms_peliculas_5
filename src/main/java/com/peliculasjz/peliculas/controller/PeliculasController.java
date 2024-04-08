package com.peliculasjz.peliculas.controller;

import java.util.List;
import java.util.Optional;

import com.peliculasjz.peliculas.model.Peliculas;
import com.peliculasjz.peliculas.service.PeliculasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/peliculas")
public class PeliculasController {
    @Autowired
    private PeliculasService peliculasService;

    @GetMapping
    public List<Peliculas> getAllPeliculas() {
        return peliculasService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<Peliculas> getPeliculasById(@PathVariable Long id){
        return peliculasService.getPeliculasById(id);
    }

    @PostMapping
    public Peliculas creaPeliculas(@RequestBody Peliculas pelicula) {
        return peliculasService.createPeliculas(pelicula);
    }

    @PutMapping("/{id}")
    public Peliculas updatePeliculas(@PathVariable Long id, @RequestBody Peliculas peliculas) {
        return peliculasService.updatePeliculas(id, peliculas);
    }

    @DeleteMapping("/{id}")
    public void deletePeliculas(@PathVariable Long id){
        peliculasService.deletePeliculas(id);
    }
    
}
