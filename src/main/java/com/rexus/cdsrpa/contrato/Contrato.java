package com.rexus.cdsrpa.contrato;

import com.rexus.cdsrpa.autonomo.Autonomo;
import com.rexus.cdsrpa.cargo.domain.Cargo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public LocalDate vigenciaInicio;

    @Column(nullable = false)
    public LocalDate vigenciaFim;

    public Double valorVT;
    public Double valorVR;
    public Double valorDiaria;

    @Basic(optional = false)
    public boolean encerrado;

    @ManyToOne
    @JoinColumn(name = "idAutonomo", referencedColumnName = "id", nullable = false)
    public Autonomo autonomo;

    @ManyToOne
    @JoinColumn(name = "idCargo", referencedColumnName = "id", nullable = false)
    public Cargo cargo;
}