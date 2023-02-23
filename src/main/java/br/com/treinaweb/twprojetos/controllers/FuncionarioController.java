package br.com.treinaweb.twprojetos.controllers;

import br.com.treinaweb.twprojetos.models.Funcionario;
import br.com.treinaweb.twprojetos.models.UF;
import br.com.treinaweb.twprojetos.repositories.CargoRepository;
import br.com.treinaweb.twprojetos.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("funcionario/home");

        model.addObject("funcionarios", funcionarioRepository.findAll());

        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("funcionario/detalhes");
        modelAndView.addObject("funcionario", funcionarioRepository.getOne(id));
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("funcionario/formulario");

        modelAndView.addObject("funcionario", new Funcionario());
        modelAndView.addObject("cargos", cargoRepository.findAll());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public  ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("funcionario/formulario");
        modelAndView.addObject("funcionario", funcionarioRepository.getOne(id));
        modelAndView.addObject("cargos", cargoRepository.findAll());
        modelAndView.addObject("ufs", UF.values());
        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);

        return "redirect:/funcionarios";
    }

}
