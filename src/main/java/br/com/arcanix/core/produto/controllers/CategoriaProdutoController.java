package br.com.arcanix.core.produto.controllers;

import br.com.arcanix.core.produto.dtos.categoriaProduto.CreateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.ResponseCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.UpdateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.services.CategoriaProdutoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("api/v1/produtos/categorias")
@RequiredArgsConstructor
public class CategoriaProdutoController {

    private final CategoriaProdutoService service;

    @PostMapping
    public ResponseEntity<ResponseCategoriaProdutoDTO> create(@RequestBody CreateCategoriaProdutoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCategoriaProdutoDTO> update(@PathVariable Long id,
                                                              @RequestBody UpdateCategoriaProdutoDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(id, dto));
    }

    @GetMapping()
    public ResponseEntity<List<ResponseCategoriaProdutoDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
