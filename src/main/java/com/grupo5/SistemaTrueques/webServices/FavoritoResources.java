package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.dao.FavoritoDAO;
import com.grupo5.SistemaTrueques.dao.ProductoDAO;
import com.grupo5.SistemaTrueques.entities.Favorito;
import com.grupo5.SistemaTrueques.entities.FavoritoIdProducto;
import com.grupo5.SistemaTrueques.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/favorito")
public class FavoritoResources {

    @Autowired
    FavoritoDAO favoritoDAO;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<FavoritoIdProducto> findNombre(@PathVariable("id") int id){
        return favoritoDAO.findFavoritos(id);
    }

    //@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @RequestMapping(value = "/{id_u}/{id_p}", method = RequestMethod.DELETE)
    public int eliminar(@PathVariable("id_u") int id_u,@PathVariable("id_p") int id_p){
        return favoritoDAO.eliminarFav(id_u, id_p);
    }
    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int crearFavorito (@RequestBody Favorito nuevo){
        return favoritoDAO.nuevoFavorito(nuevo);
    }
    @RequestMapping(value = "/find/{id_usuarioF}", method = RequestMethod.GET)
    public int FavoritoCount (@PathVariable("id_usuarioF") int id){
        return favoritoDAO.countFav(id);
    }

    @RequestMapping(value = "/find/{id_u}/{id_p}", method = RequestMethod.GET)
    public boolean isExist (@PathVariable("id_u") int id_u,@PathVariable("id_p") int id_p){
        return favoritoDAO.ExistentesFav(id_u,id_p);
    }
}
