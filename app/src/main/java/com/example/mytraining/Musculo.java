package com.example.mytraining;

public class Musculo {
    private int idMusculo;
    private String nombreMusculo;
    private byte[] imagenMusculo;
    private String nombreAltMusculo;

    public Musculo(int idMusculo, String nombreMusculo, byte[] imagenMusculo, String nombreAltMusculo) {
        this.idMusculo = idMusculo;
        this.nombreMusculo = nombreMusculo;
        this.imagenMusculo = imagenMusculo;
        this.nombreAltMusculo = nombreAltMusculo;
    }

    public int getIdMusculo() {
        return idMusculo;
    }

    public void setIdMusculo(int idMusculo) {
        this.idMusculo = idMusculo;
    }

    public String getNombreMusculo() {
        return nombreMusculo;
    }

    public void setNombreMusculo(String nombreMusculo) {
        this.nombreMusculo = nombreMusculo;
    }

    public byte[] getImagenMusculo() {
        return imagenMusculo;
    }

    public void setImagenMusculo(byte[] imagenMusculo) {
        this.imagenMusculo = imagenMusculo;
    }

    public String getNombreAltMusculo() {
        return nombreAltMusculo;
    }

    public void setNombreAltMusculo(String nombreAltMusculo) {
        this.nombreAltMusculo = nombreAltMusculo;
    }
}