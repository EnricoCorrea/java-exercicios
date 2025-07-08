package mvc.view;

import java.util.List;
import java.util.Scanner;
import main.java.mvc.dao.PessoaDao;
import main.java.mvc.model.Pessoa;
import main.java.mvc.Controller.PessoaController;


public class PessoaScan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PessoaController controller = new PessoaController();


        int index;

        do{
            System.out.println("\n--- MENU TUTOR ---");
            System.out.printf(" [1] - Criar Pessoa \n [2] - Ler Pessoa \n [3] - Listar Pessoas \n [4] - Deletar Pessoa \n [0] - Sair \n");
            index = scan.nextInt();
            scan.nextLine();
            switch(index){
                case 1:
                System.out.printf("\nDigite o nome da pessoa: ");
                String nome = scan.nextLine();
                System.out.printf("\nDigite o apelido: ");
                String apelido = scan.nextLine();
                controller.criarPessoa(nome, apelido);
                break;

                case 2:
                System.out.println("\nProcurar por: \n [1] - Nome \n [2] - Apelido");
                int opcao = scan.nextInt();
                scan.nextLine();
                if(opcao==1){
                    System.out.printf("\nDigite o nome: ");
                    String buscarnome = scan.nextLine();
                    Pessoa encontrounome = controller.buscarPessoaNome(buscarnome);
                    if(encontrounome!=null){
                        System.out.println(encontrounome);
                    }else{
                        System.out.println("Nome não encontrado");
                    }
                }else if(opcao==2){
                    System.out.printf("\nDigite o apelido: ");
                    String buscarapelido = scan.nextLine();
                    Pessoa encontrouapelido = controller.buscarPessoaApelido(buscarapelido);
                    if(encontrouapelido!=null){
                        System.out.println(encontrouapelido);
                    }else{
                        System.out.println("Apelido não encontrado");
                    }
                }else{
                    System.out.printf("\nDigite uma opção válida.");
                    break;
                }
                break;

                case 3:
                List<Pessoa> lista = controller.mostrarPessoa();
                if (lista.isEmpty()) {
                    System.out.println("Nenhuma pessoa cadastrada.");
                } else {
                    for (Pessoa p : lista) {
                        System.out.println("Nome: " + p.getNome() + " | Apelido: " + p.getApelido());
                    }
                }
                break;

                case 4:
                System.out.printf("Procurar por: \n [1] - Nome \n [2] - Apelido");
                int opcao2 = scan.nextInt();
                
                if(opcao2==1){
                    System.out.printf("\nDigite o nome: ");
                    String nomedelete = scan.nextLine();
                    controller.deletarPessoaNome(nomedelete);
                }else if(opcao2==2){
                    System.out.printf("\nDigite o apelido: ");
                    String apelidodelete = scan.nextLine();
                    controller.deletarPessoaApelido(apelidodelete);
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