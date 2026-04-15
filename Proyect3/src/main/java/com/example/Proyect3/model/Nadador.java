package com.example.Proyect3.model;

import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class Nadador {

        private String nombre;
        private Categoria categoria;
        private Club club;
        private Stack<Integer> tiempos;

        // Constructor vacío
        public Nadador() {
            this.tiempos = new Stack<>();
        }

        // Constructor con nombre, categoría y club
        public Nadador(String nombre, Categoria categoria, Club club) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.club = club;
            this.tiempos = new Stack<>();
        }

        // Setters
        public void setNombre(String nombre) { this.nombre = nombre; }
        public void setCategoria(Categoria categoria) { this.categoria = categoria; }
        public void setClub(Club club) { this.club = club; }
        public void setTiempos(Stack<Integer> tiempos) { this.tiempos = tiempos; }

        // Getters
        public String getNombre() { return nombre; }
        public Categoria getCategoria() { return categoria; }
        public Club getClub() { return club; }
        public Stack<Integer> getTiempos() { return tiempos; }

        // Método para agregar un tiempo al Stack
        public void agregarTiempo(int tiempo) {
            tiempos.push(tiempo);
        }

        // Punto 5: Método que recibe la Function del punto 4 y muestra el total de tiempos
        public int verTotalTiempos(Function<Nadador, Integer> funcion) {
            return funcion.apply(this);
        }

        @Override
        public String toString() {
            return "Nadador{nombre='" + nombre + "', categoria=" + categoria + ", club=" + club + "}";
        }
    }