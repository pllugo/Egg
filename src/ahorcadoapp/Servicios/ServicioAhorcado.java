/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadoapp.Servicios;

import ahorcadoapp.Identidades.Ahorcado;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ServicioAhorcado {
    private Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public Ahorcado crearJuego(){
        System.out.println("Ingrese la palabra");
        String palabra = read.next();
        String[] vector = new String[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            vector[i] = palabra.substring(i, i+1);
        }
        System.out.println("Ingrese la cantidad de jugadas máxima");
        int cantidadJugadas = read.nextInt();
        Ahorcado juego = new Ahorcado(vector, 0, cantidadJugadas);
        return juego;
    }
    
    public static void PrintVector(String[] vec) {
        for (int k = 0; k < vec.length; k++) {
            if (k == 0) {
                System.out.print("[" + vec[k] + ",");
            } else if (k < vec.length - 1) {
                System.out.print(vec[k] + ",");
            } else {
                System.out.print(vec[k] + "]");
            }
        }
        System.out.println("");
    }
    
    public void mostrarLongitud(Ahorcado juego){
        System.out.println("Longitud de la palabra " + juego.getVector().length);
    }
    
    public String buscarLetra(Ahorcado juego) {
        boolean flag = false;
        int i = 0;
        System.out.println("Ingrese la letra a buscar");
        String letra = read.next();
        do {
            if (juego.getVector()[i].equalsIgnoreCase(letra)) {
                flag = true;
            }
            i = i + 1;
        } while (i < juego.getVector().length);
        if (flag == true) {
            System.out.println("La letra se encuentra");
        } else {
            System.out.println("La letra ingresada no se encontro");
        }
        return letra;
    }
    
    public boolean encontrarLetras(Ahorcado juego, String letra){
        boolean resultado;
        int cont = 0;
        for (int i = 0; i < juego.getVector().length; i++) {
            if (juego.getVector()[i].equalsIgnoreCase(letra)) {
                cont = cont + 1;
            }
        }
        if (cont == 0) {
            resultado = false;
        } else {
            resultado = true;
            if (juego.getCantidadLetras() == 0) {
                juego.setCantidadLetras(cont);
                System.out.println("La cantidad de letras encontradas/faltantes es " + juego.getCantidadLetras() + " , " + (juego.getVector().length - cont));
            } else {
                juego.setCantidadLetras(juego.getCantidadLetras() + cont);
                System.out.println("La cantidad de letras encontradas/faltantes es " + juego.getCantidadLetras() + " , " + (juego.getVector().length - juego.getCantidadLetras()));
            }
        }
        return resultado;
    }
    
    public void intentosJuego(Ahorcado juego){
        System.out.println("Número de oportunidades restantes " + juego.getCantidadJugadas());
    }
    
    public void juegoAhorcado(Ahorcado juego){
        String letra;
        boolean resultado;
        do {
            mostrarLongitud(juego);
            letra = buscarLetra(juego);
            resultado = encontrarLetras(juego, letra);
            if (resultado == false) {
                juego.setCantidadJugadas(juego.getCantidadJugadas() - 1);
                System.out.println("La cantidad de letras encontradas/faltantes es " + juego.getCantidadLetras() + " , " + (juego.getVector().length - juego.getCantidadLetras()));
                intentosJuego(juego);
            } else {
                intentosJuego(juego);
            }
        } while ((juego.getCantidadJugadas() > 0) && (juego.getCantidadLetras() < juego.getVector().length));
        if (juego.getCantidadJugadas() == 0) {
            System.out.println("Lo senntimos no hay mas oportunidades");
        } else {
            System.out.println("Felicitaciones ha completado la palabra");
            PrintVector(juego.getVector());
        }
    }
}
