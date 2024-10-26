package com.project.base.proyectobase.infrastructure.driven_adapter.empleado;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import com.project.base.proyectobase.domain.model.empleado.gateway.EmpleadoGateway;
import com.project.base.proyectobase.infrastructure.driven_adapter.empleado.mapper.EmpleadoAdapterTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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

}
