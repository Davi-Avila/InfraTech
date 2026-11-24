package com.api.infratech.infratech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Condominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCondominio;

    private String nome;
    private String CEP;
    private Integer numero;

    @OneToMany(mappedBy = "condominio")
    private List<Chamado> chamados;

    @OneToMany(mappedBy = "condominio")
    private List<Defeito> defeitos;
}
