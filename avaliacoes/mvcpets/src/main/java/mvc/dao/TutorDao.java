package main.java.mvc.dao;

import main.java.mvc.model.Tutor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TutorDao {
    private static final String ARQUIVO = "pessoas.txt";

    public void adicionarPessoa(Tutor pessoa) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true));
            bw.write(pessoa.getNome() + "|" + pessoa.getApelido());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao adicionar pessoa: " + e.getMessage());
        }
    }

    public List<Tutor> listarTutors() {
        List<Tutor> pessoas = new ArrayList<>();
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
                    Tutor p = new Tutor(dados[0], dados[1]);
                    pessoas.add(p);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao listar pessoas: " + e.getMessage());
        }
        return pessoas;
    }

    public Tutor buscarPorNome(String nome) {
        List<Tutor> pessoas = listarPessoas();
        for (Tutor p : pessoas) {
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
        List<Tutor> pessoas = listarPessoas();
        Tutor encontrada = null;
        for (Tutor p : pessoas) {
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

    private void salvarListaNoArquivo(List<Tutor> pessoas) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO));
            for (Tutor p : pessoas) {
                bw.write(p.getNome() + "|" + p.getApelido());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista: " + e.getMessage());
        }
    }
}
