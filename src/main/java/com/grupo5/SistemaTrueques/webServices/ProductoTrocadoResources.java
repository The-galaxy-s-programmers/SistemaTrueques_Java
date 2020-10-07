package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.EnviarCorreo;
import com.grupo5.SistemaTrueques.dao.ProductoTrocadoDAO;
import com.grupo5.SistemaTrueques.entities.Producto;
import com.grupo5.SistemaTrueques.entities.ProductoTrocado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productoTrocado")
public class ProductoTrocadoResources {
    @Autowired
    ProductoTrocadoDAO productoTrocadoDAO;

    @Autowired
    EnviarCorreo enviarCorreo;

    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int crearAcuerdo (@RequestBody ProductoTrocado nuevo){
        return productoTrocadoDAO.nuevoAcuerdo(nuevo);
    }
    @RequestMapping(value = "/user/{token", method = RequestMethod.PUT)
    public int actualizarUser(@PathVariable("token") int token,@RequestBody ProductoTrocado producto) {
        int retorno = productoTrocadoDAO.aceptaUsuario(producto, token);
        return retorno;
    }
    @RequestMapping(value = "/duenio/{token}", method = RequestMethod.PUT)
    public int actualizarDuenio(@PathVariable("token") int token,@RequestBody ProductoTrocado producto) {
        int retorno = productoTrocadoDAO.aceptaDuenio(producto, token);
        return retorno;
    }
    @RequestMapping(value = "/find/{token}", method = RequestMethod.GET)
    public ProductoTrocado findProducto(@PathVariable("token") int token){
        return productoTrocadoDAO.Producto(token);
    }
    @RequestMapping(value = "/envio/{correo}/{token}")
    public int EnvioEmail (@PathVariable("correo") String correo,@PathVariable("token") Integer token){
        String web1 ="<!DOCTYPE html>" +
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
                "<h2 style='font-style: italic;color: white'>Felicitaciones se ha llegado un acuerdo" +
                "</h2>" +
                "<p style='font-style: italic;color: white'>El token de producto es = "+token+" " +
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
        enviarCorreo.enviarConGMail(correo,"Trueque realizado",web1);
        return 1;
    }
}
