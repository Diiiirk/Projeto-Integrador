package com.senac.projeto.jogo;

import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
public class JogoController {

    @Autowired
    ServicoJogo jogoServico;

    @GetMapping("/jogos")
    public String carregaHome(Model model){
        List<Jogo> listaJogos = jogoServico.listarTodos();
        model.addAttribute("listaJogos", listaJogos);
        return "index";
    }

    @PostMapping("/jogos/novo")
    public String novoFilme(@ModelAttribute Jogo jogo,RedirectAttributes ra) throws IOException {

        jogoServico.salvaJogo(jogo);
        ra.addFlashAttribute("message", "Jogo salvo com sucesso!");
        return "redirect:/jogos";
    }


    @GetMapping("/jogos/editar/{id}")
    public String editaJogo(@PathVariable("id") Long id, Model model, RedirectAttributes ra) throws FilmeNotFoundException {
        Jogo j = jogoServico.pegaJogo(id).getBody();
        model.addAttribute("jogo", j);
        ra.addFlashAttribute("message", "Jogo editado com sucesso!");
        return "formularioJogo";
    }

    @GetMapping("/jogos/deletar/{id}")
    public String deletaJogo(@PathVariable("id") Long id, RedirectAttributes ra) throws FilmeNotFoundException {
        jogoServico.deletarJogo(id);
        ra.addFlashAttribute("message", "Jogo com ID: "+id+" foi excluído com sucesso!");
        return "redirect:/jogos";
    }



}
