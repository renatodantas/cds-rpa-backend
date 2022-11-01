package com.rexus.cdsrpa.diaria;

import com.rexus.cdsrpa.contrato.Contrato;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_diaria")
public class Diaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diaria")
    public Integer id;

    @Column(name = "dt_diaria", nullable = false)
    public LocalDate data;

    @Column(name = "vl_vt")
    public Double valorVT;

    @Column(name = "vl_vr")
    public Double valorVR;

    @Column(name = "vl_diaria")
    public Double valorDiaria;

    @Column(name = "tx_observacao")
    public String observacao;

    @ManyToOne
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato", nullable = false)
    public Contrato contrato;

}