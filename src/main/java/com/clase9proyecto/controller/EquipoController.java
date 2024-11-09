package com.clase9proyecto.controller;

import com.clase9proyecto.model.Equipo;
import com.clase9proyecto.repository.IEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private IEquipoRepository equipoRepository;


    @GetMapping("")
    public String getEquipo(Model model) {
        model.addAttribute("equipos", equipoRepository.findAll());
        return "equipos";
    }

    @GetMapping("/encuentroByEquipo/{id}")
    public String getEncuentroByEquipo(@PathVariable("id") Long id, Model model) {
        Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid equipo Id:" + id));
        model.addAttribute("equipo", equipo);
        model.addAttribute("encuentros", equipoRepository.findEncuentrosByEquipoId(id));
        return "encuentrosByEquipo";
    }

}
