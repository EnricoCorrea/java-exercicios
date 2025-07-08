package mvc.view;

import java.util.List;
import java.util.Scanner;

import mvc.controller.PetController;
import mvc.model.Pet;

public class PetScan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PetController controller = new PetController();


        int index;

        do{
            System.out.println("\n--- MENU TUTOR ---");
            System.out.printf(" [1] - Criar Pet \n [2] - Ler Pet \n [3] - Listar Pets \n [4] - Deletar Pet \n [0] - Sair \n");
            index = scan.nextInt();
            scan.nextLine();
            switch(index){
                case 1:
                System.out.printf("\nDigite o nome do Pet: ");
                String nome = scan.nextLine();
                System.out.printf("\nDigite o nascimento: ");
                String nascimento = scan.nextLine();
                controller.criarPet(nome, nascimento);
                break;

                case 2:
                System.out.println("\nProcurar por: \n [1] - Nome \n [2] - Nascimento");
                int opcao = scan.nextInt();
                scan.nextLine();
                if(opcao==1){
                    System.out.printf("\nDigite o nome: ");
                    String buscarnome = scan.nextLine();
                    Pet encontrounome = controller.buscarPetNome(buscarnome);
                    if(encontrounome!=null){
                        System.out.println(encontrounome);
                    }else{
                        System.out.println("Nome não encontrado");
                    }
                }else if(opcao==2){
                    System.out.printf("\nDigite o nascimento: ");
                    String buscarnascimento = scan.nextLine();
                    Pet encontrounascimento = controller.buscarPetNascimento(buscarnascimento);
                    if(encontrounascimento!=null){
                        System.out.println(encontrounascimento);
                    }else{
                        System.out.println("nascimento não encontrado");
                    }
                }else{
                    System.out.printf("\nDigite uma opção válida.");
                    break;
                }
                break;

                case 3:
                List<Pet> lista = controller.mostrarPet();
                if (lista.isEmpty()) {
                    System.out.println("Nenhuma Pet cadastrada.");
                } else {
                    for (Pet p : lista) {
                        System.out.println("Nome: " + p.getNome() + " | nascimento: " + p.getNascimento());
                    }
                }
                break;

                case 4:
                System.out.printf("Procurar por: \n [1] - Nome \n [2] - nascimento");
                int opcao2 = scan.nextInt();
                
                if(opcao2==1){
                    System.out.printf("\nDigite o nome: ");
                    String nomedelete = scan.nextLine();
                    controller.deletarPetNome(nomedelete);
                }else if(opcao2==2){
                    System.out.printf("\nDigite o nascimento: ");
                    String nascimentodelete = scan.nextLine();
                    controller.deletarPetnascimento(nascimentodelete);
                }else{
                    System.out.printf("\n Digite uma opção válida.");
                    break;
                }
                break;

                case 0:
                System.out.println("Programa encerrado.");
            }
        }while(index!=0);
    }
}
