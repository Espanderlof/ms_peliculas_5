package com.peliculasjz.peliculas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.peliculasjz.peliculas.model.Peliculas;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculasRepositoryTest {

    @Autowired
    private PeliculasRepository peliculasRepository;

    @Test
    public void guardarPeliculaTest() {
        Peliculas pelicula = new Peliculas();
        pelicula.setTitulo("Película de prueba");
        pelicula.setDirector("Director de prueba");
        pelicula.setYear(2023);

        Peliculas peliculaGuardada = peliculasRepository.save(pelicula);

        assertNotNull(peliculaGuardada.getId());
        assertEquals("Película de prueba", peliculaGuardada.getTitulo());
        assertEquals("Director de prueba", peliculaGuardada.getDirector());
        assertEquals(2023, peliculaGuardada.getYear());
    }
}