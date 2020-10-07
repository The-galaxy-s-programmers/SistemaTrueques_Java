package com.grupo5.SistemaTrueques.entities;

import java.util.Date;

public class ProductoTrocado {

    private Integer id;
    private Integer aceptaUser;
    private Integer aceptaDuenio;
    private Date fecha;
    private Integer id_user;
    private Integer id_duenio;
    private Integer id_producto;
    private Integer token;

    public ProductoTrocado(Integer id, Integer aceptaUser, Integer aceptaDuenio, Date fecha, Integer id_user, Integer id_duenio, Integer id_producto, Integer token) {
        this.id = id;
        this.aceptaUser = aceptaUser;
        this.aceptaDuenio = aceptaDuenio;
        this.fecha = fecha;
        this.id_user = id_user;
        this.id_duenio = id_duenio;
        this.id_producto = id_producto;
        this.token = token;
    }

    public ProductoTrocado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAceptaUser() {
        return aceptaUser;
    }

    public void setAceptaUser(Integer aceptaUser) {
        this.aceptaUser = aceptaUser;
    }

    public Integer getAceptaDuenio() {
        return aceptaDuenio;
    }

    public void setAceptaDuenio(Integer aceptaDuenio) {
        this.aceptaDuenio = aceptaDuenio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(Integer id_duenio) {
        this.id_duenio = id_duenio;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }
}

