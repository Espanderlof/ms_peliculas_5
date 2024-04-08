package com.peliculasjz.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peliculasjz.peliculas.model.Peliculas;
import com.peliculasjz.peliculas.repository.PeliculasRepository;

@Service
public class PeliculasServicelmpl implements PeliculasService{
    @Autowired
    private PeliculasRepository peliculasRepository;

    @Override
    public List<Peliculas> getAllPeliculas(){
        return peliculasRepository.findAll();
    }

    @Override
    public Optional<Peliculas> getPeliculasById(Long id){
        return peliculasRepository.findById(id);
    }
}
