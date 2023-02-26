package com.stefanini.resources;

import com.stefanini.dto.LoginRequestDTO;
import com.stefanini.service.LoginService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @Inject
    private LoginService loginService;

    @POST
    public Response logar(LoginRequestDTO loginRequestDTO){
        return Response.status(Response.Status.OK).entity(loginService.logar(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())).build();
    }


}
