package gia.utp.primerproyecto.web.controllers;

import gia.utp.primerproyecto.service.interfaces.LibroServicio;
import gia.utp.primerproyecto.web.dto.LibroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apiLibros/v1") //Es un mapeo de peteicion, a donde me dirijo
public class LibrosController {


    @Autowired
    private LibroServicio libroServicio;

    /**
     * Metodo para crear un libro
     *
     * @param libroDTO se recibe la informacion del objeto
     */
    @PostMapping("crearLibro")
    public LibroDTO crearLibro(@RequestBody LibroDTO libroDTO) {
        return libroServicio.crearLibro(libroDTO);
    }

    /**
     * Metodo para obteneer un libro
     *
     * @param id Dato con el que se realiza la busqueda del libro
     */
    @GetMapping("obtenerLibro")
    public LibroDTO obtenerLibro(@RequestParam Integer id) {
        return libroServicio.obtenerLibro(id);
    }

    @DeleteMapping
   public LibroDTO borrarLibro(@RequestBody LibroDTO libroDTO){
        return  libroServicio.borrarLibro(libroDTO);
    }

    @PutMapping
    public  LibroDTO editarLibro(@RequestBody LibroDTO libroDTO){
        return libroServicio.editarLibro(libroDTO);
    }
}
