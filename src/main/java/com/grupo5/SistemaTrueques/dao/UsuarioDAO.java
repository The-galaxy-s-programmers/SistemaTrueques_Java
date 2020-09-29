package com.grupo5.SistemaTrueques.dao;

import com.grupo5.SistemaTrueques.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Repository
@Transactional

public class UsuarioDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Usuario> listaUsuarios () {
        String query = "SELECT * FROM usuario";
        List<Usuario> listaUsu = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Usuario.class));
        return listaUsu;
    }

    public int crearUsuario (Usuario newuser) {
        String query = "INSERT into usuario (nomusuario,nombre ,apellido ,fechaNacimiento,correo ,region ,comuna ,genero ,foto , password, direccion, fono)  values (?,?,?,?,?,?,?,?,?,?,?,?)";
        int usuarios = jdbcTemplate.update(query,newuser.getNomusuario(),newuser.getNombre(),newuser.getApellido(),newuser.getFechaNacimiento(),newuser.getCorreo(),newuser.getRegion(),newuser.getComuna(),newuser.getGenero(),newuser.getFoto(),newuser.getPassword(),newuser.getDireccion(),newuser.getFono());
        return usuarios;
    }

    public int eliminarUsuarios ( int idU){
//        String sqlDelete = "delete from a_user where correo =?"; //es opcional
        String sqlDelete = "DELETE FROM usuario WHERE idU=?";
        int resultado = jdbcTemplate.update(sqlDelete, idU);
        return resultado;
    }
    public int actualizarUsuarios (Usuario putUsuario, int idU){
        String sqlUpdate = "UPDATE usuario set nomusuario =?,nombre =?,apellido =?,fechaNacimiento =?,correo =?, region =?,comuna =?, genero =?, foto =?, password=?, direccion=?,fono=? WHERE idU=?";
        int resultado = jdbcTemplate.update(sqlUpdate,putUsuario.getNomusuario(), putUsuario.getNombre(), putUsuario.getApellido(), putUsuario.getFechaNacimiento(), putUsuario.getCorreo(), putUsuario.getRegion(),putUsuario.getComuna(),putUsuario.getGenero(),putUsuario.getFoto(),putUsuario.getPassword(),putUsuario.getDireccion(),putUsuario.getFono(),idU);
        return resultado;
    }

    public Usuario findIdUsuario ( String nomusuario){
        String sqlFind = "select * FROM usuario WHERE nomusuario = ?";
        return (Usuario) jdbcTemplate.queryForObject(sqlFind, new Object[]{nomusuario},new BeanPropertyRowMapper(Usuario.class));
    }
    public Usuario findIdUsuarioId ( int id ){
        String sqlFind = "select * FROM usuario WHERE idU = ?";
        return (Usuario) jdbcTemplate.queryForObject(sqlFind, new Object[]{id},new BeanPropertyRowMapper(Usuario.class));
    }

    public boolean ExistentesCorreo(String correo) {
        String sql = "SELECT count(*) FROM usuario WHERE correo = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[] { correo }, Integer.class);
        return count > 0;
    }
    public boolean ExistentesNomUser(String nomusuario) {
        String sql = "SELECT count(*) FROM usuario WHERE nomusuario = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[] { nomusuario }, Integer.class);
        return count > 0;
    }

}