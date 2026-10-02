package com.suaapi.controller;

import com.suaapi.model.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros;

    public LivroController() {
        livros = new ArrayList<>();
        livros.add(new Livro(1, "Dom Casmurro", "Machado de Assis", 1899));
        livros.add(new Livro(2, "O Cortiço", "Aluísio Azevedo", 1890));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livros);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        livro.setId(livros.size() + 1);
        livros.add(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }
}