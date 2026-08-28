package br.com.arcanix.core.venda.controllers;

import br.com.arcanix.core.venda.dtos.CreateVendaDTO;
import br.com.arcanix.core.venda.dtos.ResponseVendaDTO;
import br.com.arcanix.core.venda.services.VendaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/v1/vendas")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    public ResponseEntity<ResponseVendaDTO>create(@RequestBody CreateVendaDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vendaService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ResponseVendaDTO>>findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(vendaService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
