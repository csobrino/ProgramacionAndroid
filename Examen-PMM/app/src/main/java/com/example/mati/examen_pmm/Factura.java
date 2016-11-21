package com.example.mati.examen_pmm;

import java.io.Serializable;

public class Factura implements Serializable
{
    private String modelo;
    private String marca;
    private String tipoSeguro = "Normal";
    private String tipoExtras= "";

    private double precioModelo;
    private double pesoPaquete;
    private double precioPaquete;
    private double precioFinal;
    private boolean esUrgente = false;

    public Factura(){}


    public double getPrecioModelo() {
        return precioModelo;
    }

    public void setPrecioModelo(double precioModelo) {
        this.precioModelo = precioModelo;
    }

    public double getPesoPaquete() {
        return pesoPaquete;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoExtras() {
        return tipoExtras;
    }

    public void setTipoExtras(String tipoExtras) {
        this.tipoExtras = tipoExtras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public boolean getUrgente(){
        return esUrgente;
    }


    private double precioPorKilos(double pesoPaquete)
    {

        precioPaquete = pesoPaquete * precioModelo;
        return precioPaquete;
    }
    public double getPrecioFinal() {
        if (precioModelo!=0)
        {
            if (esUrgente == Boolean.TRUE){
                precioFinal = (precioPaquete + (precioPorKilos(this.pesoPaquete)) + (precioPaquete * 0.2));


            }
            else {
                precioFinal = this.precioModelo + precioPorKilos(this.pesoPaquete);
            }
            return precioFinal;
        }else {
            return 0;
        }
    }

    public void setPesoPaquete(double pesoPaquete) {
        this.pesoPaquete = pesoPaquete;
    }
    public void setUrgente(boolean esUrgente){
        this.esUrgente = esUrgente;
    }

}
