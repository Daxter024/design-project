package com.example.laberinto.modos;

import com.example.laberinto.entes.Bicho;

public class Perezoso extends Modo {

    public Perezoso() {
        this.color = "verde";
    }

    @Override
    void atacar(Bicho bicho) {
        // bicho perezoso no ataca
        System.out.println("Bicho perezoso no ataca");
    }

    @Override
    void caminar(Bicho bicho) {
        // todo
    }

    @Override
    void dormir() {
        try{
            Thread.sleep(1000);
            System.out.println("Bicho perezoso está durmiendo");
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("El sueño del bicho fue interrumpido.");
        }
    }

    @Override
    public boolean esPerezoso() {
        return true;
    }
}
