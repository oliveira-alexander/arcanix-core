package br.com.arcanix.core.produto.services;

import br.com.arcanix.core.produto.dtos.categoriaProduto.CreateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.ResponseCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.UpdateCategoriaProdutoDTO;

import java.util.List;

public interface CategoriaProdutoService {

    ResponseCategoriaProdutoDTO create(CreateCategoriaProdutoDTO dto);

    List<ResponseCategoriaProdutoDTO> findAll();

    ResponseCategoriaProdutoDTO update(Long id, UpdateCategoriaProdutoDTO dto);

    void delete(Long id);
}
