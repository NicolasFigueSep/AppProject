package com.example.mytraining;

public class Ejercicio {
    private int idEjercicio;
    private String nombreEjercicio;
    private String descripcionEjercicio;
    private String urlVideoDemostracion;
    private Double caloriasEjercicio;
    public Ejercicio(int idEjercicio, String nombreEjercicio, String descripcionEjercicio, String urlVideoDemostracion,
                     Double caloriasEjercicio) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.descripcionEjercicio = descripcionEjercicio;
        this.urlVideoDemostracion = urlVideoDemostracion;
        this.caloriasEjercicio = caloriasEjercicio;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getDescripcionEjercicio() {
        return descripcionEjercicio;
    }

    public void setDescripcionEjercicio(String descripcionEjercicio) {
        this.descripcionEjercicio = descripcionEjercicio;
    }

    public String getUrlVideoDemostracion() {
        return urlVideoDemostracion;
    }

    public void setUrlVideoDemostracion(String urlVideoDemostracion) {
        this.urlVideoDemostracion = urlVideoDemostracion;
    }
}