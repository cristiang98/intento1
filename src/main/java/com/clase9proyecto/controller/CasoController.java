package com.clase9proyecto.controller;

import com.clase9proyecto.model.Caso;
import com.clase9proyecto.model.Miembro;
import com.clase9proyecto.repository.ICasoRepository;
import com.clase9proyecto.repository.IMiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/casos")
public class CasoController {

    @Autowired
    private ICasoRepository casoRepository;

    @Autowired
    private IMiembroRepository miembroRepository;

    // controller para ver casos de un miembro pero no lo estoy usando
    // la estoy usando directamente en miembroController
    @GetMapping("/miembros")
    public String getMiembro(Model model) {
        model.addAttribute("miembros", miembroRepository.findAll());
        return "mostrarMiembroYCasos";
    }
    @GetMapping("/byId/{id}")
    public String getCasos(@PathVariable("id") Long id, Model model) {

        Miembro miembro = miembroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        Set<Caso> casos = casoRepository.findCasosByMiembroId(miembro.getId());

        model.addAttribute("miembro", miembro);
        model.addAttribute("casos", casos);
        return "casosById";
    }


}
