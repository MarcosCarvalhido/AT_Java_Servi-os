package com.sparkweb.sparkweb.services;

import dto.UsuarioDTOInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    public void InserçãoDeUsuario(){
        UsuarioService usuarioService = new UsuarioService();
        dto.UsuarioDTOInput usuarioDTOInput = new UsuarioDTOInput(1,"Marcos","12345");
        usuarioService.InserirUsuario(usuarioDTOInput);
        System.out.println(usuarioService.ListarUsuarios().size());
        assertEquals(usuarioService.ListarUsuarios().size(),1);
    }
}
