package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.dao.ChatDAO;
import com.grupo5.SistemaTrueques.dao.FavoritoDAO;
import com.grupo5.SistemaTrueques.entities.Chat;
import com.grupo5.SistemaTrueques.entities.Favorito;
import com.grupo5.SistemaTrueques.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/chat")
public class ChatResources {
    @Autowired
    ChatDAO chatDAO;

    @RequestMapping(value = "/{idP}", method = RequestMethod.GET) //READ-LEER
    public List<Chat> obtenerListaChatId (@PathVariable("idP") int idP){
        return chatDAO.listChatId(idP);
    }
    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int EnviarMensaje (@RequestBody Chat nuevo){
        return chatDAO.crearMensaje(nuevo);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public int Responder(@PathVariable("id") int id,@RequestBody Chat chat) {
        int retorno = chatDAO.responderMensaje(chat, id);
        return retorno;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int eliminar(@PathVariable("id") int id){
        int retorno = chatDAO.eliminarMensaje(id);
        return retorno;
    }
}
