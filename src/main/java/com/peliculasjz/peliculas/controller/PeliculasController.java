package com.peliculasjz.peliculas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peliculasjz.peliculas.model.Peliculas;
import com.peliculasjz.peliculas.service.PeliculasService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/peliculas")
public class PeliculasController {

    private static final Logger log = LoggerFactory.getLogger(PeliculasController.class);

    @Autowired
    private PeliculasService peliculasService;

    // @GetMapping
    // public List<Peliculas> getAllPeliculas() {
    //     return peliculasService.getAllPeliculas();
    // }

    @GetMapping
    public CollectionModel<EntityModel<Peliculas>> getAllPeliculas() {
        List<Peliculas> peliculas = peliculasService.getAllPeliculas();
        log.info("GET /peliculas");
        log.info("Retornando todas las películas");
        List<EntityModel<Peliculas>> peliculasResources = peliculas.stream()
            .map(pelicula -> EntityModel.of(pelicula,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculasById(pelicula.getId())).withSelfRel()
            ))
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas());
        CollectionModel<EntityModel<Peliculas>> resources = CollectionModel.of(peliculasResources, linkTo.withRel("peliculas"));

        return resources;
    }

    // @GetMapping("/{id}")
    // public Optional<Peliculas> getPeliculasById(@PathVariable Long id){
    //     return peliculasService.getPeliculasById(id);
    // }

    @GetMapping("/{id}")
    public EntityModel<Peliculas> getPeliculasById(@PathVariable Long id) {
        Optional<Peliculas> pelicula = peliculasService.getPeliculasById(id);

        if (pelicula.isPresent()) {
            return EntityModel.of(pelicula.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculasById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-peliculas"));
        } else {
            throw new PeliculasNotFoundException("Película no encontrada con id: " + id);
        }
    }

    // @PostMapping
    // public Peliculas creaPeliculas(@RequestBody Peliculas pelicula) {
    //     return peliculasService.createPeliculas(pelicula);
    // }

    @PostMapping
    public EntityModel<Peliculas> creaPeliculas(@RequestBody Peliculas pelicula) {
        Peliculas peliculaCreada = peliculasService.createPeliculas(pelicula);
        return EntityModel.of(peliculaCreada,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculasById(peliculaCreada.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-peliculas"));
    }

    // @PutMapping("/{id}")
    // public Peliculas updatePeliculas(@PathVariable Long id, @RequestBody Peliculas peliculas) {
    //     return peliculasService.updatePeliculas(id, peliculas);
    // }

    @PutMapping("/{id}")
    public EntityModel<Peliculas> updatePeliculas(@PathVariable Long id, @RequestBody Peliculas pelicula) {
        Peliculas peliculaActualizada = peliculasService.updatePeliculas(id, pelicula);
        return EntityModel.of(peliculaActualizada,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculasById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-peliculas"));
    }    

    // @DeleteMapping("/{id}")
    // public void deletePeliculas(@PathVariable Long id){
    //     peliculasService.deletePeliculas(id);
    // }
    
    @DeleteMapping("/{id}")
    public void deletePeliculas(@PathVariable Long id) {
        peliculasService.deletePeliculas(id);
    }

    static class PeliculaNotFoundException extends RuntimeException {
        public PeliculaNotFoundException(String message) {
            super(message);
        }
    }
    
}
