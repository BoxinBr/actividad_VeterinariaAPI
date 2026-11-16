package com.example.veterinariaapi.controller;

import com.example.veterinariaapi.model.Dueño;
import com.example.veterinariaapi.service.dueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/duenos")
public class dueñoController {

    @Autowired
    private dueñoService dueñoService;

    @PostMapping("/crear")
    public String crearDueño(@RequestBody Dueño dueño) {
        dueñoService.agregar(dueño);
        return "Dueño creado correctamente";
    }

    @GetMapping("/traer")
    public List<Dueño> traerDueños() {
        return dueñoService.listar();
    }

    @PutMapping("/editar/{id}")
    public String editarDueño(@PathVariable Long id, @RequestBody Dueño dueño) {
        boolean actualizado = dueñoService.actualizar(id, dueño);
        return actualizado ? "Dueño actualizado" : "Dueño no encontrado";
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarDuenñ(@PathVariable Long id) {
        boolean eliminado = dueñoService.eliminar(id);
        return eliminado ? "Dueño eliminado" : "Dueño no encontrado";
    }
}
