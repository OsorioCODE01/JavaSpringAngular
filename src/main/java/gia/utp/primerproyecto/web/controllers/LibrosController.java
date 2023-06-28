package gia.utp.primerproyecto.web.controllers;

import gia.utp.primerproyecto.service.interfaces.LibroServicio;
import gia.utp.primerproyecto.web.dto.LibroDTO;
import gia.utp.primerproyecto.web.dto.response.LibroEditorialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<LibroDTO> crearLibro(@RequestBody LibroDTO libroDTO) {
        return new ResponseEntity<>(libroServicio.crearLibro(libroDTO), HttpStatus.CREATED);
    }

    /**
     * Metodo para obteneer un libro
     *
     * @param id Dato con el que se realiza la busqueda del libro
     */
    @GetMapping("obtenerLibro")
    public ResponseEntity< LibroDTO> obtenerLibro(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(libroServicio.obtenerLibro(id), HttpStatus.OK) ;
    }

    @GetMapping("obtenerLibrosPorEditorial")
    public ResponseEntity<List<LibroEditorialResponse>> obtenerLibroPorEditorial (
            @RequestParam("editorial") String edi){
        return new ResponseEntity<>(libroServicio.obtenerLibrosPorEditorial(edi),HttpStatus.FOUND);
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
