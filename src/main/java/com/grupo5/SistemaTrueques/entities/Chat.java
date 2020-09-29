package com.grupo5.SistemaTrueques.entities;

import java.util.Date;

public class Chat {

    private Integer id;
    private Integer id_producto;
    private Integer id_user;
    private String mensaje;
    private Integer id_duenio;
    private String respuesta;
    private Date fecha;
    private String nomUser;
    private String nomDuenio;
    private String nomProducto;

    public Chat(Integer id, Integer id_producto, Integer id_user, String mensaje, Integer id_duenio, String respuesta, Date fecha, String nomUser, String nomDuenio, String nomProducto) {
        this.id = id;
        this.id_producto = id_producto;
        this.id_user = id_user;
        this.mensaje = mensaje;
        this.id_duenio = id_duenio;
        this.respuesta = respuesta;
        this.fecha = fecha;
        this.nomUser = nomUser;
        this.nomDuenio = nomDuenio;
        this.nomProducto = nomProducto;
    }

    public Chat() {
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
}
