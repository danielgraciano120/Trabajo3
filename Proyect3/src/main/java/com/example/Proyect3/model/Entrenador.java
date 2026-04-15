package com.example.Proyect3.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Entrenador {

    private String nombre;
    private Categoria categoria;
    private Club club;
    private int competenciasGanadas;
    private Deque<Nadador> jugadores;

    // Constructor vacío
    public Entrenador() {
        this.jugadores = new ArrayDeque<>();
    }

    // Constructor con nombre, categoría, club y competencias ganadas
    public Entrenador(String nombre, Categoria categoria, Club club, int competenciasGanadas) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.club = club;
        this.competenciasGanadas = competenciasGanadas;
        this.jugadores = new ArrayDeque<>();
    }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setClub(Club club) { this.club = club; }
    public void setCompetenciasGanadas(int competenciasGanadas) { this.competenciasGanadas = competenciasGanadas; }
    public void setJugadores(Deque<Nadador> jugadores) { this.jugadores = jugadores; }

    // Getters
    public String getNombre() { return nombre; }
    public Categoria getCategoria() { return categoria; }
    public Club getClub() { return club; }
    public int getCompetenciasGanadas() { return competenciasGanadas; }
    public Deque<Nadador> getJugadores() { return jugadores; }

    @Override
    public String toString() {
        return "Entrenador{nombre='" + nombre + "', categoria=" + categoria + ", club=" + club + "}";
    }
}