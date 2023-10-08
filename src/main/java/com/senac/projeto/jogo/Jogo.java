package com.senac.projeto.jogo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.attoparser.dom.Text;

import java.sql.Blob;
import java.util.List;


@Table(name = "jogos")
@Entity(name = "jogo")
@Getter
@Setter
public class Jogo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private byte[] img;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer classificacao;
    @Column(nullable = false)
    private String comentario;

}
