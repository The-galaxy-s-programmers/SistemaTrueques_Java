package com.grupo5.SistemaTrueques.dao;

import com.grupo5.SistemaTrueques.entities.Favorito;
import com.grupo5.SistemaTrueques.entities.ProductoTrocado;
import com.grupo5.SistemaTrueques.entities.Suscripcion;
import com.grupo5.SistemaTrueques.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Transactional
public class ProductoTrocadoDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ProductoTrocado Producto (int token) {
        String query = "SELECT * FROM ProductoTrocado where token=?";
        return (ProductoTrocado) jdbcTemplate.queryForObject(query, new Object[]{token},new BeanPropertyRowMapper(ProductoTrocado.class));
    }

    public int aceptaUsuario (ProductoTrocado newPT, int token){
        String sqlUpdate = "UPDATE ProductoTrocado set aceptaUser=? , fecha=GETDATE() WHERE token = ? ";
        int resultado = jdbcTemplate.update(sqlUpdate,newPT.getAceptaUser(),token);
        return resultado;
    }
    public int aceptaDuenio (ProductoTrocado newPT, int token){
        String sqlUpdate = "UPDATE ProductoTrocado set aceptaDuenio=? , fecha=GETDATE() WHERE token=?";
        int resultado = jdbcTemplate.update(sqlUpdate,newPT.getAceptaDuenio(),token);
        return resultado;
    }

    public int nuevoAcuerdo (ProductoTrocado newPT) {
        String query = "INSERT into ProductoTrocado ( aceptaUser,aceptaDuenio,fecha,id_user,id_duenio,id_producto,token)  values (?,?,GETDATE(),?,?,?,?)";
        int fav = jdbcTemplate.update(query,newPT.getAceptaUser(),newPT.getAceptaDuenio(),newPT.getId_user(),newPT.getId_duenio(),newPT.getId_producto(),newPT.getToken());
        return fav;
    }

}
