package cli;

import java.util.Scanner;
import user.controller.UserController;

public class PostLoginMenuCLI {

    private UserController userController;
    private MainMenuCLI mainMenuCLI;
    private Scanner scanner;

    public PostLoginMenuCLI(UserController userController, MainMenuCLI mainMenuCLI) {
        this.userController = userController;
        this.mainMenuCLI = mainMenuCLI;
        this.scanner = new Scanner(System.in);
    }

    public void displayPostLoginMenu() throws Exception {
        while (true) {
            System.out.println("\n******* MENU PÓS-LOGIN *******");
            System.out.println("\n1. Anunciar");
            System.out.println("2. Comprar");
            System.out.println("3. Gerenciar usuário");
            System.out.println("4. Sair");
            System.out.print("\nEscolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (option) {
                case 1:
                    System.out.println("\nFunção de Anunciar ainda não implementada.");
                    break;
                case 2:
                    System.out.println("\nFunção de Comprar ainda não implementada.");
                    break;
                case 3:
                    UserManagementCLI userManagementCLI = new UserManagementCLI(userController, mainMenuCLI);
                    userManagementCLI.displayUserManagementMenu();
                    break;
                case 4:
                    System.out.println("\nSaindo...");
                    System.out.println();
                    return; // Sair do loop
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }
}
