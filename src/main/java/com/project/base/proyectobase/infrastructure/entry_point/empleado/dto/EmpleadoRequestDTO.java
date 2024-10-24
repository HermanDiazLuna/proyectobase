package com.project.base.proyectobase.infrastructure.entry_point.empleado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoRequestDTO {

    private Integer id;
    private String cedula;
    private String nombre;
}
