package com.sparkweb.sparkweb.services;

import com.sparkweb.sparkweb.dto.input.ProdutoDTOInput;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServicoTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void adicionarProduto() {
        ProdutoServico produtoServico = new ProdutoServico();
        ProdutoDTOInput produtoDTOInput = new ProdutoDTOInput();
        produtoDTOInput.setNome("Lanterna");
        produtoServico.adicionarProduto(produtoDTOInput);
        //assertEquals();
    }
}