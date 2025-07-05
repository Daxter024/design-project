package com.example.laberinto.mapa.contenedores;

import com.example.laberinto.comandos.Entrar;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.formas.Cuadrado;
import com.example.laberinto.mapa.Contenedor;
import com.example.laberinto.mapa.ElementoMapa;
import com.example.laberinto.mapa.Puerta;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

@Data
public class Habitacion extends Contenedor {

    public Habitacion(int num) {
        this.num = num;
        this.forma = new Cuadrado();
        agregarComando(new Entrar(this));
    }


    @Override
    public void abrir(Ente alguien) {
        System.out.println("Una habitación no puede ser abierta");
    }

    @Override
    public void cerrar(Ente alguien) {
        System.out.println("No puedes cerrar una habitación.");
    }

    public void entrar(Ente alguien) {
        // todo: comprobar que la puerta está abierta y se puede entrar

        for (ElementoMapa elemento : hijos) {
            if (elemento instanceof Puerta) {
                if (((Puerta) elemento).isAbierta()) {
                    Habitacion habitacion1 = ((Puerta) elemento).getLado1();
                    Habitacion habitacion2 = ((Puerta) elemento).getLado2();

                    if (alguien.getPosicion().equals(habitacion1)) {
                        System.out.println(alguien.getClass().getSimpleName() + " está entrando en una habitación.");
                        alguien.setPosicion(habitacion2);
                        return;
                    } else if (alguien.getPosicion().equals(habitacion2)) {
                        System.out.println(alguien.getClass().getSimpleName() + " está entrando en una habitación.");
                        alguien.setPosicion(habitacion1);
                        return;
                    } else {
                        System.out.println("No puedes acceder a esta habitacion, estás muy lejos");

                    }
                } else {
                    System.out.println("La puerta no está abierta");
                }

            }
        }
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarHabitacion(this);
        // todo: aceptar a los hijos y forma
    }

    @Override
    public boolean esHabitacion() {
        return true;
    }
}
