package com.example.laberinto.mapa.hojas;

import com.example.laberinto.mapa.ElementoMapa;
import com.example.laberinto.mapa.Hoja;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

@Data
public abstract class Decorator extends Hoja {

    protected ElementoMapa componente;

    public void decorar(ElementoMapa componente) {
        this.componente = componente;
    }

    public void aceptar(Visitor visitor) {
        if (componente != null) {
            componente.aceptar(visitor);
        }
    }

    public void entrar() {
        if (componente != null) {
            componente.entrar();
        }
    }
}
