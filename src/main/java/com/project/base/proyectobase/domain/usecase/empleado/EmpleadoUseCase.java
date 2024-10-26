package com.project.base.proyectobase.domain.usecase.empleado;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import com.project.base.proyectobase.domain.model.empleado.gateway.EmpleadoGateway;
import com.project.base.proyectobase.domain.model.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class EmpleadoUseCase {

    private final String ACTIVO = "ACTIVO";

    private final String INACTIVO = "INACTIVO";

    private final EmpleadoGateway empleadoGateway;

    public Empleado guardarEmpleado(Empleado empleado){
        empleado.setEstado(ACTIVO);
        return empleadoGateway.guardarEmpleado(empleado);
    }

    public Empleado consultarEmpleado(String cedula){
        Empleado empleado = empleadoGateway.consultarEmpleado(cedula);
        if (Objects.isNull(empleado)) throw new BusinessException(BusinessException.Type.EMPLEADO_NO_EXISTE);
        if (empleado.getEstado().equals(INACTIVO)) throw new BusinessException(BusinessException.Type.EMPLEADO_ELIMINADO);
        return empleado;
    }

    public Empleado actualizarEmpleado(Empleado empleado, String cedula){
        Empleado empleadoPorCedula = empleadoGateway.consultarEmpleado(cedula);
        if (Objects.isNull(empleadoPorCedula)) throw new BusinessException(BusinessException.Type.EMPLEADO_NO_EXISTE);
        if (empleadoPorCedula.getEstado().equals(INACTIVO)) throw new BusinessException(BusinessException.Type.EMPLEADO_ELIMINADO);
        empleadoPorCedula.setNombre(empleado.getNombre());
        empleadoPorCedula.setEstado(empleado.getEstado());
        return empleadoGateway.actualizarEmpleado(empleadoPorCedula);
    }

    public void eliminarEmpleado(String cedula){

        Empleado empleadoAEliminar = empleadoGateway.consultarEmpleado(cedula);
        if (Objects.isNull(empleadoAEliminar)) throw new BusinessException(BusinessException.Type.EMPLEADO_NO_EXISTE);
        if (empleadoAEliminar.getEstado().equals(INACTIVO)) throw new BusinessException(BusinessException.Type.EMPLEADO_ELIMINADO);
        empleadoAEliminar.setEstado(INACTIVO);
        empleadoGateway.eliminarEmpleado(empleadoAEliminar);
    }

}
