package com.senac.projeto.jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoJogo {

    @Autowired
    private JogoRepo repo;

    public List<Jogo> listarTodos(){
        return (List<Jogo>) repo.findAll();
    }

    public void salvaJogo(Jogo jogo){
        repo.save(jogo);
    }

    public ResponseEntity<Jogo> pegaJogo(Long id) throws FilmeNotFoundException {
        Optional<Jogo> f = repo.findById(id);
        if (f.isPresent()){
            return ResponseEntity.ok(f.get());
        }
        return ResponseEntity.notFound().build();
    }

    public void deletarJogo(Long id) throws FilmeNotFoundException {
        repo.deleteById(id);
    }


}
