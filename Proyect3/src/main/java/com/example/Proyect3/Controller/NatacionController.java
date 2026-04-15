package com.example.Proyect3.Controller;



import com.example.Proyect3.Repository.NatacionRepository;
import com.example.Proyect3.model.Club;
import com.example.Proyect3.model.Entrenador;
import com.example.Proyect3.model.Nadador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class NatacionController {

    @Autowired
    private NatacionRepository repository;


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/peticion1")
    public String peticion1(Model model) {

        Stack<Nadador> jugadores   = repository.getJugadores();
        Entrenador entrenador  = repository.getEntrenador();

        model.addAttribute("titulo",     "Petición 1 – Nadadores y Entrenador creados");
        model.addAttribute("jugadores",  jugadores);
        model.addAttribute("entrenador", entrenador);

        return "peticion1";
    }

    @GetMapping("/peticion2")
    public String peticion2(Model model) {

        Stack<Nadador> jugadores  = repository.getJugadores();
        Entrenador     entrenador = repository.getEntrenador();

        List<String> datosListIterator = new ArrayList<>();
        ListIterator<Nadador> listIterator = jugadores.listIterator();
        while (listIterator.hasNext()) {
            Nadador n = listIterator.next();
            datosListIterator.add("Nombre: " + n.getNombre()
                    + " | Categoría: " + n.getCategoria()
                    + " | Club: " + n.getClub());
        }

        List<String> datosIterator = new ArrayList<>();
        Iterator<Nadador> iterator = entrenador.getJugadores().iterator();
        while (iterator.hasNext()) {
            Nadador n = iterator.next();
            datosIterator.add("Nombre: " + n.getNombre()
                    + " | Categoría: " + n.getCategoria()
                    + " | Club: " + n.getClub());
        }

        model.addAttribute("titulo",           "Petición 2 – ListIterator y Iterator");
        model.addAttribute("datosListIterator", datosListIterator);
        model.addAttribute("datosIterator",     datosIterator);

        return "peticion2";
    }


    @GetMapping("/peticion3")
    public String peticion3(Model model) {

        Stack<Nadador> jugadores = repository.getJugadores();

        Deque<Nadador> dequeJugadores = new ArrayDeque<>(jugadores);

        List<String> nombresEnPoseidon = dequeJugadores.stream()
                .filter(n -> n.getClub() == Club.POSEIDON)
                .map(Nadador::getNombre)
                .collect(Collectors.toList());

        List<Nadador> todosEnDeque = new ArrayList<>(dequeJugadores);

        model.addAttribute("titulo",            "Petición 3 – Deque y filtro por club POSEIDON");
        model.addAttribute("todosEnDeque",       todosEnDeque);
        model.addAttribute("nombresEnPoseidon",  nombresEnPoseidon);

        return "peticion3";
    }


    @GetMapping("/peticion4")
    public String peticion4(Model model) {

        Stack<Nadador> jugadores = repository.getJugadores();

        Function<Nadador, Integer> sumarTiempos = nadador -> {
            int total = 0;
            for (int tiempo : nadador.getTiempos()) {
                total += tiempo;
            }
            return total;
        };


        List<String> resultados = new ArrayList<>();
        for (Nadador n : jugadores) {
            int totalTiempos = sumarTiempos.apply(n);
            resultados.add("Nadador: " + n.getNombre() + " → Total tiempos: " + totalTiempos + " seg");
        }

        model.addAttribute("titulo",     "Petición 4 – Function<Nadador, Integer>: suma de tiempos");
        model.addAttribute("resultados", resultados);

        return "peticion4";
    }


    @GetMapping("/peticion5")
    public String peticion5(Model model) {

        Stack<Nadador> jugadores = repository.getJugadores();

        // La misma Function del punto 4
        Function<Nadador, Integer> sumarTiempos = nadador -> {
            int total = 0;
            for (int tiempo : nadador.getTiempos()) {
                total += tiempo;
            }
            return total;
        };

        // Un nadador llama a verTotalTiempos pasando la función
        Nadador nadadorElegido = jugadores.peek(); // primer nadador del Stack
        int totalTiempos = nadadorElegido.verTotalTiempos(sumarTiempos);

        model.addAttribute("titulo",        "Petición 5 – verTotalTiempos() con Function");
        model.addAttribute("nadador",       nadadorElegido);
        model.addAttribute("totalTiempos",  totalTiempos);

        return "peticion5";
    }
}