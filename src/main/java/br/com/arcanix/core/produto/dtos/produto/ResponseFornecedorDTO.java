package br.com.arcanix.core.produto.dtos.produto;

public record ResponseFornecedorDTO(Long id,
                                    String nomeFantasia,
                                    String razaoSocial,
                                    String cnpj) {
}
