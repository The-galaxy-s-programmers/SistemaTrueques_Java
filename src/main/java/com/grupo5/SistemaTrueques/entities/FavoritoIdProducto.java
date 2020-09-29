package com.grupo5.SistemaTrueques.entities;

import java.util.Date;

public class FavoritoIdProducto {

    private Integer id_fav;
    private Integer id_usuarioF;
    private Integer id_producto;
    private Integer idP;
    private String nombre;
    private String descripcion;
    private String categoria;
    private Date fechaPublicacion;
    private String uso;
    private String imagen;
    private Integer valorReferencia;
    private String ubicacion;
    private Integer id_usuario;
    private String subcategoria;

    public FavoritoIdProducto(Integer id_fav, Integer id_usuarioF, Integer id_producto, Integer idP, String nombre, String descripcion, String categoria, Date fechaPublicacion, String uso, String imagen, Integer valorReferencia, String ubicacion, Integer id_usuario, String subcategoria) {
        this.id_fav = id_fav;
        this.id_usuarioF = id_usuarioF;
        this.id_producto = id_producto;
        this.idP = idP;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaPublicacion = fechaPublicacion;
        this.uso = uso;
        this.imagen = imagen;
        this.valorReferencia = valorReferencia;
        this.ubicacion = ubicacion;
        this.id_usuario = id_usuario;
        this.subcategoria = subcategoria;
    }

    public FavoritoIdProducto() {
    }

    public Integer getId_fav() {
        return id_fav;
    }

    public void setId_fav(Integer id_fav) {
        this.id_fav = id_fav;
    }

    public Integer getId_usuarioF() {
        return id_usuarioF;
    }

    public void setId_usuarioF(Integer id_usuarioF) {
        this.id_usuarioF = id_usuarioF;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(Integer valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
}