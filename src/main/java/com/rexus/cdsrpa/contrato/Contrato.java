package com.rexus.cdsrpa.contrato;

import com.rexus.cdsrpa.autonomo.entity.Autonomo;
import com.rexus.cdsrpa.cargo.entity.Cargo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    public Integer id;

    @Column(name = "dt_vigencia_inicio", nullable = false)
    public LocalDate vigenciaInicio;

    @Column(name = "dt_vigencia_fim", nullable = false)
    public LocalDate vigenciaFim;

    @Column(name = "vl_vt")
    public Double valorVT;

    @Column(name = "vl_vr")
    public Double valorVR;

    @Column(name = "vl_diaria")
    public Double valorDiaria;

    @Column(name = "is_encerrado", nullable = false)
    public boolean encerrado;

    @ManyToOne
    @JoinColumn(name = "id_autonomo", referencedColumnName = "id_autonomo", nullable = false)
    public Autonomo autonomo;

    @ManyToOne
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo", nullable = false)
    public Cargo cargo;
}