package com.rexus.cdsrpa.cargo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(nullable = false, unique = true)
    public String nome;
    public String codigoCentroCusto;
    public String descricaoCentroCusto;

    public Cargo() {}

    public Cargo(String nome, String codigoCentroCusto, String descricaoCentroCusto) {
        this.nome = nome;
        this.codigoCentroCusto = codigoCentroCusto;
        this.descricaoCentroCusto = descricaoCentroCusto;
    }

    public Cargo(Integer id, String nome, String codigoCentroCusto, String descricaoCentroCusto) {
        this(nome, codigoCentroCusto, descricaoCentroCusto);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cargo cargo = (Cargo) o;
        return id.equals(cargo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nome;
    }
}