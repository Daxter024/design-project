package com.example.laberinto.tipos;

import com.example.laberinto.entes.Ente;
import lombok.Data;

@Data
public abstract class Tipo {

    /**
     * Strategy
     **/

    public abstract void accionar(Ente alguien);

    public boolean esCurativa() {
        return false;
    }

    public boolean esVenenosa() {
        return false;
    }
}
