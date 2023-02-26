package com.stefanini.resources;

import com.stefanini.dto.CriarJogadorDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.service.JogadorService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/jogador")
public class JogadorResource {

    @Inject
    private JogadorService jogadorService;

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id){
        return Response.status(Response.Status.OK).entity(jogadorService.pegarPorId(id)).build();
    }

    @GET
    public Response listarTodos(){
        return Response.status(Response.Status.OK).entity(jogadorService.listarTodos()).build();
    }

    @POST
    public Response salvar(@Valid CriarJogadorDTO jogador) {
        jogadorService.salvar(jogador);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(@Valid CriarJogadorDTO jogador, @PathParam("id") Long id) {
        jogadorService.alterar(jogador, id);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        jogadorService.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
