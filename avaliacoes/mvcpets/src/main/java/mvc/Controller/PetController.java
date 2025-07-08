package mvc.controller;

import java.util.List;

import mvc.dao.PetDao;
import mvc.model.Pet;

public class PetController {
     //Instanciando
    PetDao petDao = new PetDao();
    
    //criar
    public PetController(){}

    public void criarPet(String nome, String nascimento){
        Pet pet = new Pet(nome,nascimento);
        petDao.adicionarPet(pet);
    }

    //ler
    public Pet buscarPetNome(String nome){
        return petDao.buscarPorNome(nome);
    }
    
    public Pet buscarPetNascimento(String nascimento){
        return petDao.buscarPorNascimento(nascimento);    
    }
    
    public List<Pet> mostrarPet(){
        return petDao.listarPets();
    }

    //deletar
    public boolean deletarPetNome(String nome){
        return petDao.removerPorNome(nome);
    }
    public boolean deletarPetnascimento(String nascimento){
        return petDao.removerPorNascimento(nascimento);
    }
}
