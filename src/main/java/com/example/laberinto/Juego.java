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
import com.example.laberinto.mapa.contenedores.Cofre;
import com.example.laberinto.mapa.contenedores.Habitacion;
import com.example.laberinto.mapa.contenedores.Laberinto;
import com.example.laberinto.mapa.hojas.decoradores.Bomba;
import com.example.laberinto.modos.Agresivo;
import com.example.laberinto.modos.Canibal;
import com.example.laberinto.modos.Patrulla;
import com.example.laberinto.modos.Perezoso;
import com.example.laberinto.tipos.Curativo;
import com.example.laberinto.tipos.Venenoso;
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

    public Cofre fabricarCofre(int num) {
        return new Cofre(num);
    }

    public Curativo fabricarCurativo() {
        return new Curativo();
    }

    public Venenoso fabricarVenenoso() {
        return new Venenoso();
    }

    public Cofre fabricarCofreCurativo(int num) {
        Cofre cofre = fabricarCofre(num);
        cofre.setTipo(fabricarCurativo());
        return cofre;
    }

    public Cofre fabricarCofreVenenoso(int num) {
        Cofre cofre = fabricarCofre(num);
        cofre.setTipo(fabricarVenenoso());
        return cofre;
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

    public Patrulla fabricarPatrulla() {
        return new Patrulla();
    }

    public Canibal fabricarCanibal() {
        return new Canibal();
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

    public Bicho fabricarBichoPatrulla() {
        Bicho bicho = new Bicho();
        bicho.setModo(fabricarPatrulla());
        bicho.setVidas(10);
        bicho.setPoder(2);
        return bicho;
    }

    public Bicho fabricarBichoPatrulla(Habitacion habitacion) {
        Bicho bicho = fabricarBichoPatrulla();
        bicho.setPosicion(habitacion);
        return bicho;
    }

    public Bicho fabricarBichoCanibal() {
        Bicho bicho = new Bicho();
        bicho.setModo(fabricarCanibal());
        bicho.setVidas(4);
        bicho.setPoder(10);
        return bicho;
    }

    public Bicho fabricarBichoCanibal(Habitacion habitacion) {
        Bicho bicho = fabricarBichoCanibal();
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

    /**
     * Busqueda
     **/

    public Bicho buscarBicho() {
        return bichos.stream()
                .filter(Bicho::estaVivo)
                .filter(b -> b.getPosicion().equals(personaje.getPosicion()))
                .findFirst()
                .orElse(null);
    }

    public Personaje buscarPersonaje(Bicho bicho) {
        if (personaje != null && personaje.getPosicion().equals(bicho.getPosicion())) {
            System.out.println("personaje encontrado");
            return personaje;
        }
        return null;
    }

    /**
     * Hilos
     **/

    public void agregarBicho(Bicho bicho) {
        this.bichos.add(bicho);
        bicho.setJuego(this);
    }

    public void lanzarHilo(Bicho bicho) {
        Future<?> future = executor.submit(() -> {
            while (bicho.estaVivo()) {
                bicho.actua();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println("Hilo bicho terminado");
                    break;
                }
            }
            System.out.println("Hilo de bicho terminado: " + bicho.getClass().getSimpleName() + " (muerto).");
        });
        agregarHilo(bicho, future);
    }

    public void terminarHilo(Bicho bicho) {
        Future<?> future = hilos.remove(bicho);
        if (future != null) {
            future.cancel(true);
            bicho.heMuerto();
        }
    }

    public void puedeLanzarBichos() {
        this.bichos.forEach(this::lanzarHilo);
    }

    public void terminarBichos() {
        this.bichos.forEach(this::terminarHilo);
    }

    public void muereBicho(Bicho bicho) {
        System.out.println("Bicho ha muerto");
        terminarHilo(bicho);
    }

    public boolean todosMuertos() {
        return bichos.stream().noneMatch(Bicho::estaVivo);
    }

    public void agregarHilo(Bicho bicho, Future<?> hiloFuture) {
        this.hilos.put(bicho, hiloFuture);
    }

    public void agregarPersonaje(Personaje pj) {

    }

    public void bichoMuere(Bicho bicho) {
        System.out.println("Un bicho ha muerto");
        terminarHilo(bicho);
        if (todosMuertos()) {
            finJuego("GANASTE. FINAL DEL JUEGO");
        }
    }

    public void personajeMuere() {
        System.out.println("Personaje ha muerto");
        finJuego("PERSONAJE PRINCIPAL HA MUERTO. FIN DEL JUEGO");
    }

    public void finJuego(String msg) {
        System.out.println(msg);
        terminarBichos();
        executor.shutdownNow();
    }
}
