package com.project.base.proyectobase.domain.usecase.empleado;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import com.project.base.proyectobase.domain.model.empleado.gateway.EmpleadoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpleadoUseCase {

    private final EmpleadoGateway empleadoGateway;

    public Empleado guardarEmpleado(Empleado empleado){
        return empleadoGateway.guardarEmpleado(empleado);
    }
}
