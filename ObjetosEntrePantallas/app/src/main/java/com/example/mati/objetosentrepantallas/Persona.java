package com.example.mati.objetosentrepantallas;
import java.io.Serializable;


public class Persona implements Serializable {
    private String nombre,apellido;
    private int edad;
    private int foto;


    public Persona (String nombre, String apellido, int edad, int foto ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.foto = foto;

    }
    public Persona (String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }





    public String toString(){
        return "Nombre :" + this.nombre+"" +
                "\nApellido :"+ this.apellido+""+
                "\nEdad :"+ this.edad+""+
                "\nFoto :" + this.foto;

    }
}
