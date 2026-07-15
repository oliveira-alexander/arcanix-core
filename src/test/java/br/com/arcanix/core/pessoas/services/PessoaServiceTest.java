package br.com.arcanix.core.pessoas.services;

import br.com.arcanix.core.pessoa.dtos.*;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.entities.Telefone;
import br.com.arcanix.core.pessoa.entities.enums.TipoParceiro;
import br.com.arcanix.core.pessoa.entities.enums.TipoPessoa;
import br.com.arcanix.core.pessoa.entities.enums.TipoTelefone;
import br.com.arcanix.core.pessoa.mapper.PessoaMapper;
import br.com.arcanix.core.pessoa.repository.PessoaRepository;
import br.com.arcanix.core.pessoa.services.impl.PessoaServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaMapper mapper;

    @Mock
    private PessoaRepository repository;

    @InjectMocks
    private PessoaServiceImpl service;

    @Test
    void shouldCreatePessoa(){
        // Arrange
        CreatePessoaDTO createDTO = new CreatePessoaDTO("Razão Social",
                "Nome Fantasia",
                "123.456.789-10",
                null,
                TipoPessoa.PESSOA_FISICA,
                null,
                List.of(TipoParceiro.CLIENTE));

        Pessoa pessoa = Pessoa.builder().id(1L).razaoSocial("Razão Social")
                .nomeFantasia("Nome Fantasia")
                .cpf("123.456.789-10")
                .cnpj(null)
                .tipoPessoa(TipoPessoa.PESSOA_FISICA)
                .telefones(null)
                .tipoParceiro(List.of(TipoParceiro.CLIENTE))
                .build();

        ResponsePessoaDTO responseDTO = new ResponsePessoaDTO(1L, "Razão Social",
                "Nome Fantasia",
                "123.456.789-10",
                null,
                TipoPessoa.PESSOA_FISICA,
                null,
                List.of(TipoParceiro.CLIENTE));

        when(mapper.createToEntity(createDTO))
                .thenReturn(pessoa);

        when(repository.save(pessoa))
                .thenReturn(pessoa);

        when(mapper.entityToResponse(pessoa))
                .thenReturn(responseDTO);

        // Act

        ResponsePessoaDTO responseService = service.create(createDTO);

        // Assert

        Assertions.assertThat(responseService.id() == responseDTO.id());
        Assertions.assertThat(responseService.cpf().equals(responseDTO.cpf()));
        Assertions.assertThat(responseService.tipoPessoa() == responseDTO.tipoPessoa());
        Assertions.assertThat(responseService.razaoSocial().equals(responseDTO.razaoSocial()));
        Assertions.assertThat(responseService.nomeFantasia().equals(responseDTO.nomeFantasia()));
    }

    @Test
    void shouldDeletePessoa(){
        // Arrange & Act
        Long id = 1L;

        Pessoa pessoa = Pessoa.builder().id(id).build();

        when(repository.findById(id))
                .thenReturn(Optional.of(pessoa));

        service.delete(id);

        // Assert
        verify(repository).delete(pessoa);
    }

    @Test
    void shouldFindAll(){
        // Arrange & Act
        service.findAll();

        // Assert
        verify(repository).findAll();
    }

    @Test
    void shouldUpdatePessoa(){
        // Arrange

        Long id = 1L;

        UpdatePessoaDTO updateDTO = new UpdatePessoaDTO("Razão Social",
                "Nome Fantasia",
                "123.456.789-10",
                null,
                TipoPessoa.PESSOA_FISICA,
                null,
                List.of(TipoParceiro.CLIENTE));

        Pessoa pessoa = Pessoa.builder().id(1L).razaoSocial("Razão Social")
                .nomeFantasia("Nome Fantasia")
                .cpf("123.456.789-10")
                .cnpj(null)
                .tipoPessoa(TipoPessoa.PESSOA_FISICA)
                .telefones(null)
                .tipoParceiro(List.of(TipoParceiro.CLIENTE))
                .build();

        ResponsePessoaDTO responseDTO = new ResponsePessoaDTO(1L, "Razão Social",
                "Nome Fantasia",
                "123.456.789-10",
                null,
                TipoPessoa.PESSOA_FISICA,
                null,
                List.of(TipoParceiro.CLIENTE));

        when(repository.findById(1L))
                .thenReturn(Optional.of(pessoa));

        when(repository.save(pessoa))
                .thenReturn(pessoa);

        when(mapper.entityToResponse(pessoa))
                .thenReturn(responseDTO);

        // Act

        ResponsePessoaDTO responseService = service.update(id, updateDTO);

        // Assert
        Assertions.assertThat(responseService.id() == responseDTO.id());
        Assertions.assertThat(responseService.cpf().equals(responseDTO.cpf()));
        Assertions.assertThat(responseService.tipoPessoa() == responseDTO.tipoPessoa());
        Assertions.assertThat(responseService.razaoSocial().equals(responseDTO.razaoSocial()));
        Assertions.assertThat(responseService.nomeFantasia().equals(responseDTO.nomeFantasia()));
    }

    @Test
    void shouldAtualizarTelefones(){
        // Arrange

            Long id = 1L;

            UUID uuidPrimeiroTelefone = UUID.randomUUID();
            UUID uuidSegundoTelefone = UUID.randomUUID();

            List<UpdateTelefoneDTO> updateTelefones = new ArrayList<>();
            updateTelefones.add(new UpdateTelefoneDTO(uuidPrimeiroTelefone,
                    TipoTelefone.CELULAR,
                    "11912345678"));

            updateTelefones.add(new UpdateTelefoneDTO(uuidSegundoTelefone,
                    TipoTelefone.WHATSAPP,
                    "11998765432"));

            List<ResponseTelefoneDTO> responseTelefones = new ArrayList<>();
            responseTelefones.add(new ResponseTelefoneDTO(uuidPrimeiroTelefone,
                    TipoTelefone.CELULAR,
                    "11912345678"));

            responseTelefones.add(new ResponseTelefoneDTO(uuidSegundoTelefone,
                    TipoTelefone.WHATSAPP,
                    "11998765432"));

            UpdatePessoaDTO updateDTO = new UpdatePessoaDTO("Razão Social",
                    "Nome Fantasia",
                    "123.456.789-10",
                    null,
                    TipoPessoa.PESSOA_FISICA,
                    updateTelefones,
                    List.of(TipoParceiro.CLIENTE));

            List<Telefone> telefones = new ArrayList<>();

        Pessoa pessoa = Pessoa.builder().id(1L).razaoSocial("Razão Social")
                .nomeFantasia("Nome Fantasia")
                .cpf("123.456.789-10")
                .cnpj(null)
                .tipoPessoa(TipoPessoa.PESSOA_FISICA)
                .telefones(telefones)
                .build();

            ResponsePessoaDTO responseDTO = new ResponsePessoaDTO(1L, "Razão Social",
                    "Nome Fantasia", "123.456.789-10", null,
                    TipoPessoa.PESSOA_FISICA, null,
                    List.of(TipoParceiro.CLIENTE));

        when(repository.findById(1L))
                .thenReturn(Optional.of(pessoa));

        when(repository.save(pessoa))
                .thenReturn(pessoa);

        when(mapper.entityToResponse(pessoa))
                .thenReturn(responseDTO);

        // Act
            ResponsePessoaDTO responseService = service.update(id, updateDTO);

        // Assert
            Assertions.assertThat(responseService.telefones() == responseTelefones);


    }



}
