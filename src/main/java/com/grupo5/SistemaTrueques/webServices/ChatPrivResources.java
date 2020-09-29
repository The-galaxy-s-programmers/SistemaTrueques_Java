package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.dao.ChatDAO;
import com.grupo5.SistemaTrueques.dao.ChatPrivDAO;
import com.grupo5.SistemaTrueques.entities.Chat;
import com.grupo5.SistemaTrueques.entities.ChatPriv;
import com.grupo5.SistemaTrueques.entities.ChatPrivDuenio;
import com.grupo5.SistemaTrueques.entities.ChatPrivToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/chatPriv")
public class ChatPrivResources {
    @Autowired
    ChatPrivDAO chatDAO;

    @RequestMapping(value = "/{idP}/{idU}/{idD}", method = RequestMethod.GET) //READ-LEER
    public List<ChatPriv> obtenerListaChatId (@PathVariable("idP") int idP,@PathVariable("idU") int idU,@PathVariable("idD") int idD){
        return chatDAO.listChatId(idP,idU,idD);
    }
    @RequestMapping(value = "/idToken/{token}", method = RequestMethod.GET) //READ-LEER
    public List<ChatPriv> obtenerListaChatxTOPKEN (@PathVariable("token") int token){
        return chatDAO.listChatTtoken(token);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //READ-LEER
    public List<ChatPrivToken> obtenerListaChat (@PathVariable("id") int id){
        return chatDAO.listChat(id);
    }
    @RequestMapping(value = "/token/{id}", method = RequestMethod.GET) //READ-LEER
    public List<ChatPriv> obtenerLista(@PathVariable("id") int id){
        return chatDAO.listChatToken(id);
    }
    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int EnviarMensaje (@RequestBody ChatPriv nuevo){
        return chatDAO.crearMensaje(nuevo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int eliminar(@PathVariable("id") int id){
        int retorno = chatDAO.eliminarMensaje(id);
        return retorno;
    }
}
