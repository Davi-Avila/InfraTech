package com.api.infratech.infratech.service;

import com.api.infratech.infratech.dto.ChamadoRequestDTO;
import com.api.infratech.infratech.dto.ChamadoResponseDTO;
import com.api.infratech.infratech.exception.RecursoNaoEncontradoException;
import com.api.infratech.infratech.model.Chamado;
import com.api.infratech.infratech.model.Condominio;
import com.api.infratech.infratech.model.Defeito;
import com.api.infratech.infratech.repository.Chamadorepository;
import com.api.infratech.infratech.repository.CondominioRepository;
import com.api.infratech.infratech.repository.DefeitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {
    @Autowired
    Chamadorepository repository;
    CondominioRepository condominioRepository;
    DefeitoRepository defeitoRepository;

    public List<ChamadoResponseDTO> listar(){
        List<ChamadoResponseDTO> chamados = repository.findAll().stream()
                .map(this::toDTO)
                .toList();

        return chamados;
    }

    public ChamadoResponseDTO salvar(ChamadoRequestDTO dto){
        Chamado chamado = new Chamado();
        Condominio condominio = condominioRepository.findByNome(dto.nome());

        Defeito defeito = defeitoRepository.findById(dto.idDefeito())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Defeito não encontrado"));

        chamado.setDiaAgendamento(dto.diaAgendamento());
        chamado.setCondominio(condominio);
        chamado.setDefeito(defeito);

        Chamado salvo = repository.save(chamado);
        return toDTO(salvo);
    }

    public ChamadoResponseDTO atualizar(Long idChamado, ChamadoRequestDTO dto){
        Chamado chamado = repository.findById(idChamado)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Chamado não encontrado"));

        Condominio condominio = condominioRepository.findByNome(dto.nome());

        Defeito defeito = defeitoRepository.findById(dto.idDefeito())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Defeito não encontrado"));

        chamado.setDiaAgendamento(dto.diaAgendamento());
        chamado.setCondominio(condominio);
        chamado.setDefeito(defeito);

        Chamado salvo = repository.save(chamado);
        return toDTO(salvo);
    }

    public ChamadoResponseDTO toDTO(Chamado chamado){
        ChamadoResponseDTO dto = new ChamadoResponseDTO(
                chamado.getDiaAgendamento(),
                chamado.getCondominio().getNome(),
                chamado.getCondominio().getCEP(),
                chamado.getCondominio().getNumero(),
                chamado.getDefeito().getDescricao()
        );
        return dto;
    }




}
