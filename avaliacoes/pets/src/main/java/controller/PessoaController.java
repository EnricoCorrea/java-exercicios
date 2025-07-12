package controller;

import java.util.List;
import dao.PessoaDao;
import model.Pessoa;

public class PessoaController {
    //Instanciando
    PessoaDao pDao = new PessoaDao();
    
    //criar
    public PessoaController(){}

    public void criarPessoa(String nome, String apelido){
        Pessoa p = new Pessoa(nome,apelido);
        pDao.adicionarPessoa(p);
    }

    //ler
    public Pessoa buscarPessoaNome(String nome){
        return pDao.buscarPorNome(nome);
    }
    
    public Pessoa buscarPessoaApelido(String apelido){
        return pDao.buscarPorApelido(apelido);    
    }
    
    public List<Pessoa> mostrarPessoa(){
        return pDao.listarPessoas();
    }

    //deletar
    public boolean deletarPessoaNome(String nome){
        return pDao.removerPorNome(nome);
    }
    public boolean deletarPessoaApelido(String apelido){
        return pDao.removerPorApelido(apelido);
    }

    
}
