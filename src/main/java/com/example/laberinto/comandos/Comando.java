package com.example.laberinto.comandos;

import com.example.laberinto.entes.Ente;
import com.example.laberinto.mapa.ElementoMapa;
import lombok.Data;

@Data
public abstract class Comando {

    protected ElementoMapa receptor;

    public Comando(ElementoMapa receptor) {
        this.receptor = receptor;
    }

    // TODO: podría ser necesario otro metodo ejecutar sin un ente

    public abstract void ejecutar(Ente alguien);

    public boolean esAbrir() {
        return false;
    }

    public boolean esCerrar() {
        return false;
    }

    public boolean esEntrar() {
        return false;
    }
}
