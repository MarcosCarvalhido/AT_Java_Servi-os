package com.sparkweb.sparkweb.services;

import com.sparkweb.sparkweb.dao.GenericDAO;
import com.sparkweb.sparkweb.dto.input.ProdutoDTOInput;
import com.sparkweb.sparkweb.dto.output.ProdutoDTOOutput;
import com.sparkweb.sparkweb.model.Produto;
import org.modelmapper.ModelMapper;

import java.util.Collection;

public class ProdutoServico {
    private final GenericDAO<Produto> produtoDAO = new GenericDAO<Produto>(Produto.class);
    private final ModelMapper modelMapper = new ModelMapper();

    public void adicionarProduto(ProdutoDTOInput produtoDTOInput){
        Produto produto = modelMapper.map(produtoDTOInput, Produto.class);
        produtoDAO.begin();
        System.out.println(produtoDTOInput.getNome());
        System.out.println(produto.getNome());
        produtoDAO.create(produto);
        produtoDAO.end();
    }
    public void removerProduto(long id){
        produtoDAO.begin();
        produtoDAO.delete(id);
        produtoDAO.end();
    }
    public ProdutoDTOOutput obterProduto (long id ){
        produtoDAO.begin();
        ProdutoDTOOutput produtoDTOOutput = modelMapper.map( produtoDAO.findById(id) ,ProdutoDTOOutput.class);
        produtoDAO.end();
        return produtoDTOOutput;
    }
    public Collection<ProdutoDTOOutput> listarProdutos (){
        produtoDAO.begin();
        Iterable<Produto> listaProdutos = produtoDAO.findAll();
        produtoDAO.end();
        Collection<ProdutoDTOOutput> listaProdDTOOutput = modelMapper.map(listaProdutos, Collection.class);
        return listaProdDTOOutput;
    }
    public void alterarProduto(ProdutoDTOInput produtoDTOInput){
        Produto produto = modelMapper.map(produtoDTOInput, Produto.class);
        produtoDAO.begin();
        produtoDAO.update(produto);
        produtoDAO.end();
    }
}
