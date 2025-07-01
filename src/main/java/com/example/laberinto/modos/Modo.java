package com.example.laberinto.modos;

import com.example.laberinto.entes.Bicho;
import lombok.Data;

/** Template Method **/

@Data
public abstract class Modo {

    protected String color;

    // algoritmo para cada bicho
    public void actua(Bicho bicho) {
        dormir();
        caminar(bicho);
        atacar(bicho);
    }

    abstract void atacar(Bicho bicho);

    abstract void caminar(Bicho bicho);

    abstract void dormir();

    public boolean esAgresivo(){
        return false;
    }

    public boolean esPerezoso(){
        return false;
    }
}
