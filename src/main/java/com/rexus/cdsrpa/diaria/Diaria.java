package com.rexus.cdsrpa.diaria;

import com.rexus.cdsrpa.contrato.Contrato;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Diaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic(optional = false)
    public LocalDate data;
    public Double valorVT;
    public Double valorVR;
    public Double valorDiaria;
    public String observacao;

    @ManyToOne
    @JoinColumn(name = "idContrato", referencedColumnName = "id", nullable = false)
    public Contrato contrato;

}