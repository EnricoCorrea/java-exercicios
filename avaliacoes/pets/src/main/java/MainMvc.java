import java.util.Scanner;

import view.CachorroScan;
import view.CalopsitaScan;
import view.VeterinarioScan;

public class MainMvc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("\n[1] - Menu Veterinário\n[2] - Menu Calopsita\n[3] - Menu Cachorro\n[0] - Sair\nEscolha:");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    VeterinarioScan vetView = new VeterinarioScan();
                    vetView.menuVet();  // chama menu do veterinário
                case 2:
                    CalopsitaScan calopView = new CalopsitaScan();
                    calopView.menuCalopsita();  // chama menu do veterinário
                case 3:
                    CachorroScan dogView = new CachorroScan();
                    dogView.menuCachorro();  // chama menu do veterinário
                
                case 0:
                System.out.println("Encerrando...");
                default:
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}