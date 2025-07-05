package com.example.laberinto.modos;

import com.example.laberinto.entes.Bicho;
import lombok.Data;

@Data
public class Canibal extends Modo {

    public Canibal() {
        this.color = "negro";
    }

    @Override
    void atacar(Bicho bicho) {
        bicho.atacar();
    }

    @Override
    void caminar(Bicho bicho) {

    }

    @Override
    void dormir() {

    }
}
