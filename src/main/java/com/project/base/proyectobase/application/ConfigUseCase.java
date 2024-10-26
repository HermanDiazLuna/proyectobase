package com.project.base.proyectobase.application;

import com.project.base.proyectobase.domain.model.empleado.gateway.EmpleadoGateway;
import com.project.base.proyectobase.domain.usecase.empleado.EmpleadoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUseCase {

    @Bean
    public EmpleadoUseCase empleadoUseCase(EmpleadoGateway empleadoGateway){
        return new EmpleadoUseCase(empleadoGateway);
    }
}
