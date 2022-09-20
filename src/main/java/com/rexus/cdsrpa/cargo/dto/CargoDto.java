package com.rexus.cdsrpa.cargo.dto;

import javax.validation.constraints.NotBlank;

public class CargoDto {

    @NotBlank(message = "O nome é obrigatório")
    public String nome;
    public String centroCustoCodigo;
    public String centroCustoDescricao;

}