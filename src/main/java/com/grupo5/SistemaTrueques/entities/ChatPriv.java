package com.grupo5.SistemaTrueques.entities;

import java.util.Date;

public class ChatPriv {

    private Integer id;
    private Integer id_producto;
    private Integer id_user;
    private String mensaje;
    private Integer id_duenio;
    private Date fecha;
    private String nomUser;
    private String nomDuenio;
    private String nomProducto;
    private Integer token;
    private Integer mensajePor;

    public ChatPriv(Integer id, Integer id_producto, Integer id_user, String mensaje, Integer id_duenio, Date fecha, String nomUser, String nomDuenio, String nomProducto, Integer token, Integer mensajePor) {
        this.id = id;
        this.id_producto = id_producto;
        this.id_user = id_user;
        this.mensaje = mensaje;
        this.id_duenio = id_duenio;
        this.fecha = fecha;
        this.nomUser = nomUser;
        this.nomDuenio = nomDuenio;
        this.nomProducto = nomProducto;
        this.token = token;
        this.mensajePor = mensajePor;
    }

    public ChatPriv() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(Integer id_duenio) {
        this.id_duenio = id_duenio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getNomDuenio() {
        return nomDuenio;
    }

    public void setNomDuenio(String nomDuenio) {
        this.nomDuenio = nomDuenio;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public Integer getMensajePor() {
        return mensajePor;
    }

    public void setMensajePor(Integer mensajePor) {
        this.mensajePor = mensajePor;
    }
}
