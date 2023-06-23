package gia.utp.primerproyecto;

import org.springframework.web.bind.annotation.*;
import sun.java2d.loops.BlitBg;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apiLibros/v1") //Es un mapeo de peteicion, a donde me dirijo
public class LibrosController {

    private List<LibroDTO> libroDTOS = new ArrayList<>();
    @PostMapping("crearLibro")
    public LibroDTO crearLibro (@RequestBody LibroDTO libroDTO) {
        libroDTOS.add(libroDTO);
        return libroDTOS.get(libroDTO.getId());
    }

    @GetMapping("obtenerLibro")
    public LibroDTO obtenerLibro(@RequestParam Integer id){
        return libroDTOS.get(id);
    }

    @DeleteMapping("borrarLibro")
    public String borrarLibro (@RequestParam Integer id){
        libroDTOS.remove(id);
        return "Eliminado libro con id: " + id;
    }

    @PutMapping("editarLibro")
    public LibroDTO editarLibro(@RequestBody LibroDTO libroDTO){
        Integer id = libroDTO.getId();
        libroDTOS.remove(id);
        libroDTO.setId(id);
        libroDTO.setNombre("Nicolas");
        libroDTO.setAutor("Autor?JAJA");
        libroDTO.setEditorial("LibritosJIJI");
        libroDTOS.add(libroDTO);
        return libroDTO;
    }
}
