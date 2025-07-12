package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDao {
    private static final String ARQUIVO = "pessoas.txt";

    public void adicionarPessoa(Pessoa pessoa) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true));
            bw.write(pessoa.getNome() + "|" + pessoa.getApelido());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao adicionar pessoa: " + e.getMessage());
        }
    }

    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            File file = new File(ARQUIVO);
            if (!file.exists()) {
                return pessoas;
            }

            BufferedReader br = new BufferedReader(new FileReader(ARQUIVO));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");
                if (dados.length == 2) {
                    Pessoa p = new Pessoa(dados[0], dados[1]);
                    pessoas.add(p);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao listar pessoas: " + e.getMessage());
        }
        return pessoas;
    }

    public Pessoa buscarPorNome(String nome) {
        List<Pessoa> pessoas = listarPessoas();
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public Pessoa buscarPorApelido(String apelido) {
        List<Pessoa> pessoas = listarPessoas();
        for (Pessoa p : pessoas) {
            if (p.getApelido().equalsIgnoreCase(apelido)) {
                return p;
            }
        }
        return null;
    }

    public boolean removerPorNome(String nome) {
        List<Pessoa> pessoas = listarPessoas();
        Pessoa encontrada = null;
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            pessoas.remove(encontrada);
            salvarListaNoArquivo(pessoas);
            return true;
        }
        return false;
    }

    public boolean removerPorApelido(String apelido) {
        List<Pessoa> pessoas = listarPessoas();
        Pessoa encontrada = null;
        for (Pessoa p : pessoas) {
            if (p.getApelido().equalsIgnoreCase(apelido)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            pessoas.remove(encontrada);
            salvarListaNoArquivo(pessoas);
            return true;
        }
        return false;
    }

    private void salvarListaNoArquivo(List<Pessoa> pessoas) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO));
            for (Pessoa p : pessoas) {
                bw.write(p.getNome() + "|" + p.getApelido());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista: " + e.getMessage());
        }
    }
}