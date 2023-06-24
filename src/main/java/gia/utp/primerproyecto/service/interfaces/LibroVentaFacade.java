package gia.utp.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.web.dto.LibroDTO;

public interface LibroVentaFacade {
    LibroDTO venderLibro(Integer idLibro, Double precioLibro);
    LibroDTO devolverLibro(Integer idVenta);
}
