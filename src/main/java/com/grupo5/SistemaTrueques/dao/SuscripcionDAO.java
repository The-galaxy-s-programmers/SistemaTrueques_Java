package com.grupo5.SistemaTrueques.dao;

import com.grupo5.SistemaTrueques.EnviarCorreo;
import com.grupo5.SistemaTrueques.entities.Chat;
import com.grupo5.SistemaTrueques.entities.Favorito;
import com.grupo5.SistemaTrueques.entities.Suscripcion;
import com.grupo5.SistemaTrueques.entities.SuscripcionNormal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SuscripcionDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    EnviarCorreo enviarCorreo;

    public List<Suscripcion> suscripcionList () {
        String query = "SELECT correo FROM suscripcion";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Suscripcion.class));
    }
    public List<SuscripcionNormal> suscripcionNormal () {
        String query = "SELECT * FROM suscripcion";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(SuscripcionNormal.class));
    }
    public int eliminarSuscripcion ( String correo){
        String sqlDelete = "DELETE FROM suscripcion WHERE correo=?";
        return jdbcTemplate.update(sqlDelete,correo);
    }

    public int nuevaSub (SuscripcionNormal newSub) {
        String query = "INSERT into suscripcion  (correo)  values (?)";
        return jdbcTemplate.update(query,newSub.getCorreo());
    }

}
