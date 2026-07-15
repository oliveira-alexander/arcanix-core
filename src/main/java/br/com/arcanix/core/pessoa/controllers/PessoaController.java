package br.com.arcanix.core.pessoa.controllers;

import br.com.arcanix.core.pessoa.dtos.CreatePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.ResponsePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.UpdatePessoaDTO;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.mapper.PessoaMapper;
import br.com.arcanix.core.pessoa.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController {

    public final PessoaMapper mapper;
    public final PessoaService service;

    public PessoaController(PessoaMapper mapper,
                            PessoaService service){
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponsePessoaDTO> create(@Valid @RequestBody CreatePessoaDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsePessoaDTO> update(@PathVariable long id,
                                    @RequestBody UpdatePessoaDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ResponsePessoaDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
