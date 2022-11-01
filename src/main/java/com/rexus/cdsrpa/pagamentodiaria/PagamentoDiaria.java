package com.rexus.cdsrpa.pagamentodiaria;

import com.rexus.cdsrpa.diaria.Diaria;
import com.rexus.cdsrpa.pagamento.Pagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento_diaria")
public class PagamentoDiaria {

    @EmbeddedId
    public PagamentoDiariaID id;

    @ManyToOne
    @MapsId("id_pagamento")
    public Pagamento pagamento;

    @ManyToOne
    @MapsId("id_diaria")
    public Diaria diaria;

    @Column(name = "is_pagou_vt", nullable = false)
    public boolean pagouValorVT;

    @Column(name = "is_pagou_vr", nullable = false)
    public boolean pagouValorVR;

    @Column(name = "is_pagou_diaria", nullable = false)
    public boolean pagouValorDiaria;

    @Embeddable
    public class PagamentoDiariaID implements Serializable {

        @Column(name = "id_diaria")
        public int idDiaria;

        @Column(name = "id_pagamento")
        public int idPagamento;

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            PagamentoDiariaID that = (PagamentoDiariaID) o;
            return idDiaria == that.idDiaria && idPagamento == that.idPagamento;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idDiaria, idPagamento);
        }
    }
}