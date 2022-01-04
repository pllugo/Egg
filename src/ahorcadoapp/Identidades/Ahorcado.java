/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadoapp.Identidades;

/**
 *
 * @author Usuario
 */
public class Ahorcado {
    private String[] vector;
    private int cantidadLetras;
    private int cantidadJugadas;

    public Ahorcado() {
    }

    public Ahorcado(String[] vector, int cantidadLetras, int cantidadJugadas) {
        this.vector = vector;
        this.cantidadLetras = cantidadLetras;
        this.cantidadJugadas = cantidadJugadas;
    }

    public String[] getVector() {
        return vector;
    }

    public int getCantidadLetras() {
        return cantidadLetras;
    }

    public int getCantidadJugadas() {
        return cantidadJugadas;
    }

    public void setVector(String[] vector) {
        this.vector = vector;
    }

    public void setCantidadLetras(int cantidadLetras) {
        this.cantidadLetras = cantidadLetras;
    }

    public void setCantidadJugadas(int cantidadJugadas) {
        this.cantidadJugadas = cantidadJugadas;
    }

    @Override
    public String toString() {
        return "Ahorcado{" + "vector=" + vector + ", cantidadLetras=" + cantidadLetras + ", cantidadJugadas=" + cantidadJugadas + '}';
    }
    
    
    
}
