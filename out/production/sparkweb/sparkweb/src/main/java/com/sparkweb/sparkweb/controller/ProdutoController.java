package com.sparkweb.sparkweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparkweb.sparkweb.dto.input.ProdutoDTOInput;
import com.sparkweb.sparkweb.services.ProdutoServico;
import static spark.Spark.post;
import static spark.Spark.get;
import static spark.Spark.delete;
import static spark.Spark.put;


public class ProdutoController {
private final ProdutoServico produtoServico = new ProdutoServico();
private final ObjectMapper objMapper = new ObjectMapper();

    public ProdutoController() {

    get("/produto/:id", (request,response) -> {
        response.type("application/json");
        String idParam = request.params("id");
        Long id = Long.valueOf(idParam);
        String json = objMapper.writeValueAsString(produtoServico.obterProduto(id));
        response.status(200);
        return json;
    });
        get("/produtos", (request,response) -> {
            response.type("application/json");
            String json = objMapper.writeValueAsString(produtoServico.listarProdutos());
            response.status(200);
            return json;
        });
        post("/produto", (request,response) -> {
            ProdutoDTOInput produtoDTOInput = objMapper.readValue(request.body(), ProdutoDTOInput.class);
            produtoServico.adicionarProduto(produtoDTOInput);
            response.type("application/json");
            response.status(201);
            return "Produto inserido com sucesso.";
        });
        put("/produto", (request,response) -> {
            ProdutoDTOInput produtoDTOInput = objMapper.readValue(request.body(), ProdutoDTOInput.class);
            produtoServico.alterarProduto(produtoDTOInput);
            response.type("application/json");
            response.status(201);
            return "Produto alterado com sucesso.";
        });
        delete("/produto/:id", (request,response) -> {
            response.type("application/json");
            String idParam = request.params("id");
            Long id = Long.valueOf(idParam);
            produtoServico.removerProduto(id);
            response.status(200);
            return "Produto removido com sucesso.";
        });
    }

}
