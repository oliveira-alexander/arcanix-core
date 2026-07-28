package br.com.arcanix.core.produto.services;

import br.com.arcanix.core.produto.dtos.produto.CreateProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.ResponseProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.UpdateProdutoDTO;

import java.util.List;

public interface ProdutoService {

    ResponseProdutoDTO create(CreateProdutoDTO dto);

    ResponseProdutoDTO update(Long id, UpdateProdutoDTO dto);

    List<ResponseProdutoDTO> findAll();

    void delete(Long id);
}
