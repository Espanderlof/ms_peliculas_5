package com.peliculasjz.peliculas.controller;

import com.peliculasjz.peliculas.model.Peliculas;
import com.peliculasjz.peliculas.service.PeliculasService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(PeliculasController.class)
public class PeliculasControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculasService peliculasServiceMock;

    @Test
    public void obtenerTodasPeliculasTest() throws Exception {
        Peliculas pelicula1 = new Peliculas();
        pelicula1.setId(1L);
        pelicula1.setTitulo("Película 1");

        Peliculas pelicula2 = new Peliculas();
        pelicula2.setId(2L);
        pelicula2.setTitulo("Película 2");

        List<Peliculas> peliculas = Arrays.asList(pelicula1, pelicula2);

        when(peliculasServiceMock.getAllPeliculas()).thenReturn(peliculas);

        mockMvc.perform(MockMvcRequestBuilders.get("/peliculas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].titulo", Matchers.is("Película 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].titulo", Matchers.is("Película 2")));
    }

}
