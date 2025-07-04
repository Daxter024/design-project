package com.example.laberinto;

import com.example.laberinto.entes.Bicho;
import com.example.laberinto.entes.Personaje;
import com.example.laberinto.formas.orientaciones.Este;
import com.example.laberinto.formas.orientaciones.Norte;
import com.example.laberinto.formas.orientaciones.Oeste;
import com.example.laberinto.formas.orientaciones.Sur;
import com.example.laberinto.mapa.Pared;
import com.example.laberinto.mapa.Puerta;
import com.example.laberinto.mapa.contenedores.Armario;
import com.example.laberinto.mapa.contenedores.Habitacion;
import com.example.laberinto.mapa.contenedores.Laberinto;
import com.example.laberinto.mapa.hojas.decoradores.Bomba;
import com.example.laberinto.modos.Agresivo;
import com.example.laberinto.modos.Perezoso;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Data
public class Juego {

    private List<Bicho> bichos;
    private ConcurrentHashMap<Bicho, Future<?>> hilos;
    private Laberinto laberinto;
    private Personaje personaje;
    private ExecutorService executor = Executors.newCachedThreadPool();

    public Juego() {
        this.bichos = new ArrayList<>();
        this.hilos = new ConcurrentHashMap<>();
        this.laberinto = new Laberinto();
    }

    /**
     * Factory
     **/

    // Mapa
    public Puerta fabricarPuerta() {
        return new Puerta();
    }

    public Pared fabricarPared() {
        return new Pared();
    }

    public Pared fabricarParedBomba() {
        Pared pared = new Pared();
        Bomba bomba = new Bomba();
        bomba.decorar(pared);
        return pared;
    }

    public Bomba fabricarBomba() {
        return new Bomba();
    }

    public Habitacion fabricarHabitacion(int num) {
        Habitacion habitacion = new Habitacion(num);
        Norte norte = fabricarNorte();
        Oeste oeste = fabricarOeste();
        Sur sur = fabricarSur();
        Este este = fabricarEste();


        habitacion.ponerEn(norte, fabricarPared());
        habitacion.ponerEn(sur, fabricarPared());
        habitacion.ponerEn(este, fabricarPared());
        habitacion.ponerEn(oeste, fabricarPared());

        habitacion.agregarOrientacion(norte);
        habitacion.agregarOrientacion(sur);
        habitacion.agregarOrientacion(este);
        habitacion.agregarOrientacion(oeste);

        return habitacion;
    }

    public Laberinto fabricarLaberinto() {
        return new Laberinto();
    }

    public Armario fabricarArmario(int num) {
        return new Armario(num);
    }

    // Orientaciones

    public Norte fabricarNorte() {
        return new Norte();
    }

    public Sur fabricarSur() {
        return new Sur();
    }

    public Este fabricarEste() {
        return new Este();
    }

    public Oeste fabricarOeste() {
        return new Oeste();
    }

    // Modos

    public Perezoso fabricarPerezoso() {
        return new Perezoso();
    }

    public Agresivo fabricarAgresivo() {
        return new Agresivo();
    }

    // Entidades

    public Bicho fabricarBicho() {
        return new Bicho();
    }

    public Bicho fabricarBicho(Habitacion habitacion) {
        Bicho bicho = fabricarBicho();
        bicho.setPosicion(habitacion);
        return bicho;
    }

    public Bicho fabricarBichoPerezoso() {
        Bicho bicho = new Bicho();
        bicho.setModo(fabricarPerezoso());
        bicho.setVidas(5);
        bicho.setPoder(0);
        return bicho;
    }

    public Bicho fabricarBichoPerezoso(Habitacion habitacion) {
        Bicho bicho = fabricarBichoPerezoso();
        bicho.setPosicion(habitacion);
        return bicho;
    }

    public Bicho fabricarBichoAgresivo() {
        Bicho bicho = new Bicho();
        bicho.setModo(fabricarAgresivo());
        bicho.setVidas(5);
        bicho.setPoder(1);
        return bicho;
    }

    public Bicho fabricarBichoAgresivo(Habitacion habitacion) {
        Bicho bicho = fabricarBichoAgresivo();
        bicho.setPosicion(habitacion);
        return bicho;
    }

    public Personaje fabricarPersonaje() {
        return new Personaje();
    }


    public void abrirPuertas() {
        laberinto.recorrer(em -> {
            if (em instanceof Puerta) {
                ((Puerta) em).abrir(personaje);
            }
        });
    }

    public void activarBombas() {
        laberinto.recorrer(em -> {
            if (em instanceof Bomba) {
                ((Bomba) em).activar();
            }
        });
    }

}
