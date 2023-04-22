package org.example.common;


public class RespuestaException extends Exception{
    public RespuestaException(){
        super("La respuesta debe tener 4 caracteres");
    }
}
