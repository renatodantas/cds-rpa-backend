package com.rexus.cdsrpa.pagamento;

import com.rexus.cdsrpa.contrato.Contrato;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    public Integer id;

    @Column(name = "dt_pagamento", nullable = false)
    public LocalDate data;

    @Column(name = "vl_pagamento", nullable = false)
    public Double valor;

    @ManyToOne
    @JoinColumn(name = "id_contrato",  referencedColumnName = "id_contrato", nullable = false)
    public Contrato contrato;
}