package com.rexus.cdsrpa.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ItemNaoEncontradoException extends WebApplicationException {

    public ItemNaoEncontradoException(String nomeItem) {
        super(nomeItem + " não encontrado", Response.Status.NOT_FOUND);
    }
}