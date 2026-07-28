package br.com.arcanix.core.produto.dtos.categoriaProduto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCategoriaProdutoDTO(
                                        @NotBlank(message = "Preencha a descrição da categoria de produtos!")
                                        @NotNull(message = "A descrição da categoria de produtos não pode ser nula!")
                                        String descricao)
{ }
