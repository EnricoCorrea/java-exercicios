package mvc.view;

import java.util.List;
import java.util.Scanner;

import main.java.mvc.model.Tutor;
import main.java.mvc.Controller.TutorController;
import main.java.mvc.model.Tutor;

public class TutorScan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TutorController controller = new TutorController();

        int index;

        do {
            System.out.println("\n [1] - Criar Tutor");
            System.out.println(" [2] - Ler Tutor");
            System.out.println(" [3] - Listar Tutores");
            System.out.println(" [4] - Deletar Tutor");
            System.out.println(" [0] - Sair");
            index = scan.nextInt();
            scan.nextLine();

            switch (index) {
                case 1:
                    System.out.print("\nDigite o nome do tutor: ");
                    String nome = scan.nextLine();
                    System.out.print("Digite o apelido: ");
                    String apelido = scan.nextLine();
                    controller.criarTutor(nome, apelido);
                    break;

                case 2:
                    System.out.println("\nProcurar por: \n [1] - Nome \n [2] - Apelido");
                    int opcao = scan.nextInt();
                    scan.nextLine();
                    if (opcao == 1) {
                        System.out.print("Digite o nome: ");
                        String buscarnome = scan.nextLine();
                        Tutor encontrounome = controller.buscarPorNome(buscarnome);
                        if (encontrounome != null) {
                            System.out.println(encontrounome);
                        } else {
                            System.out.println("Tutor não encontrado.");
                        }
                    } else if (opcao == 2) {
                        System.out.print("Digite o apelido: ");
                        String buscarapelido = scan.nextLine();
                        Tutor encontrouapelido = controller.buscarPorApelido(buscarapelido);
                        if (encontrouapelido != null) {
                            System.out.println(encontrouapelido);
                        } else {
                            System.out.println("Tutor não encontrado.");
                        }
                    } else {
                        System.out.println("Digite uma opção válida.");
                    }
                    break;

                case 3:
                    List<Tutor> tutores = controller.listarTutores();
                    if (tutores.isEmpty()) {
                        System.out.println("Nenhum tutor cadastrado.");
                    } else {
                        for (Tutor t : tutores) {
                            System.out.println("Nome: " + t.getNome() + " | Apelido: " + t.getApelido());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Procurar por: \n [1] - Nome \n [2] - Apelido");
                    int opcao2 = scan.nextInt();
                    scan.nextLine();
                    if (opcao2 == 1) {
                        System.out.print("Digite o nome: ");
                        String nomedelete = scan.nextLine();
                        controller.deletarPorNome(nomedelete);
                    } else if (opcao2 == 2) {
                        System.out.print("Digite o apelido: ");
                        String apelidodelete = scan.nextLine();
                        controller.deletarPorApelido(apelidodelete);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;
            }
        } while (index != 0);

        scan.close();
    }
}
