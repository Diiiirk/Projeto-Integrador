package com.senac.projeto;
import org.springframework.beans.factory.annotation.Autowired;
import com.senac.projeto.jogo.ServicoJogo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class FuncaoController {
    
    @Autowired
    ServicoJogo filmeServico;
    @RequestMapping("/preferencias")
    public String preferencias(){
    return "index";
    }









}