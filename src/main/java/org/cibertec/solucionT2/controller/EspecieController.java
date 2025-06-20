package org.cibertec.solucionT2.controller;

import org.cibertec.solucionT2.entity.EspecieEntity;
import org.cibertec.solucionT2.service.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/especie")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @GetMapping("/mantenimiento")
    public String paginaMantenimiento(Model model) {
        model.addAttribute("especie", new EspecieEntity());
        model.addAttribute("listaEspecies", especieService.getAll());
        return "mantenimientoEspecie";
    }

    @PostMapping("/guardar")
    public String guardarEspecie(@ModelAttribute("especie") EspecieEntity especie) {
        especieService.create(especie);
        return "redirect:/especie/mantenimiento";
    }
}
