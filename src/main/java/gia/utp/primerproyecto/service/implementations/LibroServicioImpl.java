package gia.utp.primerproyecto.service.implementations;

import gia.utp.primerproyecto.service.interfaces.LibroServicio;
import gia.utp.primerproyecto.service.interfaces.LibroVentaFacade;
import gia.utp.primerproyecto.web.dto.LibroDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class LibroServicioImpl implements LibroServicio, LibroVentaFacade {

    private List<LibroDTO> libroDTOS = new ArrayList<>();
    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO){
        libroDTOS.add(libroDTO);
        return libroDTOS.get(libroDTO.getId());
    }

    @Override
    public LibroDTO obtenerLibro(Integer id) {
        return null;
    }

    @Override
    public LibroDTO borrarLibro(LibroDTO libroDTO) {
        return null;
    }

    @Override
    public LibroDTO editarLibro(LibroDTO libroDTO) {
        return null;
    }

    @Override
    public LibroDTO venderLibro(Integer idLibro, Double precioLibro) {
        return null;
    }

    @Override
    public LibroDTO devolverLibro(Integer idVenta) {
        return null;
    }
}
