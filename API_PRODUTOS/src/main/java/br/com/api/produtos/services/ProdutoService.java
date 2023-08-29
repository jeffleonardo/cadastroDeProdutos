package br.com.api.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.model.ProdutoModel;
import br.com.api.produtos.model.RespostaModel;
import br.com.api.produtos.repositories.ProdutoRepositorie;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorie produtoRepositorie;
    
    @Autowired
    private RespostaModel resposta;

    //metodo para listar produtos
    public Iterable<ProdutoModel> listar(){
        return produtoRepositorie.findAll();
    }

    //metodo para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(ProdutoModel produto, String acao){

        if(produto.getNome().equals("")){
            resposta.setMensagem("O nome é obrigatório!");
            return new ResponseEntity<RespostaModel>(resposta, HttpStatus.BAD_REQUEST);            
        }else if(produto.getMarca().equals("")){
            resposta.setMensagem("O nome da marca é obrigatório!");
            return new ResponseEntity<RespostaModel>(resposta, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModel>(produtoRepositorie.save(produto), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProdutoModel>(produtoRepositorie.save(produto), HttpStatus.OK);
            }
        }
    }

    //metodo para remover produtos
    public ResponseEntity<RespostaModel> deletarProduto(Long codigo){
        
        if(codigo == null || codigo.equals("")){
            resposta.setMensagem("Produto nao encontrado!");
            return new ResponseEntity<RespostaModel>(resposta, HttpStatus.BAD_REQUEST);            
        }else{
            produtoRepositorie.deleteById(codigo);
            resposta.setMensagem("Produto excluido com sucesso!");
            return new ResponseEntity<RespostaModel>(resposta, HttpStatus.OK);
     }
    }    
}
