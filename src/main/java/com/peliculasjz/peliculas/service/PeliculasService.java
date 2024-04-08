package com.peliculasjz.peliculas.service;

import java.util.List;
import java.util.Optional;

import com.peliculasjz.peliculas.model.Peliculas;

public interface PeliculasService {
    List<Peliculas> getAllPeliculas();
    Optional<Peliculas> getPeliculasById(Long id);
    Peliculas createPelicula(Peliculas pelicula);
    Peliculas updatePelicula(Long id, Peliculas pelicula);
    void deletePelicula(Long id);
}
