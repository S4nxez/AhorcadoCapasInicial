package org.example.domain;


import org.example.common.Categoria;
import org.example.common.CategoriaException;
import org.example.common.Comprobacion;
import org.example.common.RespuestaException;

import java.io.*;
import java.util.Scanner;

public class Juego {
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    private Elemento aAdivinar; //o el String directamente
    private Jugador jugador;
    private int intentos;
    private int dificultad; //opcional, aquí o por elemento.

    static  private File diccionario = new File("C:\\Users\\cobra\\Desktop\\FP\\Programación\\3er Trimestre\\Diccionario.txt");
    static Scanner sc=new Scanner(System.in);

    private static boolean finPartida= false;
    private static String respuesta="____";
    private static String resultado;
    private static int aciertos, vidas=5;

    public static void setResultado() throws IOException {
        FileInputStream flujoEntrada = new FileInputStream(diccionario);

        int tamanyoFichero = (int) diccionario.length();
        String [] resultados = new String[tamanyoFichero]; //esto crea un array mas grande del necesario no se como hacer para ajustarlo porque al dividir entre 4 tampoco da
        int i=0;
        try {
            Scanner scanner = new Scanner(diccionario);
            while (scanner.hasNextLine()) {
                resultados[i] = scanner.nextLine();
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int o = i;
        i=0;
        while (i==0)i=(int)(Math.random()*o);
        resultado = resultados[i];
        resultado = resultado.toLowerCase();
    }

    public static void mainBucle(){
        vidas--;//empiezan en 4 siempre
        aciertos = 0;
        respuesta = sc.nextLine();
//        respuesta = filtrarRespuestas();// no se si es mejor usar esto o hacer un try catch y lo de si es mejor en el main o en la clase que sea el try catch tampoco lo entiendo
        respuesta = respuesta.toLowerCase();

        try {
            for(int i=0;i!=4;i++){
                char resulTemp = resultado.charAt(i);
                char respTemp = respuesta.charAt(i);
                if(respTemp==resulTemp) {
                    System.out.print(resultado.charAt(i));
                    aciertos++;
                }
                else System.out.print("_ ");
            }
        }catch (Exception e){
            System.out.println("ERROR: La respuesta debe tener una longitud de 4 carácteres.");
            // si leo aqui la respuesta otra vez no sirve de nada de la otra forma funciona mejor además que con esto no nota si meto una larga
        }

        if (aciertos==4||vidas==0)finPartida=true;
        System.out.println();

    }
    public String filtrarRespuestas(){
        while(respuesta.length()!=4){
            System.out.println("ERROR: La respuesta debe tener una longitud de 4 carácteres.");
            respuesta= sc.nextLine();
        }
        respuesta = respuesta.toLowerCase();
        return respuesta;
    }

    public static String getResultado() {
        return resultado;
    }

    public static int getAciertos() {
        return aciertos;
    }

    public static File getDiccionario() {
        return diccionario;
    }

    public static void intro(){
        System.out.println("***-----------------------***");
        System.out.println(" * 1·Jugar                 * ");
        System.out.println(" * 2·Gestionar diccionario * ");
        System.out.println("***-----------------------***");
        int o = sc.nextInt();
        switch (o){
            case 1:
                System.out.println("1·Recuperar la última partida");
                System.out.println("2·Partida nueva");
                o=sc.nextInt();
                sc.nextLine();
                break;

            case 2:
                System.out.println("1·Listar diccionario ordenado");
                System.out.println("2·Insertar un elemento diccionario");
                System.out.println("3·Modificar algún campo de un elemento del diccionario");
                System.out.println("4·Eliminar un elemento del diccionario");
                o=sc.nextInt();
                sc.nextLine();
                break;
        }
        System.out.println("\nTienes 5 vidas para adivinar la palabra");
        System.out.println("_ _ _ _ ");

    }

    public static boolean getFinPartida(){
        return finPartida;
    }
}
