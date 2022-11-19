package com.rexus.cdsrpa.autonomo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_autonomo")
public class Autonomo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autonomo")
    public Integer id;

    @Column(name = "nm_autonomo", nullable = false)
    public String nome;

    @Column(name = "nr_cpf", unique = true, nullable = false)
    public String cpf;

    @Column(name = "nm_banco")
    public String banco;

    @Column(name = "nr_agencia")
    public Integer agencia;

    @Column(name = "nr_conta")
    public Integer conta;

    @Column(name = "nr_operacao")
    public String operacao;

    @Column(name = "cd_pix")
    public String pix;
}