package com.grupo5.SistemaTrueques.entities;

public class SuscripcionNormal {
    private Integer id;
    private String correo;

    public SuscripcionNormal(Integer id, String correo) {
        this.id = id;
        this.correo = correo;
    }

    public SuscripcionNormal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
