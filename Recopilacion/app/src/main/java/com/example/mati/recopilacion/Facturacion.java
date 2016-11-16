package com.example.mati.recopilacion;

import java.io.Serializable;

/**
 * Created by mati on 14/11/16.
 */
public class Facturacion implements Serializable{
    private double PrecioZona;
    private double PesoPaquete;
    private double PrecioPaquete;//peso
    private double Incremento = 0.3;
    private  boolean Urgente;

    public double getPrecioPaquete() {
        return PrecioPaquete;
    }

    public void setPrecioPaquete(double precioPaquete) {
        PrecioPaquete = precioPaquete;
    }



    public boolean isUrgente() {
        return Urgente;
    }
    public void setUrgente(boolean urgente) {
        Urgente = urgente;
    }

    public Facturacion(double precioZona, double precioPaquete, double incremento, double precioFinal, boolean urgente) {
        PrecioZona = precioZona;
        PesoPaquete = precioPaquete;
        Incremento = incremento;
        PrecioFinal = precioFinal;
        Urgente = urgente;
        gestionarPeso();
    }
    public Facturacion(){

    }

    private void gestionarPeso() {
        if(PesoPaquete<=5){

            PrecioPaquete = 1;
            PrecioPaquete = PrecioPaquete*PesoPaquete;

        }if(PesoPaquete>5 && PesoPaquete<=10){

            PrecioPaquete = 1.5;
            PrecioPaquete = PrecioPaquete*PesoPaquete;


        }if (PesoPaquete > 10 ){

            PrecioPaquete = 2;
            PrecioPaquete = PrecioPaquete*PesoPaquete;
        }

    }

    private double PrecioFinal;



    public double getPrecioZona() {
        return PrecioZona;
    }

    public void setPrecioZona(double precioZona) {
        PrecioZona = precioZona;
    }

    public double getPesoPaquete() {
        return PesoPaquete;
    }

    public void setPesoPaquete(double pesoPaquete) {
        PesoPaquete = pesoPaquete;
    }

    public double getIncremento() {
        return Incremento;
    }

    public double getPrecioFinal() {

        if (this.Urgente == true){
            PrecioFinal = (getPrecioZona()+ getPrecioPaquete()*getIncremento());
            //PrecioFinal = PrecioFinal*Incremento;
        }else{
            PrecioFinal= getPrecioZona()+getPrecioPaquete();
        }


        return PrecioFinal;
    }



}
