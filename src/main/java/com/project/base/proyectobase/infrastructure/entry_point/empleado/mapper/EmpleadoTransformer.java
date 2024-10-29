package com.project.base.proyectobase.infrastructure.entry_point.empleado.mapper;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmpleadoTransformer {

    Empleado empleadoDTOToEmpleado(EmpleadoDTO empleadoDTO);
    EmpleadoDTO empleadoToEmpleadoDTO(Empleado empleado);
    List<EmpleadoDTO> listaEmpleadosToListaEmpleadosDTO(List<Empleado> empleadoList);

}
