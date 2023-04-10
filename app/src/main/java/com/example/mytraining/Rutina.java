package com.example.mytraining;

public class Rutina {
    private int idRutina;
    private String nombreRutina;
    private int duracionRutina;
    private String fechaCreacion;
    private String descripcionRutina;

    public Rutina(int idRutina, String nombreRutina, int duracionRutina, String fechaCreacion, String descripcionRutina) {
        this.idRutina = idRutina;
        this.nombreRutina = nombreRutina;
        this.duracionRutina = duracionRutina;
        this.fechaCreacion = fechaCreacion;
        this.descripcionRutina = descripcionRutina;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public String getNombreRutina() {
        return nombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    public int getDuracionRutina() {
        return duracionRutina;
    }

    public void setDuracionRutina(int duracionRutina) {
        this.duracionRutina = duracionRutina;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcionRutina() {
        return descripcionRutina;
    }

    public void setDescripcionRutina(String descripcionRutina) {
        this.descripcionRutina = descripcionRutina;
    }
}