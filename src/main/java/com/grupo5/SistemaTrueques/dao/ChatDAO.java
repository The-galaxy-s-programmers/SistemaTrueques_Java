package com.grupo5.SistemaTrueques.dao;
import com.grupo5.SistemaTrueques.entities.Chat;
import com.grupo5.SistemaTrueques.entities.Favorito;
import com.grupo5.SistemaTrueques.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Repository
@Transactional
public class ChatDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Chat> listChatId (int idP) {
        String query = "SELECT * FROM chat where id_producto ='"+idP+"' order by fecha desc";
        List<Chat> listaChatId = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Chat.class));
        return listaChatId;
    }
    public int crearMensaje (Chat newChat) {
        String query = "INSERT into chat (id_producto,id_user,mensaje,fecha,id_duenio,respuesta,nomUser,nomDuenio,nomProducto)  values (?,?,?,GETDATE(),?,?,?,?,?)";
        int productos = jdbcTemplate.update(query,newChat.getId_producto(),newChat.getId_user(),newChat.getMensaje(),newChat.getId_duenio(),newChat.getRespuesta(),newChat.getNomUser(),newChat.getNomDuenio(),newChat.getNomProducto());
        return productos;
    }
    public int responderMensaje (Chat newChat, int id) {
        String query = "Update chat set respuesta = ? where id =";
        int productos = jdbcTemplate.update(query,newChat.getId_producto(),newChat.getId_user(),newChat.getMensaje(),id);
        return productos;
    }
    public int eliminarMensaje(int id){
        String sqlDelete = "DELETE FROM chat WHERE id=?";
        int resultado = jdbcTemplate.update(sqlDelete, id);
        return resultado;
    }
}
