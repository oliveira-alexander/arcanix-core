package br.com.arcanix.core.usuario.controllers;

import br.com.arcanix.core.usuario.dtos.CreateUsuarioDTO;
import br.com.arcanix.core.usuario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateUsuarioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }
}
