package com.peliculasjz.peliculas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Peliculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "year")
    private int year;
    @Column(name = "director")
    private String director;
    @Column(name = "genero")
    private String genero;
    @Column(name = "sinopsis")
    private String sinopsis;

    public Long getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public int getYear(){
        return year;
    }   
    public String getDirector(){
        return director;
    }  
    public String getGenero(){
        return genero;
    }   
    public String getSinopsis(){
        return sinopsis;
    }

    public Long setId(){
        return id;
    }
    public String setTitulo(){
        return titulo;
    }
    public int setYear(){
        return year;
    }   
    public String setDirector(){
        return director;
    }  
    public String setGenero(){
        return genero;
    }   
    public String setSinopsis(){
        return sinopsis;
    }
}
