package com.example.laberinto.formas;

import com.example.laberinto.comandos.Comando;
import com.example.laberinto.formas.orientaciones.Orientacion;
import com.example.laberinto.mapa.ElementoMapa;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Forma {

    protected Point extent;
    protected Point punto;
    protected int num;
    protected List<Orientacion> orientaciones = new ArrayList<>();

    public abstract ElementoMapa obtenerElemento(Orientacion orientacion);

    /**
     * Poner un ElementoMapa en una orientacion del contenedor
     **/
    public abstract void ponerEn(Orientacion orientacion, ElementoMapa elementoMapa);

    public void aceptar(Visitor visitor) {
        for (Orientacion orientacion : orientaciones) {
            orientacion.aceptar(visitor, this);
        }
    }

    public void agregarOrientacion(Orientacion orientacion) {
        orientaciones.add(orientacion);
    }

    public void eliminarOrientacion(Orientacion orientacion) {
        orientaciones.remove(orientacion);
    }

    public void calcularPosicion() {
        for (Orientacion orientacion : orientaciones) {
            orientacion.calcularPosicionDesde(this);
        }
    }

    public List<Comando> obtenerComandos() {
        List<Comando> comandos = new ArrayList<>();
        for (Orientacion orientacion : orientaciones) {
            comandos.addAll(orientacion.obtenerComandos(this));
        }
        return comandos;
    }

}
