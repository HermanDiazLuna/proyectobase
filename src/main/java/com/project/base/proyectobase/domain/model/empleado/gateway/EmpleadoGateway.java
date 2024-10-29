package com.project.base.proyectobase.domain.model.empleado.gateway;

import com.project.base.proyectobase.domain.model.empleado.Empleado;

import java.util.List;

public interface EmpleadoGateway {

    Empleado guardarEmpleado(Empleado empleado);

    Empleado consultarEmpleado(String cedula);

    Empleado actualizarEmpleado(Empleado empleado);

    void eliminarEmpleado(Empleado empleado);

    List<Empleado> buscarTodos();
}
