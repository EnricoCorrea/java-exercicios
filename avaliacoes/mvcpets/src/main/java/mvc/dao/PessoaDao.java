package main.java.mvc.dao;

import main.java.mvc.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
public class PessoaDao {
    private List<Pessoa> pessoas = new ArrayList<>();

    //criar 
    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    
    //ler
    public List<Pessoa> listarPessoas(){
        return pessoas;
    }

    public Pessoa buscarPorNome(String nome){
        for(Pessoa pessoa : pessoas){
            if(pessoa.getNome().equals(nome)){
                return pessoa;
            }
        }
        return null;
    }

    public Pessoa buscarPorApelido(String apelido){
        for(Pessoa pessoa : pessoas){
            if(pessoa.getApelido().equals(apelido)){
                return pessoa;
            }
        }
        return null;
    }

    //deletar
    public boolean removerPorNome(String nome){
        Pessoa pessoa = buscarPorNome(nome); 
        if(pessoa!=null){
            pessoas.remove(pessoa);
            return true;
        }
        return false;
    }

    public boolean removerPorApelido(String apelido){
        Pessoa pessoa = buscarPorApelido(apelido);
        
        if(pessoa!=null){
            pessoas.remove(pessoa);
            return true;
        }
        return false;
    }

}
