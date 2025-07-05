package com.example.laberinto;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.entes.Personaje;
import com.example.laberinto.mapa.ElementoMapa;
import com.example.laberinto.mapa.Puerta;
import com.example.laberinto.mapa.contenedores.Habitacion;
import com.example.laberinto.mapa.contenedores.Laberinto;
import com.example.laberinto.model.BichoJson;
import com.example.laberinto.model.ElementoMapaJson;
import com.example.laberinto.model.LaberintoJson;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LaberintoBuilder {

    public static void main(String[] args) throws IOException {
        String archivo = args.length > 0 ? args[0] : "C:\\Users\\franc\\OneDrive\\Escritorio\\design-project\\src\\main\\java\\laberinto.json";

        Path path = Paths.get(archivo);
        String jsonInput = Files.readString(path);

        ObjectMapper mapper = new ObjectMapper();
        LaberintoJson labJson = mapper.readValue(jsonInput, LaberintoJson.class);

        // El factory
        Juego juego = new Juego();
        LaberintoFactory factory = new LaberintoFactory();

        Map<Integer, Habitacion> habitaciones = new HashMap<>();

        for (ElementoMapaJson em : labJson.laberinto) {
            // todo: tmb el tipo de habitacion si es que lo tiene, auqnue deberia si está decorada
            Habitacion habitacion = factory.fabricarHabitacion(em.tipo, em.num);

            for (ElementoMapaJson hijo : em.hijos) {
                //TODO: ahora mismo esto no funciona de manera recursiva, como maximo solo puede tener hijos el padre, el hijo no puede tener hijos
                ElementoMapa elementoMapa = factory.fabricarElementoMapa(hijo.elementoMapa, hijo.tipo, hijo.num);
                habitacion.agregarHijo(elementoMapa);
            }
            habitaciones.put(em.num, habitacion);
        }


        for (List<Object> puerta : labJson.puertas) {
            int desde = (Integer) puerta.get(0);
            String dirDesde = (String) puerta.get(1);
            int hasta = (Integer) puerta.get(2);
            String dirHasta = (String) puerta.get(3);


            Puerta p = factory.fabricarPuerta(habitaciones.get(desde), dirDesde, habitaciones.get(hasta), dirHasta);
            habitaciones.get(desde).agregarHijo(p);
            habitaciones.get(hasta).agregarHijo(p);
            habitaciones.get(desde).ponerEn(factory.fabricarOrientacion(dirDesde), p);
            habitaciones.get(hasta).ponerEn(factory.fabricarOrientacion(dirHasta), p);
        }

//        List<Bicho> bichos = new ArrayList<>();

        for (BichoJson bichoJson : labJson.bichos) {
            Bicho bicho = factory.fabricarBicho(bichoJson.modo, habitaciones.get(bichoJson.posicion));
//            bichos.add(bicho);
            juego.agregarBicho(bicho);
        }

//        juego.setBichos(bichos);


        System.out.println("✅ Laberinto construido con " + habitaciones.size() + " habitaciones:");
        for (Habitacion h : habitaciones.values()) {
            System.out.println(h);
        }
        System.out.println(new ArrayList<>(habitaciones.values()));
        juego.getLaberinto().setHijos(new ArrayList<>(habitaciones.values()));
        System.out.println(juego);

        Personaje personaje = new Personaje();
        personaje.setJuego(juego);
        personaje.setNick("Fran");

        juego.setPersonaje(personaje);


        // BICHOS
        juego.puedeLanzarBichos();

        // SOLO SE PUEDE ENTRAR UNA VEZ AL LABERINTO
        Laberinto laberinto = juego.getLaberinto();
        laberinto.entrar(personaje);

        // SI EJECUTAMOS DE NUEVO NO DEJA
        laberinto.entrar(personaje);

        System.out.println("La posicion " + personaje.getPosicion());


        personaje.atacar();


        Habitacion hab1 = (Habitacion) laberinto.getHijos().get(1);
        List<Puerta> puertasHab1 = hab1.getHijos().stream()
                .filter(elemento -> elemento instanceof Puerta)
                .map(elemento -> (Puerta) elemento)
                .collect(Collectors.toList());

        Bicho bicho1 = juego.getBichos().get(0);
        Bicho bicho2 = juego.getBichos().get(1);
        Bicho bicho3 = juego.getBichos().get(2);
        Bicho bicho4 = juego.getBichos().get(3);

//        bicho1.buscarEnemigo();
//        bicho2.buscarEnemigo();
//        bicho3.atacar();
//
//        bicho3.actua();

        // abro la puerta de hab0 - hab1
        puertasHab1.get(0).abrir(personaje);
//        puertasHab1.get(0).setAbierta(true);

        // personaje entra en la habitacion 1
        juego.getLaberinto().getHijos().get(1).entrar(personaje);

        juego.bichoMuere(bicho1);
        juego.bichoMuere(bicho2);
//        juego.bichoMuere(bicho3);
//        juego.bichoMuere(bicho4);
//        personaje.getPosicion().getPadre().getForma().


        // TODO: LOS BICHOS TIENEN QUE ESTAR EN BUCLE ATACANDO Y CUANDO MUERAN TODOS SE ACABA EL JUEGO
        // TODO: SI MUERE EL PERSONAJE SE ACABA EL JUEGO

        juego.bichoMuere(bicho3);
    }

}
