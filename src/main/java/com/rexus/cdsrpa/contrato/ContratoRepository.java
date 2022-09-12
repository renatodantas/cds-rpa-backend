package com.rexus.cdsrpa.contrato;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContratoRepository implements PanacheRepositoryBase<Contrato, Integer> {

}