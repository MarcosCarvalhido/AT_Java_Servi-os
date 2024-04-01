package com.sparkweb.sparkweb.services;

import com.sparkweb.sparkweb.dao.GenericDAO;
import com.sparkweb.sparkweb.model.Usuario;
import dto.UsuarioDTOInput;
import dto.UsuarioDTOOutput;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;

public class UsuarioService {
    private final GenericDAO<Usuario> UsuarioDAO = new GenericDAO<Usuario>(Usuario.class);
    private final ModelMapper modelMapper = new ModelMapper();

    public Collection<dto.UsuarioDTOOutput> ListarUsuarios(){
        UsuarioDAO.begin();
        Iterable<Usuario> listaUsuarios = UsuarioDAO.findAll();
        UsuarioDAO.end();
        Collection<UsuarioDTOOutput> ListaUsuarioDTOOutput = modelMapper.map(listaUsuarios, Collection.class);
        return ListaUsuarioDTOOutput;
    }
    public void InserirUsuario(UsuarioDTOInput usuarioDTOInput){
        Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
        UsuarioDAO.begin();
        UsuarioDAO.create(usuario);
        UsuarioDAO.end();
    }
    public void AlterarUsuario(UsuarioDTOInput usuarioDTOInput){
        Usuario usuario = modelMapper.map(usuarioDTOInput, Usuario.class);
        UsuarioDAO.begin();
        UsuarioDAO.update(usuario);
        UsuarioDAO.end();
    }
    public UsuarioDTOOutput BuscarUsuario(long id){
        UsuarioDAO.begin();
        UsuarioDTOOutput usuarioDTOOutput = modelMapper.map(UsuarioDAO.findById(id),UsuarioDTOOutput.class);
        UsuarioDAO.end();
        return usuarioDTOOutput;
    }
    public void ExcluirUsuario(long id){
        UsuarioDAO.begin();
        UsuarioDAO.delete(id);
        UsuarioDAO.end();
    }
}
