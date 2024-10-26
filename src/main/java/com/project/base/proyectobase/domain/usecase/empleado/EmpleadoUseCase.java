package com.project.base.proyectobase.domain.usecase.empleado;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import com.project.base.proyectobase.domain.model.empleado.gateway.EmpleadoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpleadoUseCase {

    private final String ESTADO = "ACTIVO";

    private final EmpleadoGateway empleadoGateway;

    public Empleado guardarEmpleado(Empleado empleado){
        empleado.setEstado(ESTADO);
        return empleadoGateway.guardarEmpleado(empleado);
    }

    public Empleado consultarEmpleado(String cedula){
        return empleadoGateway.consultarEmpleado(cedula);
    }
}
