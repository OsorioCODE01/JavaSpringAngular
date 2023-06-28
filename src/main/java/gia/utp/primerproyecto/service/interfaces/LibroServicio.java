package gia.utp.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.web.dto.LibroDTO;
import gia.utp.primerproyecto.web.dto.response.LibroEditorialResponse;

import java.util.List;

public interface LibroServicio { //Interfaz clase abstracta

    LibroDTO crearLibro(LibroDTO libroDTO);

    LibroDTO obtenerLibro(Integer id);

    LibroDTO borrarLibro(LibroDTO libroDTO);

    LibroDTO editarLibro(LibroDTO libroDTO);

    List<LibroEditorialResponse> obtenerLibrosPorEditorial(String edi);
}
