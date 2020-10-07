package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.EnviarCorreo;
import com.grupo5.SistemaTrueques.dao.UsuarioDAO;
import com.grupo5.SistemaTrueques.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuarioResources {
    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    EnviarCorreo enviarCorreo;

    @RequestMapping(method = RequestMethod.GET) //READ-LEER
    public List<Usuario> obtenerListaUsuarios (){
        return usuarioDAO.listaUsuarios();
    }

    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int crearUsuario (@RequestBody Usuario nuevo){
        return usuarioDAO.crearUsuario(nuevo);
    }

    @RequestMapping(value = "/{idU}", method = RequestMethod.DELETE)
    public int eliminar(@PathVariable("idU") int idU){
        String web1 = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset='utf-8'>" +
                "<meta name='viewport' content='width=device-width,initial-scale=1.0'>" +
                "</head>" +
                "<body style='text-align: center'>" +
                "<table style=' border: 1px solid white; border-collapse: collapse;'>" +
                "<tr>" +
                "<th style='padding: 0px'>" +
                "<img src='https://lh3.googleusercontent.com/-arS7xS4j1Fk/X3yE4qaKHiI/AAAAAAAAKT4/UiXAATfJFPQKv-3PZYCstTBs8IMmdSlNQCNcBGAsYHQ/39BB3DE03F884CE0B4286A927E23A689.png' alt='Imagen Bienvenida' width='540' height='360'>" +
                "</th>" +
                "</tr>" +
                "<tr style=' border: 1px solid white; border-collapse: collapse;'>" +
                "<td align='center' bgcolor='#071f4f' style='background-color: #15161D'>" +
                "<h2 style='font-style: italic;color: white'>Lamentamos que te vayas ... " +
                "</h2>" +
                "<p style='font-style: italic;color: white'>Te esperaremos :)" +
                "</p>" +
                "<p> &#129418;" +
                "</p>" +
                "<a href='https://localhost:4200/' style='border-color: white ;color: white;background-color: red;border-radius: 5px 5px 5px 5px;height: 30px; width: 100px;margin-bottom: 10px'>Ir a trocar" +
                "</a>" +
                "</td>" +
                "</tr>" +
                "<tr style='border-top: 6px solid white;border-collapse: collapse;font-size: 12px;'>" +
                "<td style='background-color: #15161D;color:white'>Copyright &copy; 2020 All rights reserved" +
                "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "</html>";
        enviarCorreo.enviarConGMail(usuarioDAO.findIdUsuarioId(idU).getCorreo(),"Trueques galaxia ...",web1);
        int retorno = usuarioDAO.eliminarUsuarios(idU);
        return retorno;
    }

    // actualizar
    @RequestMapping(value = "/{idU}", method = RequestMethod.PUT)
    public int actualizar(@PathVariable("idU") int idU,@RequestBody Usuario usuario){
        int retorno = usuarioDAO.actualizarUsuarios(usuario, idU);
        return retorno;
    }

    @RequestMapping(value = "/find/{nomusuario}", method = RequestMethod.GET)
    public Usuario findId(@PathVariable("nomusuario") String nomusuario){
        return usuarioDAO.findIdUsuario(nomusuario);
    }
    @RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
    public Usuario findId(@PathVariable("id") int id){
        return usuarioDAO.findIdUsuarioId(id);
    }

    // Exist
    @RequestMapping(value = "/mail/{correo}", method = RequestMethod.GET)
    public boolean isExist (@PathVariable("correo") String correo){
        return usuarioDAO.ExistentesCorreo(correo);
    }
    @RequestMapping(value = "/user/{nomusuario}", method = RequestMethod.GET)
    public boolean isExistentente (@PathVariable("nomusuario") String nomusuario){
        return usuarioDAO.ExistentesNomUser(nomusuario);
    }
    @RequestMapping(value = "/envio/{correo}")
    public int EnvioEmail (@PathVariable("correo") String correo){
        String web1 = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset='utf-8'>" +
                "<meta name='viewport' content='width=device-width,initial-scale=1.0'>" +
                "</head>" +
                "<body style='text-align: center'>" +
                "<table style=' border: 1px solid white; border-collapse: collapse;'>" +
                "<tr>" +
                "<th style='padding: 0px'>" +
                "<img src='https://lh3.googleusercontent.com/-arS7xS4j1Fk/X3yE4qaKHiI/AAAAAAAAKT4/UiXAATfJFPQKv-3PZYCstTBs8IMmdSlNQCNcBGAsYHQ/39BB3DE03F884CE0B4286A927E23A689.png' alt='Imagen Bienvenida' width='540' height='360'>" +
                "</th>" +
                "</tr>" +
                "<tr style=' border: 1px solid white; border-collapse: collapse;'>" +
                "<td align='center' bgcolor='#071f4f' style='background-color: #15161D'>" +
                "<h2 style='font-style: italic;color: white'>Bienvenido a trueques galaxia" +
                "</h2>" +
                "<p style='font-style: italic;color: white'>Ahora podras disfrutar de muchos beneficios" +
                "</p>" +
                "<p> &#129418;" +
                "</p>" +
                "<a href='https://localhost:4200/' style='border-color: white ;color: white;background-color: red;border-radius: 5px 5px 5px 5px;height: 30px; width: 100px;margin-bottom: 10px'>Ir a trocar" +
                "</a>" +
                "</td>" +
                "</tr>" +
                "<tr style='border-top: 6px solid white;border-collapse: collapse;font-size: 12px;'>" +
                "<td style='background-color: #15161D;color:white'>Copyright &copy; 2020 All rights reserved" +
                "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "</html>";
        enviarCorreo.enviarConGMail(correo,"Bienvenido a trueques galaxia",web1);
        return 1;
    }

}
