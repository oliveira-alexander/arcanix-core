package br.com.arcanix.core.produto.controllers;

import br.com.arcanix.core.produto.dtos.produto.CreateProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.ResponseProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.UpdateProdutoDTO;
import br.com.arcanix.core.produto.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ResponseProdutoDTO> create(@RequestBody CreateProdutoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ResponseProdutoDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProdutoDTO> update(@PathVariable Long id,
    @RequestBody UpdateProdutoDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
