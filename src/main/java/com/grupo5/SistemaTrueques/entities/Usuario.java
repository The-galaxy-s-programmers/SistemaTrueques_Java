package com.grupo5.SistemaTrueques.entities;

import java.awt.*;
import java.util.Date;

public class Usuario {
    private Integer idU;
    private String nomusuario;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String correo;
    private String region;
    private String comuna;
    private String genero;
    private String foto;
    private String password;
    private String direccion;
    private Integer fono;

    public Usuario(){
    }

    public Usuario(Integer idU, String nomusuario, String nombre, String apellido, Date fechaNacimiento, String correo, String region, String comuna, String genero, String foto, String password, String direccion, Integer fono) {
        this.idU = idU;
        this.nomusuario = nomusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.region = region;
        this.comuna = comuna;
        this.genero = genero;
        this.foto = foto;
        this.password = password;
        this.direccion = direccion;
        this.fono = fono;
    }

    public Integer getIdU() {
        return idU;
    }

    public void setIdU(Integer idU) {
        this.idU = idU;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getFono() {
        return fono;
    }

    public void setFono(Integer fono) {
        this.fono = fono;
    }
}
