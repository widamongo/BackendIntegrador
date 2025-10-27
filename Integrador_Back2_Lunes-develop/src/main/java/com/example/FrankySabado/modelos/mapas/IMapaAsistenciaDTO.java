package com.example.FrankySabado.modelos.mapas;

import com.example.FrankySabado.modelos.Asistencia;
import com.example.FrankySabado.modelos.dtos.AsistenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaAsistenciaDTO {

    IMapaAsistenciaDTO INSTANCE = Mappers.getMapper(IMapaAsistenciaDTO.class);

    // Mapeo de modelo a DTO (corresponde a los campos enviados por el formulario React)
    @Mapping(source = "id", target = "id")
    @Mapping(source = "estudianteNombre", target = "estudianteNombre")
    @Mapping(source = "grado", target = "grado")
    @Mapping(source = "asignatura", target = "asignatura")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "hora", target = "hora")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "observacion", target = "observacion")
    @Mapping(source = "usuarioId", target = "usuarioId")
    AsistenciaDTO convertir_modelo_a_dto(Asistencia asistencia);

    // Mapeo de lista de modelos a lista de DTOs
    List<AsistenciaDTO> convertir_lista_a_dto(List<Asistencia> lista);
}