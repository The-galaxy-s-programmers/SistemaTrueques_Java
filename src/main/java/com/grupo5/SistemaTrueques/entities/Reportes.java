package com.grupo5.SistemaTrueques.entities;

import java.util.Date;

public class Reportes {
    private Integer id;
    private Integer id_usuario;
    private Date fecha;
    private String comentario;
    private String correo;
    private String nombre;
    private String tipo;

    public Reportes(Integer id, Integer id_usuario, Date fecha, String comentario, String correo, String nombre, String tipo) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.comentario = comentario;
        this.correo = correo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Reportes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
}
