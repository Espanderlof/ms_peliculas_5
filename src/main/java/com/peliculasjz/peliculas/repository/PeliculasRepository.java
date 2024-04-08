package com.peliculasjz.peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peliculasjz.peliculas.model.Peliculas;

public interface PeliculasRepository extends JpaRepository<Peliculas, Long> {
    
}
