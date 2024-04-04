package com.sparkweb.sparkweb.controller;

import com.sparkweb.sparkweb.dto.input.ProdutoDTOInput;
import com.sparkweb.sparkweb.services.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static spark.Spark.*;

public class UsuarioController {
    private final UsuarioService usuarioService = new UsuarioService();
    private final ObjectMapper objMapper = new ObjectMapper();
    public void respostasRequisicoes(){
        get("/usuarios/", (request,response) -> {
            response.type("application/json");
            String json = objMapper.writeValueAsString(usuarioService.ListarUsuarios());
            response.status(200);
            return json;
        });
        get("/usuarios/:id", (request,response) -> {
            response.type("application/json");
            String idParam = request.params("id");
            Long id = Long.valueOf(idParam);
            String json = objMapper.writeValueAsString(usuarioService.BuscarUsuario(id));
            response.status(200);
            return json;
        });
        delete("/usuarios/:id", (request,response) -> {
            response.type("application/json");
            String idParam = request.params("id");
            Long id = Long.valueOf(idParam);
            usuarioService.ExcluirUsuario(id);
            response.status(200);
            return "Produto removido com sucesso.";
        });
        post("/usuarios", (request,response) -> {
            dto.UsuarioDTOInput usuarioDTOInput = objMapper.readValue(request.body(), dto.UsuarioDTOInput.class);
            usuarioService.InserirUsuario(usuarioDTOInput);
            response.type("application/json");
            response.status(201);
            return "Produto inserido com sucesso.";
        });
        put("/usuarios", (request,response) -> {
            dto.UsuarioDTOInput usuarioDTOInput = objMapper.readValue(request.body(), dto.UsuarioDTOInput.class);
            usuarioService.AlterarUsuario(usuarioDTOInput);
            response.type("application/json");
            response.status(201);
            return "Produto alterado com sucesso.";
        });
    }
}
