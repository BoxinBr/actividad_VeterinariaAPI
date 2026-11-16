package com.example.veterinariaapi.service;

import com.example.veterinariaapi.model.Dueño;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class dueñoService implements ICRUD<Dueño> {

    private List<Dueño> listaDueños = new ArrayList<>();

    @Override
    public void agregar(Dueño dueno) {
        listaDueños.add(dueno);
    }

    @Override
    public List<Dueño> listar() {
        return listaDueños;
    }

    @Override
    public Optional<Dueño> buscarPorId(Long id) {
        return listaDueños.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean actualizar(Long id, Dueño duenoActualizado) {

        Optional<Dueño> duenoEncontrado = buscarPorId(id);

        if (duenoEncontrado.isPresent()) {
            Dueño dueno = duenoEncontrado.get();
            dueno.setDni(duenoActualizado.getDni());
            dueno.setNombre(duenoActualizado.getNombre());
            dueno.setApellido(duenoActualizado.getApellido());
            dueno.setCelular(duenoActualizado.getCelular());
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(Long id) {
        return listaDueños.removeIf(d -> d.getId().equals(id));
    }
}
