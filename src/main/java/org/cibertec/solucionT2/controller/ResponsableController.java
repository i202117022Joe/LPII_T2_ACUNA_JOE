package org.cibertec.solucionT2.controller;

import org.cibertec.solucionT2.entity.ResponsableEntity;
import org.cibertec.solucionT2.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/responsable")
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    @GetMapping("/mantenimiento")
    public String paginaMantenimiento(Model model) {
        model.addAttribute("responsable", new ResponsableEntity());
        model.addAttribute("listaResponsables", responsableService.getAll());
        return "mantenimientoResponsable";
    }

    @PostMapping("/guardar")
    public String guardarResponsable(@ModelAttribute("responsable") ResponsableEntity responsable) {
        responsableService.create(responsable);
        return "redirect:/responsable/mantenimiento";
    }
}
