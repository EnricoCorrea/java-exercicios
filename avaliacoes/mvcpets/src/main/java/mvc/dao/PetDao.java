package mvc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Pet;

public class PetDao {
     private static final String ARQUIVO = "pets.txt";

    public void adicionarPet(Pet pet) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true));
            bw.write(pet.getNome() + "|" + pet.getNascimento());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao adicionar pet: " + e.getMessage());
        }
    }

    public List<Pet> listarPets() {
        List<Pet> pets = new ArrayList<>();
        try {
            File file = new File(ARQUIVO);
            if (!file.exists()) {
                return pets;
            }

            BufferedReader br = new BufferedReader(new FileReader(ARQUIVO));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");
                if (dados.length == 2) {
                    Pet pet = new Pet(dados[0], dados[1]);
                    pets.add(pet);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao listar pets: " + e.getMessage());
        }
        return pets;
    }

    public Pet buscarPorNome(String nome) {
        List<Pet> pets = listarPets();
        for (Pet p : pets) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public Pet buscarPorNascimento(String nascimento) {
        List<Pet> pets = listarPets();
        for (Pet p : pets) {
            if (p.getNascimento().equalsIgnoreCase(nascimento)) {
                return p;
            }
        }
        return null;
    }

    public boolean removerPorNome(String nome) {
        List<Pet> pets = listarPets();
        Pet encontrada = null;
        for (Pet p : pets) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            pets.remove(encontrada);
            salvarListaNoArquivo(pets);
            return true;
        }
        return false;
    }

    public boolean removerPorNascimento(String nascimento) {
        List<Pet> pets = listarPets();
        Pet encontrada = null;
        for (Pet p : pets) {
            if (p.getNascimento().equalsIgnoreCase(nascimento)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            pets.remove(encontrada);
            salvarListaNoArquivo(pets);
            return true;
        }
        return false;
    }

    private void salvarListaNoArquivo(List<Pet> pets) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO));
            for (Pet p : pets) {
                bw.write(p.getNome() + "|" + p.getNascimento());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista: " + e.getMessage());
        }
    }
}
