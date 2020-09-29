package com.grupo5.SistemaTrueques.dao;

import com.grupo5.SistemaTrueques.entities.Producto;
import com.grupo5.SistemaTrueques.entities.Usuario;
import javafx.scene.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.*;

@Repository
@Transactional
public class ProductoDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Producto> listaProductos () {
        String query = "SELECT * FROM producto";
        List<Producto> listproducto = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Producto.class));
        return listproducto;
    }
    public List<Producto> listaProductosId (int id) {
        String query = "SELECT * FROM producto where id_usuario= "+id+"";
        List<Producto> listproducto = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Producto.class));
        return listproducto;
    }

    public int crearProducto (Producto newProducto) {
        String query = "INSERT into producto (nombre,descripcion ,categoria ,fechaPublicacion,uso ,imagen ,valorReferencia ,ubicacion, subcategoria)  values (?,?,?,?,?,?,?,?,?)";
        int productos = jdbcTemplate.update(query,newProducto.getNombre(),newProducto.getDescripcion(),newProducto.getCategoria(),newProducto.getFechaPublicacion(),newProducto.getUso(),newProducto.getImagen(),newProducto.getValorReferencia(),newProducto.getUbicacion(),newProducto.getSubcategoria());
        return productos;
    }

    public int actualizarProductos (Producto producto, int idP){
        String sqlUpdate = "UPDATE producto set nombre = ?, descripcion = ?, categoria = ?, fechaPublicacion = ?, uso = ?, imagen=?, valorReferencia=?, ubicacion =? ,subcategoria =? where idP = ?";
        int resultado = jdbcTemplate.update(sqlUpdate,producto.getNombre(), producto.getDescripcion(), producto.getCategoria(), producto.getFechaPublicacion(), producto.getUso(),producto.getImagen(),producto.getValorReferencia(), producto.getUbicacion(), producto.getSubcategoria(), idP );
        return resultado;
    }

    public int eliminarProductos ( int idP){
//        String sqlDelete = "delete from a_user where correo =?"; //es opcional
        String sqlDelete = "DELETE FROM producto WHERE idP=?";
        int resultado = jdbcTemplate.update(sqlDelete, idP);
        return resultado;
    }

    public List<Producto> findNameProductos ( String nombre ){
        //"select * FROM producto WHERE nombre like '%'";
        String sqlFind = "select * FROM producto WHERE nombre like '"+nombre+"%' or categoria like '"+nombre+"%' or subcategoria like '"+nombre+"%'" ;
        return jdbcTemplate.query(sqlFind, BeanPropertyRowMapper.newInstance(Producto.class));
    }
    public Producto findIdProductos ( int id){
        //"select * FROM producto WHERE nombre like '%'";
        String sqlFind = "select * FROM producto WHERE idP =?";
        return (Producto) jdbcTemplate.queryForObject(sqlFind,new Object[] {id}, new BeanPropertyRowMapper(Producto.class));
    }
    public List<Producto> listaProductosCategoria (String Categoria) {
        String query = "SELECT * FROM producto where categoria='"+Categoria+"'";
        List<Producto> listproducto = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Producto.class));
        return listproducto;
    }
    public List<Producto> top3Productos ( String categoria){
        //"select * FROM producto WHERE nombre like '%'";
        String sqlFind = "SELECT top 3 * from GRUPOn5.dbo.producto p where categoria = '"+categoria+"' order by fechaPublicacion DESC";
        return jdbcTemplate.query(sqlFind, BeanPropertyRowMapper.newInstance(Producto.class));
    }

    public List<Producto> topBeforeProductos() {
        //"select * FROM producto WHERE nombre like '%'";
        String sqlFind = "SELECT top 4 * from GRUPOn5.dbo.producto p order by fechaPublicacion DESC ";
        return jdbcTemplate.query(sqlFind, BeanPropertyRowMapper.newInstance(Producto.class));
    }
    public List<Producto> topBeforeCategoriaProductos(String categoria) {
        //"select * FROM producto WHERE nombre like '%'";
        String sqlFind = "SELECT top 4 * from GRUPOn5.dbo.producto p where categoria ='"+categoria+"' order by fechaPublicacion DESC ";
        return jdbcTemplate.query(sqlFind, BeanPropertyRowMapper.newInstance(Producto.class));
    }
    public List<Producto> topAfter4Productos() {
        //"select * FROM producto WHERE nombre like '%'";
        String sqlFind = "SELECT * from GRUPOn5.dbo.producto p  order by fechaPublicacion DESC OFFSET 4 ROW FETCH next 4 row only";
        return jdbcTemplate.query(sqlFind, BeanPropertyRowMapper.newInstance(Producto.class));
    }
}