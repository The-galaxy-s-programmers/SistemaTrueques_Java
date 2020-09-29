package com.grupo5.SistemaTrueques.dao;

import com.grupo5.SistemaTrueques.entities.Favorito;
import com.grupo5.SistemaTrueques.entities.Reportes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ReportesDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Reportes> ReportComentList () {
        String query = "SELECT * FROM reportes where tipo = 'Comentario'";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Reportes.class));
    }
    public List<Reportes> ReportProducList () {
        String query = "SELECT * FROM reportes where tipo = 'Producto'";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Reportes.class));
    }
    public List<Reportes> ReportAyudaList () {
        String query = "SELECT * FROM reportes where tipo = 'Ayuda'";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Reportes.class));
    }

    public int eliminarReporte ( int id){
//        String sqlDelete = "delete from a_user where correo =?"; //es opcional
        String sqlDelete = "DELETE FROM reportes WHERE id=?";
        return jdbcTemplate.update(sqlDelete, id);
    }

    public int nuevoReport (Reportes newReport) {
        String query = "INSERT into reportes ( id_usuario,fecha,comentario,correo,nombre,tipo)  values (?,?,?,?,?,?)";
        return jdbcTemplate.update(query,newReport.getId_usuario(),newReport.getFecha(),newReport.getComentario(),newReport.getCorreo(),newReport.getNombre(),newReport.getTipo());
    }

}
