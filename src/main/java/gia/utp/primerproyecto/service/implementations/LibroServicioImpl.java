package gia.utp.primerproyecto.service.implementations;

import gia.utp.primerproyecto.model.entities.LibroEntity;
import gia.utp.primerproyecto.model.repository.LibroRepository;
import gia.utp.primerproyecto.service.interfaces.LibroServicio;
import gia.utp.primerproyecto.service.interfaces.LibroVentaFacade;
import gia.utp.primerproyecto.web.dto.LibroDTO;

import gia.utp.primerproyecto.web.dto.response.LibroEditorialResponse;
import gia.utp.primerproyecto.web.exceptions.type.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LibroServicioImpl implements LibroServicio, LibroVentaFacade {

    @Autowired
    private LibroRepository libroRepository;/*Otra inyeccion mas de dependencias, esta es la del repositorio, nos facilita el manejo de la base de datos
    sin necesariamente usar sentencias SQL para interactuar con la base de datos.*/

    @Autowired
    private ModelMapper modelMapper; /*Este modelmapper requiere de un archivo de configuracion que ayuda a que sring pueda gestinarlo,
     ya que @Auyowired se encarga de hacer las inyecciones de dependecias necesarias*/


    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO){
        if(libroDTO.getNombre().isEmpty()) throw new BadRequestException("Los libros no pueden tener el nombre vacio");

        //Sentencia de comprobacion, en la practica aqui abrian validaciones para evitar guardar informacion mal indicada.

        LibroEntity libroEntity = modelMapper.map(libroDTO, LibroEntity.class);

        /* Creamos un Objeto de tipo LibroEntity que podamos guardar en la base de datos
        esto lo hacemos a partir de mapear la informacion del objeto DTO que solo tiene la informacion que llega, entonces mapeamos el libro de tipo DTO a un Entity
        con esto ya podemos usar el Entity para funciones/metodos de JPA*/

        libroEntity = libroRepository.save(libroEntity);

        /* Una vez tenemos el Entity, podemos utlizar metodos de repostirio con ayuda de la funciones que nos ofrece jpa para el manejo de entidades
        * entonces con ayuda de la interfaz que hereda dichas funciones, utilizamos el metodo save, que guarda la informacion en la DB*/

        return modelMapper.map(libroEntity, LibroDTO.class); //Finalmente mapeamos el Entity a  DTO para poder retornarlo, puesto que el metodo es de tipo DTO
    }

    @Override
    public LibroDTO obtenerLibro(Integer id) {
        LibroEntity  libroEntity = libroRepository.findById(id)
                .orElseThrow( () -> new BadRequestException("Libro No Econtrado"));
        return modelMapper.map(libroEntity, LibroDTO.class);
    }

    @Override
    public List<LibroEditorialResponse> obtenerLibrosPorEditorial(String edi) {
        //Validacion con exception
        List<LibroEntity> libroEntities = libroRepository.findAllByEditorial(edi)
                .orElseThrow( () -> new BadRequestException("No existen libros bajo esa editorial" + edi));

        List<LibroEditorialResponse> responseList = libroEntities.stream()
                .map(libroEntity -> modelMapper.map(libroEntity, LibroEditorialResponse.class))
                .collect(Collectors.toList()); // Esta monda vuelve el stream una lista, aletoso
        return responseList;
    }

    @Override
    public LibroDTO borrarLibro(Integer id) {
        LibroEntity libroEntity = libroRepository.findById(id)
                .orElseThrow(() ->new BadRequestException("Libro no encontrado para su borrado"));
        libroRepository.delete(libroEntity);
        return modelMapper.map(libroEntity, LibroDTO.class);
    }

    @Override
    public LibroDTO editarLibro(Integer id) {
        LibroEntity  libroEntity = libroRepository.findById(id)
                .orElseThrow( () -> new BadRequestException("Libro No Econtrado"));

        libroEntity.setNombre("MeEditaron");

        libroEntity.setAutor("LibritosSA");

        libroEntity =  libroRepository.save(libroEntity);

        return modelMapper.map(libroEntity, LibroDTO.class);
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
