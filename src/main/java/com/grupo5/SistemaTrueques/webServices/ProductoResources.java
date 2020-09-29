package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.dao.ProductoDAO;
import com.grupo5.SistemaTrueques.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/producto")
public class ProductoResources {

    @Autowired
    ProductoDAO productoDAO;

    @RequestMapping(method = RequestMethod.GET) //READ-LEER
    public List<Producto> obtenerListaProductos (){
        return productoDAO.listaProductos();
    }

    @RequestMapping(value = "/idU/{id}",method = RequestMethod.GET) //READ-LEER
    public List<Producto> obtenerListaProductosId (@PathVariable ("id") int id){
        return productoDAO.listaProductosId(id);
    }

    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int crearProducto (@RequestBody Producto nuevo){
        return productoDAO.crearProducto(nuevo);
    }

    // eliminar
    //@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @RequestMapping(value = "/{idP}", method = RequestMethod.DELETE)
    public int eliminar(@PathVariable("idP") int idP){
        int retorno = productoDAO.eliminarProductos(idP);
        return retorno;
    }
    // actualizar
    @RequestMapping(value = "/{idP}", method = RequestMethod.PUT)
    public int actualizar(@PathVariable("idP") int idP,@RequestBody Producto producto) {
        int retorno = productoDAO.actualizarProductos(producto, idP);
        return retorno;
    }

    @RequestMapping(value = "/find/nombre/{nombre}", method = RequestMethod.GET)
    public List<Producto> findNombre(@PathVariable("nombre") String nombre){
        return productoDAO.findNameProductos(nombre);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Producto findNombre(@PathVariable("id") int id){
        return productoDAO.findIdProductos(id);
    }

    @RequestMapping(value = "/find/categoria/{categoria}",method = RequestMethod.GET) //READ-LEER
    public List<Producto> obtenerListaProductos (@PathVariable("categoria") String Categoria){
        return productoDAO.listaProductosCategoria(Categoria);
    }
    @RequestMapping(value = "/find/top/{categoria}", method = RequestMethod.GET)
    public List<Producto> Top3(@PathVariable("categoria") String categoria){
        return productoDAO.top3Productos(categoria);
    }
    @RequestMapping(value = "/top4", method = RequestMethod.GET)
    public List<Producto> Top4(){
        return productoDAO.topBeforeProductos();
    }

    @RequestMapping(value = "/top4/{categoria}", method = RequestMethod.GET)
    public List<Producto> Top4(@PathVariable("categoria") String categoria){
        return productoDAO.topBeforeCategoriaProductos(categoria);
    }

    @RequestMapping(value = "/top8", method = RequestMethod.GET)
    public List<Producto> Top8(){
        return productoDAO.topAfter4Productos();
    }

}
