package com.rexus.cdsrpa.pagamentodiaria;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagamentoDiariaRepository implements PanacheRepositoryBase<PagamentoDiaria, PagamentoDiaria.PagamentoDiariaID> {

}