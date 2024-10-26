package com.project.base.proyectobase.domain.usecase.empleado;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import com.project.base.proyectobase.domain.model.empleado.gateway.EmpleadoGateway;
import com.project.base.proyectobase.domain.model.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class EmpleadoUseCase {

    private final String ESTADO = "ACTIVO";

    private final EmpleadoGateway empleadoGateway;

    public Empleado guardarEmpleado(Empleado empleado){
        empleado.setEstado(ESTADO);
        return empleadoGateway.guardarEmpleado(empleado);
    }

    public Empleado consultarEmpleado(String cedula){
        Empleado empleado = empleadoGateway.consultarEmpleado(cedula);
        if (Objects.isNull(empleado)) throw new BusinessException(BusinessException.Type.EMPLEADO_NO_EXISTE);
        return empleado;
    }
}
