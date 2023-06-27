package gia.utp.primerproyecto.service.implementations;

import gia.utp.primerproyecto.model.entities.LibroEntity;
import gia.utp.primerproyecto.model.repository.LibroRepository;
import gia.utp.primerproyecto.service.interfaces.LibroServicio;
import gia.utp.primerproyecto.service.interfaces.LibroVentaFacade;
import gia.utp.primerproyecto.web.dto.LibroDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class LibroServicioImpl implements LibroServicio, LibroVentaFacade {


    private LibroRepository libroRepository;

    //private EntityManager entityManager;

    private ModelMapper modelMapper;
    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO){
       // if(libroDTO.getNombre().isEmpty()){ return null;}
        LibroEntity libroEntity = modelMapper.map(libroDTO, LibroEntity.class);
         /*   LibroEntity libroEntity = LibroEntity.builder()
                .nombreLibro(libroDTO.getNombre())
                .autorLibro(libroDTO.getAutor())
                .editorial(libroDTO.getEditorial())
                .build();
        */

        //entityManager.clear();

        libroEntity = libroRepository.save(libroEntity);

        return modelMapper.map(libroEntity, LibroDTO.class);
               /*
               * LibroDTO.builder()
                .id(libroEntity.getId())
                .autor(libroEntity.getAutorLibro())
                .nombre(libroEntity.getNombreLibro())
                .editorial(libroEntity.getEditorial())
                .build();
                * */

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
