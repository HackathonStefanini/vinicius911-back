package com.stefanini.resources;

import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;
import com.stefanini.service.JogadorService;
import com.stefanini.service.StefamonService;
import org.jboss.resteasy.annotations.Query;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/stefamon")
public class StefamonResource {

    @Inject
    private StefamonService service;

    @Inject
    private JogadorService jogadorService;

    @GET
    public Response listarTodos() {
        return Response.status(Response.Status.OK).entity(service.listarTodos()).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(service.pegarPorId(id)).build();
    }

    @PUT
    @Path("/comprar-stefamon")
    public Response comprarStefamon(@QueryParam("idJogador") Long idJogador, @QueryParam("idStefamon") Long idStefamon) {
        return Response.status(Response.Status.OK).entity(service.comprarStefamon(jogadorService.pegarPorId(idJogador), service.pegarPorId(idStefamon))).build();
    }

}
