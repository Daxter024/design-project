package com.example.laberinto.modos;

import com.example.laberinto.entes.Bicho;
import lombok.Data;

@Data
public class Agresivo extends Modo {

    public Agresivo() {
        this.color = "rojo";
    }

    @Override
    void atacar(Bicho bicho) {
        bicho.atacar();
    }

    @Override
    void caminar(Bicho bicho) {
        // todo
    }

    @Override
    void dormir() {
        System.out.println("Bicho agresivo no duerme");
    }

    public boolean esAgresivo() {
        return true;
    }
}
