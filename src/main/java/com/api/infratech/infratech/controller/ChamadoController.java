package com.api.infratech.infratech.controller;

import com.api.infratech.infratech.dto.ChamadoRequestDTO;
import com.api.infratech.infratech.dto.ChamadoResponseDTO;
import com.api.infratech.infratech.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
    @Autowired
    ChamadoService service;

    @GetMapping
    public List<ChamadoResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public ChamadoResponseDTO salvar(@RequestBody @Valid ChamadoRequestDTO dto){
        return service.salvar(dto);
    }

    @PutMapping
    public ChamadoResponseDTO atualizar(@PathVariable Long idChamado, @RequestBody @Valid ChamadoRequestDTO dto){
        return service.atualizar(idChamado, dto);
    }
}
