package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.EnviarCorreo;
import com.grupo5.SistemaTrueques.dao.SuscripcionDAO;
import com.grupo5.SistemaTrueques.entities.Suscripcion;
import com.grupo5.SistemaTrueques.entities.SuscripcionNormal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import java.util.concurrent.TimeUnit;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/suscripcion")
public class SuscripcionResources {
    @Autowired
    SuscripcionDAO suscripcionDAO;
    @Autowired
    EnviarCorreo enviarCorreo;
    
    @RequestMapping( method = RequestMethod.GET) //READ-LEER
    public List<SuscripcionNormal> obtenerListaNormal (){
        return suscripcionDAO.suscripcionNormal();
    }
    @RequestMapping(value = "/{correo}", method = RequestMethod.DELETE)
    public int eliminar(@PathVariable("correo") String correo){
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
                "<h2 style='font-style: italic;color: white'>Lamentamos que te vayas..." +
                "</h2>" +
                "<p style='font-style: italic;color: white'>Te seguiremos esperando" +
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
        enviarCorreo.enviarConGMail(correo,"Trueques Galaxy's...",web1);
        return suscripcionDAO.eliminarSuscripcion(correo);
    }
    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int newSub (@RequestBody SuscripcionNormal suscripcion) {
        return suscripcionDAO.nuevaSub(suscripcion);

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
                "<h2 style='font-style: italic;color: white'>Bienvenidos a Trueques Galaxy's" +
                "</h2>" +
                "<p style='font-style: italic;color: white'>Ahora recibiras noticias acerca de la pagina" +
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
        enviarCorreo.enviarConGMail(correo,"Bienvenido a Trueques Galaxy's",web1);
        return 1;
    }
}
