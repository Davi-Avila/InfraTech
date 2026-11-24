package com.api.infratech.infratech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Defeito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDefeito;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idCondominio")
    private Condominio condominio;

    @OneToOne(mappedBy = "defeito")
    private Chamado chamado;
}
