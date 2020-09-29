package com.grupo5.SistemaTrueques.entities;

public class Suscripcion {
    private String correo;

    public Suscripcion( String correo) {

        this.correo = correo;
    }

    public Suscripcion() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
