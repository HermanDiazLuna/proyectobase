package com.project.base.proyectobase.infrastructure.entry_point.empleado;

import com.project.base.proyectobase.domain.model.empleado.Empleado;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class EmpleadoController {

    @GetMapping("/buscar-todos")
    public ResponseEntity<?> crearEmpleado(){

        return ResponseEntity.ok(List.of(Empleado.builder().id(1).cedula("12345").nombre("Alex Perez").build()));
    }

}
