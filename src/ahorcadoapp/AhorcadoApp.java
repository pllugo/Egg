/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadoapp;

import ahorcadoapp.Identidades.Ahorcado;
import ahorcadoapp.Servicios.ServicioAhorcado;

/**
 *
 * @author Usuario
 */
public class AhorcadoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServicioAhorcado game = new ServicioAhorcado();
        Ahorcado juego = game.crearJuego();
        game.juegoAhorcado(juego);
        
    }
    
}
