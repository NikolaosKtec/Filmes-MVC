package ufrn.br.moviedatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ufrn.br.moviedatabase.domain.Filme;
import ufrn.br.moviedatabase.service.FilmeService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FilmeController {
    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login(Model model){

        return "login";
    }


    @GetMapping("/")
    public String getFilmesHome(Model model){

        List<Filme> filmes = service.findAll();
        model.addAttribute("filmes", filmes);

        return "index";
    }

    @GetMapping("/cadastrarFilme")
    public String getFilmesCadastro(Model model){
        Filme f = new Filme();
        model.addAttribute("filme", f);
        return "produto/cadastrar";
    }

    @GetMapping("editar/{id}")
    public String getFilmesHome(Model model, @PathVariable Long id){

        Filme filme = service.findById(id);
        model.addAttribute("filme", filme);
        return "produto/editar";
    }

    @GetMapping("deletar/{id}")
    public String doDeletarFilme(@PathVariable Long id){
        service.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("salvar")
    public String doSalvaFilme(@ModelAttribute @Valid Filme f, Errors errors){

        if(errors.hasErrors()){
            return "produto/editar";
        }

        service.update(f);
        return "redirect:/";
    }
}
