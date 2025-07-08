package main.java.mvc.model;

public class Pessoa {
    private String nome;
    private String apelido;

    public Pessoa(String nome, String apelido){
        this.nome = nome;
        this.apelido = apelido;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }
    public void setApelido(String apelido){
        this.apelido=apelido;
    }
    public String getApelido(){
        return apelido;
    }
    public String toString(){
        return "Nome: " + nome + "\n Apelido: " + apelido;
    }
    
}
