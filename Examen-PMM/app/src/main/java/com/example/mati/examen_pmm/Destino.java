package com.example.mati.examen_pmm;



public class Destino
{
    private String modelo;
    private String marca;
    private int imagen;
    private double precio;


    public Destino(String modelo, String marca, double precio, int imagen) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImagen(){
        return imagen;
    }
    public void setImagen(int imagen){
        this.imagen = imagen;
    }

}
