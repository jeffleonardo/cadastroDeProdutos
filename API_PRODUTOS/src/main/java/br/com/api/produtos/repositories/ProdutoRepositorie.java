package br.com.api.produtos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.model.ProdutoModel;

@Repository
public interface ProdutoRepositorie extends CrudRepository<ProdutoModel, Long>{
    
}
