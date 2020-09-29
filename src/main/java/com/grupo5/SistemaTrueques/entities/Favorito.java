package com.grupo5.SistemaTrueques.entities;

public class Favorito {
  private Integer id_fav;
  private Integer id_usuarioF;
  private Integer id_producto;


    public Favorito(Integer id_fav, Integer id_usuarioF, Integer id_producto) {
        this.id_fav = id_fav;
        this.id_usuarioF = id_usuarioF;
        this.id_producto = id_producto;
    }

    public Favorito() {
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
}
