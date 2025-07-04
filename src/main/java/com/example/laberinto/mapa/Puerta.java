package com.example.laberinto.mapa;

import com.example.laberinto.comandos.Abrir;
import com.example.laberinto.comandos.Cerrar;
import com.example.laberinto.comandos.Comando;
import com.example.laberinto.comandos.Entrar;
import com.example.laberinto.entes.Ente;
import com.example.laberinto.mapa.contenedores.Habitacion;
import com.example.laberinto.visitor.Visitor;
import lombok.Data;

@Data
public class Puerta extends ElementoMapa {

    private boolean abierta;
    private boolean visitada;
    private Habitacion lado1;
    private Habitacion lado2;

    public Puerta() {
        this.abierta = false;
        this.visitada = false;
        this.agregarComando(new Abrir(this));
        this.agregarComando(new Cerrar(this));
        this.agregarComando(new Entrar(this));
    }


    @Override
    public void abrir(Ente alguien) {
        
        if (this.abierta) {
            System.out.println("La puerta está ya abierta");
            return;
        }

        if (alguien.getPosicion() != this.lado1 || alguien.getPosicion() != this.lado2) {
            System.out.println("No puede abrir la puerta pq el ente se encuentra en la posicion " + alguien.getPosicion() +
                    " y la puerta solo puede ser abierta desde " + this.lado1 + " & " + this.lado2);
            return;
        }
        // tieneComando puede sobrar si el valor de abierta está bien asignado
        // tieneComando podría ser funcional si hubiese que encontrar algún tipo de llave y entonces se le da el comando de abrir
        // !this.abierta puede sobrar
        if (!this.abierta && tieneComandodeTipo(Abrir.class)) {
            this.abierta = true;
            this.visitada = true;
            System.out.println("La puerta ha sido abierta por " + alguien.getClass().getSimpleName() + ".");

            // Métodos para borrar el comando
            // 1.
            comandos.removeIf(comando -> comando.esAbrir());
            // 2.
            // comandos.remove(new Abrir(this)); // Esto requiere equals/hashCode para funcionar

            // Debería tenerlo al principio de la clase, pero no tenerlo si se ejecuta primero el cerrar
            if (!tieneComandodeTipo(Cerrar.class)) {
                agregarComando(new Cerrar(this));
            }
        } else {
            System.out.println("La puerta está ya abierta");
        }
    }


    public void cerrar() {
//        this.cerrar();
//        System.out.println("La puerta ha sido cerrada por " + alguien.getClass().getSimpleName() + ".");
    }

    @Override
    public void cerrar(Ente alguien) {

        if (!this.abierta) {
            System.out.println("La puerta está ya cerrada");
            return;
        }

        if (this.abierta && tieneComandodeTipo(Cerrar.class)) {
            this.abierta = !this.abierta;
            System.out.println("La puerta ha sido cerrada por " + alguien.getClass().getSimpleName() + ".");
            comandos.removeIf(comando -> comando.esCerrar());
            if (!tieneComandodeTipo(Abrir.class)) {
                agregarComando(new Abrir(this));
            }
        }
    }

    // En vd es inútil pq ya lo haría sin necesidad de declararlo aquí
    @Override
    public void entrar(Ente alguien) {
        super.entrar(alguien);
    }

    /**
     * Testing
     **/
    @Override
    public boolean esPuerta() {
        return true;
    }

    /**
     * Visitor
     **/

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitarPuerta(this);
    }

    private boolean tieneComandodeTipo(Class<? extends Comando> tipoComando) {
        for (Comando comando : comandos) {
            if (tipoComando.isInstance(comando)) {
                return true;
            }
        }
        return false;
    }

}
