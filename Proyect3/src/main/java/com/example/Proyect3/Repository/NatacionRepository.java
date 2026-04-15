package com.example.Proyect3.Repository;


import com.example.Proyect3.model.Categoria;
import com.example.Proyect3.model.Club;
import com.example.Proyect3.model.Entrenador;
import com.example.Proyect3.model.Nadador;
import org.springframework.stereotype.Repository;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

@Repository
public class NatacionRepository {

    private Stack<Nadador> jugadores;
    private Entrenador entrenador;

    public NatacionRepository() {
        inicializarDatos();
    }

    private void inicializarDatos() {

        // -------------------------------------------------------
        // Punto 1: Crear 5 nadadores del club ACUATICOS_MEDELLIN, categoría JUNIOR
        // Asignar tiempos (en segundos) de las últimas 5 competencias
        // -------------------------------------------------------

        Nadador n1 = new Nadador("Carlos Ríos", Categoria.JUNIOR, Club.ACUATICOS_MEDELLIN);
        n1.agregarTiempo(52);
        n1.agregarTiempo(49);
        n1.agregarTiempo(51);
        n1.agregarTiempo(48);
        n1.agregarTiempo(50);

        Nadador n2 = new Nadador("Sofía Vargas", Categoria.JUNIOR, Club.ACUATICOS_MEDELLIN);
        n2.agregarTiempo(55);
        n2.agregarTiempo(53);
        n2.agregarTiempo(54);
        n2.agregarTiempo(52);
        n2.agregarTiempo(56);

        Nadador n3 = new Nadador("Andrés Mejía", Categoria.JUNIOR, Club.ACUATICOS_MEDELLIN);
        n3.agregarTiempo(47);
        n3.agregarTiempo(46);
        n3.agregarTiempo(48);
        n3.agregarTiempo(45);
        n3.agregarTiempo(47);

        Nadador n4 = new Nadador("Valentina Cruz", Categoria.JUNIOR, Club.ACUATICOS_MEDELLIN);
        n4.agregarTiempo(60);
        n4.agregarTiempo(58);
        n4.agregarTiempo(59);
        n4.agregarTiempo(57);
        n4.agregarTiempo(61);

        Nadador n5 = new Nadador("Luis Herrera", Categoria.JUNIOR, Club.ACUATICOS_MEDELLIN);
        n5.agregarTiempo(44);
        n5.agregarTiempo(43);
        n5.agregarTiempo(45);
        n5.agregarTiempo(42);
        n5.agregarTiempo(44);

        // Stack de jugadores con los 5 nadadores
        jugadores = new Stack<>();
        jugadores.push(n1);
        jugadores.push(n2);
        jugadores.push(n3);
        jugadores.push(n4);
        jugadores.push(n5);

        // -------------------------------------------------------
        // Punto 1: Crear un entrenador del club ACUATICOS_MEDELLIN, categoría JUNIOR
        // Asignar los 5 nadadores al Deque del entrenador
        // -------------------------------------------------------
        entrenador = new Entrenador("Marco Salazar", Categoria.JUNIOR, Club.ACUATICOS_MEDELLIN, 12);
        entrenador.getJugadores().add(n1);
        entrenador.getJugadores().add(n2);
        entrenador.getJugadores().add(n3);
        entrenador.getJugadores().add(n4);
        entrenador.getJugadores().add(n5);
    }

    public Stack<Nadador> getJugadores() { return jugadores; }
    public Entrenador getEntrenador() { return entrenador; }
}