package org.example;

import org.example.common.CategoriaException;
import org.example.common.Comprobacion;
import org.example.common.Categoria;
import org.example.domain.Juego;
import org.example.ui.GestionDiccionario;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CategoriaException, IOException {
        //En el main sólo hay que llamar a los métodos de la UI que darán paso al luego o administrar diccionario.
        //Pero este código es para que veáis cómo funciona ciertos aspectos de la aplicación a tener en cuenta

        Scanner sc = new Scanner(System.in);

        int o = sc.nextInt();
        if (o == 1){
            Juego.intro();
            Juego.setResultado();
            System.out.println(Juego.getResultado());
            while(!Juego.getFinPartida())Juego.mainBucle();
            if (Juego.getResultado().equals(Juego.getRespuesta())) System.out.println("Enhorabuena, has ganado");
            else System.out.println("Has perdido, la palabra era "+Juego.getResultado());
        }
        else if(o==2){
            System.out.println("Pulsa 1 para añadir resultados");
            int i;
            i=sc.nextInt();
            if (i==1)GestionDiccionario.anadirResultados(); // añadirResultados debería ser un método de GestionDiccionario
            GestionDiccionario.mostrarMenu();
            try {
                Comprobacion.categoriaOk(Categoria.comedia.name());
                Comprobacion.categoriaOk("hola");
            } catch (CategoriaException e) {
                System.out.println(e.getMessage());
            }
        }
        else{ //REVISAR ESTO PORQUE ES UN JALEO
            String o2= o+"";
            try{
                Comprobacion.categoriaOk(o2+"");
            }
            catch(CategoriaException e) {
                System.out.println(e.getMessage());
            }
        }

        /*Faker faker = new Faker();
        String nombre = faker.gameOfThrones().character();
        System.out.println(nombre);
        String animal = faker.animal().name();
        System.out.println(animal);
        String fecha = faker.date().birthday(10,15).toString();
        System.out.println(fecha);*/


        //El siguiente código no va aquí pero es para que sepáis cómo funciona el id autonumérico
        /*Elementos asdf = new Elementos();
        System.out.println(Elementos.getAutonumerico());
        Elemento asd = new Elemento(2,"324",Categoria.accion.name());
        System.out.println(Elementos.getAutonumerico());
        Elemento asd2 = new Elemento(2,"324",Categoria.miedo.name());
        System.out.println(Elementos.getAutonumerico());*/

    }
}