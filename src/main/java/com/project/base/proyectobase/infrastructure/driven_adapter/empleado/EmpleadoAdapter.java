package com.project.base.proyectobase.infrastructure.driven_adapter.empleado;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import com.project.base.proyectobase.domain.model.empleado.gateway.EmpleadoGateway;
import com.project.base.proyectobase.infrastructure.driven_adapter.empleado.mapper.EmpleadoAdapterTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EmpleadoAdapter implements EmpleadoGateway {

    private final EmpleadoRepository empleadoRepository;

    private final EmpleadoAdapterTransformer empleadoAdapterTransformer;

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        EmpleadoEntity empleadoEntity = empleadoRepository.save(empleadoAdapterTransformer.empleadoToEmpleadoEntity(empleado));
        return empleadoAdapterTransformer.empleadoEntityToEmpleado(empleadoEntity);
    }

    @Override
    public Empleado consultarEmpleado(String cedula) {
        return empleadoRepository.findByCedula(cedula)
                .map(empleadoAdapterTransformer::empleadoEntityToEmpleado)
                .orElse(null);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        EmpleadoEntity empleadoActualizado = empleadoRepository.save(empleadoAdapterTransformer.empleadoToEmpleadoEntity(empleado));
        return empleadoAdapterTransformer.empleadoEntityToEmpleado(empleadoActualizado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleadoAdapterTransformer.empleadoToEmpleadoEntity(empleado));
    }

    @Override
    public Page<Empleado> buscarTodos(Pageable pageable) {
        Page<EmpleadoEntity> empleadosActivos = empleadoRepository.findAll(pageable);
        return empleadosActivos.map(empleadoAdapterTransformer::empleadoEntityToEmpleado);
    }

}
