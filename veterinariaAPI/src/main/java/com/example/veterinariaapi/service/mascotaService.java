package com.example.veterinariaapi.service;

import org.springframework.stereotype.Service;
import com.example.veterinariaapi.model.Mascota;
import com.example.veterinariaapi.dto.mascotaDueñoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class mascotaService implements ICRUD<Mascota> {

    private List<Mascota> listaMascotas = new ArrayList<>();

    @Override
    public void agregar(Mascota mascota) {
        listaMascotas.add(mascota);
    }

    @Override
    public List<Mascota> listar() {
        return listaMascotas;
    }

    @Override
    public Optional<Mascota> buscarPorId(Long id) {
        return listaMascotas.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean actualizar(Long id, Mascota mascotaActualizada) {

        Optional<Mascota> mascotaEncontrada = buscarPorId(id);

        if (mascotaEncontrada.isPresent()) {
            Mascota mascota = mascotaEncontrada.get();
            mascota.setNombre(mascotaActualizada.getNombre());
            mascota.setEspecie(mascotaActualizada.getEspecie());
            mascota.setRaza(mascotaActualizada.getRaza());
            mascota.setColor(mascotaActualizada.getColor());
            mascota.setDueño(mascotaActualizada.getDueño());
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(Long id) {
        return listaMascotas.removeIf(m -> m.getId().equals(id));
    }

    public List<Mascota> listarPerrosCaniche() {
        return listaMascotas.stream()
                .filter(m -> m.getEspecie().equalsIgnoreCase("perro")
                        && m.getRaza().equalsIgnoreCase("caniche"))
                .toList();
    }

    public List<mascotaDueñoDTO> listarMascotasConDueño() {
        return listaMascotas.stream()
                .map(m -> new mascotaDueñoDTO(
                        m.getNombre(),
                        m.getEspecie(),
                        m.getRaza(),
                        m.getDueño() != null ? m.getDueño().getNombre() : null,
                        m.getDueño() != null ? m.getDueño().getApellido() : null
                ))
                .toList();
    }
}
