package com.peliculasjz.peliculas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.peliculasjz.peliculas.model.Peliculas;
import com.peliculasjz.peliculas.repository.PeliculasRepository;

@ExtendWith(MockitoExtension.class)
public class PeliculasServiceTest {

    @InjectMocks
    private PeliculasServicelmpl peliculasServicio;

    @Mock
    private PeliculasRepository peliculasRepositoryMock;

    @Test
    public void crearPeliculaTest() {
        Peliculas pelicula = new Peliculas();
        pelicula.setTitulo("Película de prueba");
        pelicula.setDirector("Director de prueba");
        pelicula.setYear(2023);

        when(peliculasRepositoryMock.save(any())).thenReturn(pelicula);

        Peliculas peliculaCreada = peliculasServicio.createPeliculas(pelicula);

        assertEquals("Película de prueba", peliculaCreada.getTitulo());
        assertEquals("Director de prueba", peliculaCreada.getDirector());
        assertEquals(2023, peliculaCreada.getYear());
    }
}