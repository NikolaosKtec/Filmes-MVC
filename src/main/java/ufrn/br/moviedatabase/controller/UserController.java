package ufrn.br.moviedatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ufrn.br.moviedatabase.domain.Usuario;
import ufrn.br.moviedatabase.service.UsuarioService;

import javax.validation.Valid;

@Controller
public class UserController {

    UsuarioService service;

    public UserController( UsuarioService service){
        this.service = service;
    }

    @GetMapping("/cadastro_usuario")
    public String doCadastrar(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("user",usuario);
        return "cadastroUsu";
    }

    @PostMapping("cadastrar")
    public String doSave(@ModelAttribute Usuario usuario){

        service.save(usuario);

        return "redirect:/";
    }
}
