package com.grupo5.SistemaTrueques.dao;
import com.grupo5.SistemaTrueques.entities.Favorito;
import com.grupo5.SistemaTrueques.entities.FavoritoIdProducto;
import com.grupo5.SistemaTrueques.entities.Producto;
import com.grupo5.SistemaTrueques.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Transactional
public class FavoritoDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<FavoritoIdProducto> findFavoritos (int id_usuario){
        //"select * FROM producto WHERE nombre like '%'";
        String sqlFind = "select * from dbo.favorito f left join dbo.producto p on f.id_producto = p.idP where f.id_usuarioF ="+id_usuario+"";
        return jdbcTemplate.query(sqlFind, BeanPropertyRowMapper.newInstance(FavoritoIdProducto.class));
    }

    public int eliminarFav ( int id_u, int id_p){
//        String sqlDelete = "delete from a_user where correo =?"; //es opcional
        String sqlDelete = "DELETE FROM favorito WHERE id_usuarioF=? and id_producto=?";
        int resultado = jdbcTemplate.update(sqlDelete, id_u, id_p);
        return resultado;
    }

    public int nuevoFavorito (Favorito newfav) {
        String query = "INSERT into favorito ( id_usuarioF,id_producto)  values (?,?)";
        int fav = jdbcTemplate.update(query,newfav.getId_usuarioF(),newfav.getId_producto());
        return fav;
    }
    public int countFav (int id_u){
        String sql = "SELECT count(*) FROM favorito WHERE id_usuarioF= ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[] { id_u }, Integer.class);
        return count;
    }
    public boolean ExistentesFav(int id_u,int id_p) {
        String sql = "SELECT count(*) FROM favorito WHERE id_usuarioF= ? and id_producto= ? ";
        int count = jdbcTemplate.queryForObject(sql, new Object[] { id_u,id_p }, Integer.class);
        return count > 0;
    }

}
