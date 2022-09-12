package com.rexus.cdsrpa.pagamentodiaria;

import com.rexus.cdsrpa.diaria.Diaria;
import com.rexus.cdsrpa.pagamento.Pagamento;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PagamentoDiaria {

    @EmbeddedId
    public PagamentoDiariaID id;

    @ManyToOne
    @MapsId("idPagamento")
    public Pagamento pagamento;

    @ManyToOne
    @MapsId("idDiaria")
    public Diaria diaria;

    @Basic(optional = false)
    public boolean pagouValorVT;

    @Basic(optional = false)
    public boolean pagouValorVR;

    @Basic(optional = false)
    public boolean pagouValorDiaria;

    @Embeddable
    public record PagamentoDiariaID(int idDiaria, int idPagamento) implements Serializable {}
}