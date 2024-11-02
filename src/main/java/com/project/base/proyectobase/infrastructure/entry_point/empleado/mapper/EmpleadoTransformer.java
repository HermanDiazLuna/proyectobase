package com.project.base.proyectobase.infrastructure.entry_point.empleado.mapper;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface EmpleadoTransformer {

    Empleado empleadoDTOToEmpleado(EmpleadoDTO empleadoDTO);
    EmpleadoDTO empleadoToEmpleadoDTO(Empleado empleado);
    //Page<EmpleadoDTO> listaEmpleadosToListaEmpleadosDTO(Page<Empleado> empleadoList);

}
