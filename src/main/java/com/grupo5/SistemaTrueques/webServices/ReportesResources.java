package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.dao.ReportesDAO;
import com.grupo5.SistemaTrueques.entities.Reportes;
import com.grupo5.SistemaTrueques.entities.Suscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reportes")
public class ReportesResources {
     @Autowired
    ReportesDAO reportesDAO;

    @RequestMapping( value = "/comentario", method = RequestMethod.GET) //READ-LEER
    public List<Reportes> obtenerListaC (){
        return reportesDAO.ReportComentList();
    }
    @RequestMapping( value = "/productos", method = RequestMethod.GET) //READ-LEER
    public List<Reportes> obtenerListaP (){
        return reportesDAO.ReportProducList();
    }
    @RequestMapping( value = "/ayuda", method = RequestMethod.GET) //READ-LEER
    public List<Reportes> obtenerListaA (){
        return reportesDAO.ReportAyudaList();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int eliminar(@PathVariable("id") int id){
        return reportesDAO.eliminarReporte(id);
    }
    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int newSub (@RequestBody Reportes reportes){
        return reportesDAO.nuevoReport(reportes);
    }
}
