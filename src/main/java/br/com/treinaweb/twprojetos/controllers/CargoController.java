package br.com.treinaweb.twprojetos.controllers;

import br.com.treinaweb.twprojetos.models.Cargo;
import br.com.treinaweb.twprojetos.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    CargoRepository cargoRepository;

    @GetMapping
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("cargo/home");

        model.addObject("cargos", cargoRepository.findAll());

        return model;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("cargo/formulario");

        modelAndView.addObject("cargo", new Cargo());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public  ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cargo/formulario");
        modelAndView.addObject("cargo", cargoRepository.getOne(id));
        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Cargo cargo) {
        cargoRepository.save(cargo);
        return "redirect:/cargos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        cargoRepository.deleteById(id);

        return "redirect:/cargos";
    }

}
