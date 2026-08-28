package br.com.arcanix.core.formaspagamento.controllers;

import br.com.arcanix.core.formaspagamento.dtos.CreateFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.dtos.ResponseFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.dtos.UpdateFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.services.FormaPagamentoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/v1/formaspagamento")
@RequiredArgsConstructor
public class FormaPagamentoController {

    private final FormaPagamentoService service;

    @PostMapping
    public ResponseEntity<ResponseFormaPagamentoDTO> create(@RequestBody CreateFormaPagamentoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ResponseFormaPagamentoDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormaPagamentoDTO> upddate(@PathVariable Long id,
                                                             @RequestBody UpdateFormaPagamentoDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
