package com.example.mati.pruebasbdsqllite;

/**
 * Created by mati on 11/01/17.
 */
public class Cliente {
    String nombre, telefono;
    int codigo;
    public Cliente(String nombre, String telefono, int codigo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.codigo = codigo;
    }

    public String getNombre() { return nombre;  }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTelefono() { return telefono;}

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCodigo() {return codigo; }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


}
