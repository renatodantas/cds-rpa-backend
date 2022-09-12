package com.rexus.cdsrpa.autonomo;

import javax.persistence.*;

@Entity
public class Autonomo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String nome;

    @Column(length = 11)
    public String cpf;
    public String banco;
    public Integer agencia;
    public Integer conta;

    @Column(length = 3)
    public String operacao;
    public String pix;
}