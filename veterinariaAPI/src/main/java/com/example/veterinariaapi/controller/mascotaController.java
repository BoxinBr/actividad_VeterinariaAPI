package com.example.veterinariaapi.controller;

import com.example.veterinariaapi.model.Mascota;
import com.example.veterinariaapi.service.mascotaService;
import com.example.veterinariaapi.dto.mascotaDueñoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")

public class mascotaController {

    @Autowired
    private mascotaService mascotaService;

    // 1. CRUD / ABML de mascotas
    @PostMapping("/crear")
    public String crearMascota(@RequestBody Mascota mascota) {
        mascotaService.agregar(mascota);
        return "Mascota creada correctamente";
    }

    @GetMapping("/traer")
    public List<Mascota> traerMascotas() {
        return mascotaService.listar();
    }

    @PutMapping("/editar/{id}")
    public String editarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        boolean actualizado = mascotaService.actualizar(id, mascota);
        return actualizado ? "Mascota actualizada" : "Mascota no encontrada";
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarMascota(@PathVariable Long id) {
        boolean eliminado = mascotaService.eliminar(id);
        return eliminado ? "Mascota eliminada" : "Mascota no encontrada";
    }

    @GetMapping("/traer-caniches")
    public List<Mascota> traerPerrosCaniche() {
        return mascotaService.listarPerrosCaniche();
    }

    @GetMapping("/traer-dto")
    public List<mascotaDueñoDTO> traerMascotasConDueño() {
        return mascotaService.listarMascotasConDueño();
    }
}
