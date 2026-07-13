package br.com.arcanix.core.pessoa.controllers;

import br.com.arcanix.core.pessoa.dtos.CreatePessoaDTO;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.mapper.PessoaMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController {

    public final PessoaMapper mapper;

    public PessoaController(PessoaMapper mapper){
        this.mapper = mapper;
    }

    @PostMapping
    public Pessoa create(@RequestBody CreatePessoaDTO dto){
        return mapper.createToEntity(dto);
    }
}
