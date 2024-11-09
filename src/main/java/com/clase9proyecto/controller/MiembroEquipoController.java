package com.clase9proyecto.controller;

import com.clase9proyecto.dto.MiembroEquipo;
import com.clase9proyecto.model.Equipo;
import com.clase9proyecto.model.Miembro;
import com.clase9proyecto.repository.IEquipoRepository;
import com.clase9proyecto.repository.IMiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/miembros-equipos")
public class MiembroEquipoController {

    @Autowired
    private IMiembroRepository miembroRepository;

    @Autowired
    private IEquipoRepository equipoRepository;


    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        MiembroEquipo miembroYEquipo = new MiembroEquipo();
        model.addAttribute("miembroYEquipo", miembroYEquipo);
        return "crearMiembroEquipo";  // ruta del archivo HTML
    }

    @PostMapping("/crear")
    public String crearMiembroYEquipo(@ModelAttribute MiembroEquipo miembroYEquipo, Model model) {
        // Guardar el Miembro
        Miembro miembro = miembroYEquipo.getMiembro();
        miembroRepository.save(miembro);

        // Asignar el id del Miembro al Equipo
        Equipo equipo = miembroYEquipo.getEquipo();
        equipo.setIdMiembro(AggregateReference.to(miembro.getId()));

        // Guardar el Equipo
        equipoRepository.save(equipo);

        model.addAttribute("miembro", miembro);
        model.addAttribute("equipo", equipo);
        return "redirect:/miembros"; // Redirigir o mostrar la lista de miembros
    }
}
