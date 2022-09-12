package com.rexus.cdsrpa.pagamento;

import com.rexus.cdsrpa.contrato.Contrato;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic(optional = false)
    public LocalDate data;

    @Basic(optional = false)
    public Double valor;

    @ManyToOne
    @JoinColumn(name = "idContrato",  referencedColumnName = "id", nullable = false)
    public Contrato contrato;
}