package com.example.interfazgoogle.Model;

import android.widget.ImageView;

public class Drive {
    private String nombre="";
    private String tipo="";
    private String fecha="";
    private int usuario,archivoImage;

    public Drive(String nombre, String tipo, String fecha, int archivoImage, int usuario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.archivoImage = archivoImage;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getArchivoImage() {
        return archivoImage;
    }

    public void setArchivoImage(int archivoImage) {
        this.archivoImage = archivoImage;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
