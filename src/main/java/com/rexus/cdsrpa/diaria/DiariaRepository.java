package com.rexus.cdsrpa.diaria;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DiariaRepository implements PanacheRepositoryBase<Diaria, Integer> {

}