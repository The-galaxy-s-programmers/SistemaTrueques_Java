package com.grupo5.SistemaTrueques.entities;

public class ChatPrivToken {
    private Integer token;
    private String nomProducto;

    public ChatPrivToken(Integer token, String nomProducto) {
        this.token = token;
        this.nomProducto = nomProducto;
    }

    public ChatPrivToken() {
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }
}

