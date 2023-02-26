package com.stefanini.resources;


import com.stefanini.entity.Jogador;
import com.stefanini.service.BatalhaService;
import com.stefanini.service.JogadorService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/batalha")
public class BatalhaResource {

    @Inject
    private BatalhaService batalhaService;

    @Inject
    private JogadorService jogadorService;

    @GET
    public Response batalhar(@QueryParam("jogador1") Long idJogador1, @QueryParam("jogador2") Long idJogador2) {
        return Response.ok().entity(batalhaService.batalhar(jogadorService.pegarPorId(idJogador1), jogadorService.pegarPorId(idJogador2))).build();
    }

    @GET
    @Path("/bot")
    public Response batalharContraBot(@QueryParam("jogador1") Long idJogador1) {
        return Response.ok().entity(batalhaService.batalhar(jogadorService.pegarPorId(idJogador1), jogadorService.gerarBot())).build();
    }
}
