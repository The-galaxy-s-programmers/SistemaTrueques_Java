package com.grupo5.SistemaTrueques.dao;
import com.grupo5.SistemaTrueques.entities.Chat;
import com.grupo5.SistemaTrueques.entities.ChatPriv;
import com.grupo5.SistemaTrueques.entities.ChatPrivDuenio;
import com.grupo5.SistemaTrueques.entities.ChatPrivToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Transactional
public class ChatPrivDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ChatPriv> listChatId (int idP,int idU,int idD) {
        String query = "SELECT * FROM chatPriv where id_producto = "+idP+" and id_user = "+idU+" and id_duenio = "+idD+" order by fecha desc";
        List<ChatPriv> listaChatId = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ChatPriv.class));
        return listaChatId;
    }
    public List<ChatPriv> listChatTtoken (int token) {
        String query = "SELECT * from GRUPOn5.dbo.chatPriv where token = "+token+" order by fecha asc";
        List<ChatPriv> listaChatId = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ChatPriv.class));
        return listaChatId;
    }
    public List<ChatPrivToken> listChat (int id) {
        String query = "select token,nomProducto from GRUPOn5.dbo.chatPriv cp  where id_user = "+id+" or id_duenio = "+id+" GROUP by token,nomProducto ";
        List<ChatPrivToken> listaChatId = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ChatPrivToken.class));
        return listaChatId;
    }
    public List<ChatPriv> listChatToken (int id) {
        String query = "SELECT top 1 * from GRUPOn5.dbo.chatPriv where token = "+id;
        List<ChatPriv> listaChatId = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ChatPriv.class));
        return listaChatId;
    }

    public int crearMensaje (ChatPriv newChat) {
        String query = "INSERT into chatPriv (id_producto,id_user,mensaje,fecha,id_duenio,nomUser,nomDuenio,nomProducto,token,mensajePor)  values (?,?,?,GETDATE(),?,?,?,?,?,?)";
        int productos = jdbcTemplate.update(query,newChat.getId_producto(),newChat.getId_user(),newChat.getMensaje(),newChat.getId_duenio(),newChat.getNomUser(),newChat.getNomDuenio(),newChat.getNomProducto(),newChat.getToken(),newChat.getMensajePor());
        return productos;
    }
    public int eliminarMensaje(int id){
        String sqlDelete = "DELETE FROM chatPriv WHERE token=?";
        int resultado = jdbcTemplate.update(sqlDelete, id);
        return resultado;
    }
}
