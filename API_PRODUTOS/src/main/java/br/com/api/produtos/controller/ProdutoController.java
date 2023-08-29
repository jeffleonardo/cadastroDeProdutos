package br.com.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.model.ProdutoModel;
import br.com.api.produtos.services.ProdutoService;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PutMapping("/alterar")
     public ResponseEntity<?> alterar(@RequestBody ProdutoModel produto){
        return produtoService.cadastrarAlterar(produto, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModel produto){
        return produtoService.cadastrarAlterar(produto, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<ProdutoModel> listar(){
        return produtoService.listar();
    }   

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<?> deletar(@PathVariable Long codigo){
        return produtoService.deletarProduto(codigo);
    }
    
}
