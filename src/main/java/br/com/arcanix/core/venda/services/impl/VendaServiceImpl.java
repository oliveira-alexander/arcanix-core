package br.com.arcanix.core.venda.services.impl;

import br.com.arcanix.core.formaspagamento.entities.FormaPagamento;
import br.com.arcanix.core.formaspagamento.repositories.FormaPagamentoRepository;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.repository.PessoaRepository;
import br.com.arcanix.core.produto.repository.ProdutoRepository;
import br.com.arcanix.core.venda.dtos.*;
import br.com.arcanix.core.venda.entities.Venda;
import br.com.arcanix.core.venda.entities.VendaItem;
import br.com.arcanix.core.venda.mapper.VendaMapper;
import br.com.arcanix.core.venda.repositories.VendaItemRepository;
import br.com.arcanix.core.venda.repositories.VendaRepository;
import br.com.arcanix.core.venda.services.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VendaServiceImpl implements VendaService {

    private final VendaRepository vendaRepository;
    private final VendaItemRepository vendaItemRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;
    private final PessoaRepository pessoaRepository;
    private final VendaMapper vendaMapper;
    private final ProdutoRepository produtoRepository;


    @Override
    public ResponseVendaDTO create(CreateVendaDTO dto) {

        FormaPagamento formaPagamento = formaPagamentoRepository.findById(dto.formaPagamentoId())
                .orElseThrow(() -> new RuntimeException("A Forma de Pagamento não foi encontrada!"));

        Pessoa cliente = pessoaRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("O cliente não foi encontrado!"));

        LocalDate dataVenda = LocalDate.now();

        LocalTime horaVenda = LocalTime.now();

        Venda venda = Venda.builder()
                .formaPagamento(formaPagamento)
                .cliente(cliente)
                .dataVenda(dataVenda)
                .horaVenda(horaVenda)
                .build();

        vendaRepository.save(venda);

        List<VendaItem> itens = saveVendaItems(dto.itens(), venda);

        venda.setItens(itens);

        vendaRepository.save(venda);

        return vendaMapper.toResponse(venda);
    }

    @Override
    public List<ResponseVendaDTO> findAll() {
        return vendaRepository.findAll().stream()
                .map(vendaMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var venda = vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada!"));

        vendaRepository.delete(venda);
    }

    @Override
    public ResponseVendaDTO update(Long id, UpdateVendaDTO dto) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada!"));

        if (dto.formaPagamentoId() != null) {
            FormaPagamento formaPagamentoUpdated = formaPagamentoRepository.findById(dto.formaPagamentoId())
                    .orElseThrow(() -> new RuntimeException("Forma de Pagamento não encontrada"));
        }

        if (dto.clienteId() != null) {
            Pessoa clienteUpdated = pessoaRepository.findById(dto.clienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        }

        return null;
    }

    private List<VendaItem> saveVendaItems(List<CreateVendaItemDTO> itemsDto,
                                Venda venda){

        List<VendaItem> itens = new ArrayList<>();

        itemsDto.forEach(itemDto -> {
            VendaItem item = VendaItem.builder()
                    .venda(venda)
                    .custoUnitario(itemDto.custoUnitario())
                    .precoUnitario(itemDto.precoUnitario())
                    .quantidade(itemDto.quantidade())
                    .produto(produtoRepository.findById(itemDto.produtoId()).get())
                    .build();

            vendaItemRepository.save(item);

            itens.add(item);
        });

        return itens;
    }

    private  List<VendaItem> updateVendaItems(List<UpdateVendaItemDTO> updatingItems,
                                              List<VendaItem> items,
                                              Venda venda){

        return Collections.emptyList();

    }
}
