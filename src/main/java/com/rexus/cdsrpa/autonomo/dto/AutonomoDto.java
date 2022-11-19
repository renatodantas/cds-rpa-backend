package com.rexus.cdsrpa.autonomo.dto;

import javax.validation.constraints.NotBlank;

public class AutonomoDto {

    @NotBlank(message = "O nome é obrigatório")
    public String nome;

    @NotBlank(message = "O CPF é obrigatório")
    public String cpf;

    public String banco;
    public Integer agencia;
    public Integer conta;
    public String operacao;
    public String pix;

}