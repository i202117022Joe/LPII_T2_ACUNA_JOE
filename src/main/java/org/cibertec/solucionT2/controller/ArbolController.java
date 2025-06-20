package org.cibertec.solucionT2.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.cibertec.solucionT2.entity.ArbolEntity;
import org.cibertec.solucionT2.service.ArbolService;
import org.cibertec.solucionT2.service.EspecieService;
import org.cibertec.solucionT2.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @Autowired
    private ResponsableService responsableService;

    @Autowired
    private EspecieService especieService;

    // Extraído desde application.properties
    @Value("${app.developer}")
    private String appDeveloper;

    // 📌 GET: Mostrar vista principal
    @GetMapping("/mantenimiento")
    public String paginaMantenimiento(Model model) {
        model.addAttribute("arbol", new ArbolEntity()); // objeto vacío para el form
        model.addAttribute("listaResponsables", responsableService.getAll());
        model.addAttribute("listaEspecies", especieService.getAll());
        model.addAttribute("listaArboles", arbolService.getAll());
        return "mantenimientoArbol";
    }

    // 📌 POST: Guardar o actualizar árbol
    @PostMapping("/guardar")
    public String guardarArbol(@ModelAttribute("arbol") ArbolEntity arbol) {
        if (arbol.getResponsable() != null && arbol.getEspecie() != null) {
            String rawData = appDeveloper +
                    arbol.getResponsable().getNombreCompleto() +
                    arbol.getEspecie().getNombreComun() +
                    arbol.getFechaPlantacion().toString() +
                    arbol.getCoordenadas();

            String hash = DigestUtils.sha256Hex(rawData);
            arbol.setHashRegistro(hash);
        }

        arbolService.create(arbol); // si tiene ID hace update, si no insert
        return "redirect:/arbol/mantenimiento";
    }

    // 📌 GET: Editar árbol (carga datos en el formulario)
    @GetMapping("/editar/{id}")
    public String editarArbol(@PathVariable("id") Integer id, Model model) {
        ArbolEntity arbol = arbolService.getById(id);

        model.addAttribute("arbol", arbol);
        model.addAttribute("listaResponsables", responsableService.getAll());
        model.addAttribute("listaEspecies", especieService.getAll());
        model.addAttribute("listaArboles", arbolService.getAll());

        return "mantenimientoArbol";
    }

    // 📌 GET: Eliminar árbol por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarArbol(@PathVariable("id") Integer id) {
        arbolService.remove(id);
        return "redirect:/arbol/mantenimiento";
    }
}
