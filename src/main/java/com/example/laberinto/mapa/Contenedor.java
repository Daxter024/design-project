package com.example.laberinto.mapa;

import com.example.laberinto.comandos.Comando;
import com.example.laberinto.formas.Forma;
import com.example.laberinto.formas.orientaciones.Orientacion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public abstract class Contenedor extends ElementoMapa {

    protected Forma forma;
    protected List<ElementoMapa> hijos = new ArrayList<ElementoMapa>();
    protected int num;

    public void agregarHijo(ElementoMapa hijo) {
        hijo.setPadre(this);
        this.hijos.add(hijo);
    }

    public void agregarOrientacion(Orientacion orientacion) {
        if (this.forma != null) {
            // todo: comprobar dependiendo de la forma si se puede agregar la orientacion o no
            this.forma.agregarOrientacion(orientacion);
        }
    }

    public void calcularPoscion() {
        if (this.forma != null) {
            this.forma.calcularPosicion();
        }
    }

    public List<Comando> obtenerComandos() {
        List<Comando> lista = new ArrayList<>();
        for (ElementoMapa hijo : hijos) {
            lista.addAll(hijo.getComandos());
        }
        if (forma != null) {
            lista.addAll(forma.obtenerComandos());
        }
        return lista;
    }

    public ElementoMapa obtenerElemento(Orientacion or) {
        return forma != null ? forma.obtenerElemento(or) : null;
    }

    protected int obtenerNumeroAleatorio(int numMax) {
        Random rand = new Random();
        return 1 + rand.nextInt(numMax);
    }

    public Orientacion obtenerOrientacionAleatoria() {
        if (this.forma != null && !this.forma.getOrientaciones().isEmpty()) {
            int ind = obtenerNumeroAleatorio(this.forma.getOrientaciones().size());
            return this.forma.getOrientaciones().get(ind - 1); // Adjust for 0-based index
        }
        return null;
    }

    public void ponerEn(Orientacion or, ElementoMapa em) {
        if (this.forma != null) {
            this.forma.ponerEn(or, em);
        }
    }

}
