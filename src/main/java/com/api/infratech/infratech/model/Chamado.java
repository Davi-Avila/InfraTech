package com.api.infratech.infratech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChamado;

    private LocalDate diaAgendamento;

    @ManyToOne
    @JoinColumn(name = "idCondominio")
    private Condominio condominio;

    @OneToOne
    @JoinColumn(name = "idDefeito")
    private Defeito defeito;
}
