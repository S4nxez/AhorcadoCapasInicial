package org.example.ui;

import org.example.common.Constantes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase con métodos de administración para consola
 */

import org.example.domain.Juego; // he hecho esto para poder importar el diccionario en la línea 29

public class GestionDiccionario {
    private static final String pass = "2223";

    public static int mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.MENU+"\n"+Constantes.OPCION1+"\n"+Constantes.OPCION2+"\n"+Constantes.OPCION3+"\n"+Constantes.OPCION4);
        int num = sc.nextInt(); //tratar la excepción para evitar que se pare el programa si no introduce un número
        return num;
    }
    public static void anadirResultados() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("A continuación escriba la respuesta que quiere añadir al diccionario: ");

        FileOutputStream flujoSalida = new FileOutputStream(Juego.getDiccionario());//linea 29

        String datos1;
        datos1= sc.nextLine().toLowerCase();

        flujoSalida.write(datos1.getBytes());
        System.out.println("\n"+datos1+" añadido al diccionario.");
        flujoSalida.close();
    }

}
