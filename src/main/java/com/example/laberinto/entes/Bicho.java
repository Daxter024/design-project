package com.example.laberinto.entes;

import com.example.laberinto.estados.Muerto;
import com.example.laberinto.formas.orientaciones.Orientacion;
import com.example.laberinto.mapa.Puerta;
import com.example.laberinto.mapa.contenedores.Habitacion;
import com.example.laberinto.modos.Canibal;
import com.example.laberinto.modos.Modo;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Bicho extends Ente {

    protected Modo modo;

    public Bicho() {
        super();
    }

    // Deberia estar en bucle, es el algoritmo de template
    // bicho.actua() -> estado.actua(unBicho) -> unBicho.puedeActuar() -> this.modo.actua(this) -> atacar,dormir,caminar
    public void actua() {
        this.estado.actua(this);
    }

    public void puedeActuar() {
        if (this.modo != null) {
            this.modo.actua(this);
        }
    }

    @Override
    public void heMuerto() {
        this.estado = new Muerto();
        if (this.juego != null) {
            this.juego.bichoMuere(this);
        }
    }

    @Override
    public Ente buscarEnemigo() {
        if (this.juego != null) {
            if (this.modo instanceof Canibal) return juego.buscarBicho();
            return juego.buscarPersonaje(this);
        }
        return null;
    }

    public void caminar() {
        Habitacion habitacion = (Habitacion) this.getPosicion();
        List<Puerta> puertasHab1 = habitacion.getHijos().stream()
                .filter(elemento -> elemento instanceof Puerta)
                .map(elemento -> (Puerta) elemento)
                .collect(Collectors.toList());

        for (Puerta puerta : puertasHab1) {
            if (puerta.isAbierta()) {
                if (puerta.getLado1().equals(this.getPosicion())) {
                    System.out.println("Bicho " + this.modo.getClass().getSimpleName() + " ha entrado en la hab " + puerta.getLado2().getNum());
                    this.setPosicion(puerta.getLado2());
                } else {
                    System.out.println("Bicho " + this.modo.getClass().getSimpleName() + " ha entrado en la hab " + puerta.getLado1().getNum());
                    this.setPosicion(puerta.getLado1());
                }
                break;
            }
        }
    }

    // TODO

    public void atacarATodos() {
    }

    public List<Bicho> buscarBichos() {
        return null;
    }

    public Orientacion obtenerOrientacionAleatoria() {
        return null;
    }

}
