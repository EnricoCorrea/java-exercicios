package main.java.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Pessoa {
    private String cpf;
    private List<Pet> pets;

    public Tutor(String nome, String apelido) {
        super(nome, apelido);
        this.pets = new ArrayList<>();
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return super.toString() + ", CPF: " + cpf + ", Total de pets: " + pets.size();
    }
}
