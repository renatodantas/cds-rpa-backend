package com.rexus.cdsrpa.pagamento;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagamentoRepository implements PanacheRepositoryBase<Pagamento, Integer> {

}