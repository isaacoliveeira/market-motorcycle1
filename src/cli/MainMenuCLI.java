package cli;

import java.util.Scanner;
import user.controller.UserController;
import user.models.ProfileName;
import user.models.ProfileUsername;
import user.models.ProfilePassword;

public class MainMenuCLI {

    private UserController userController;
    private Scanner scanner;

    public MainMenuCLI(UserController userController) {
        this.userController = userController;
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() throws Exception {
        while (true) {
            System.out.println("******* MENU PRINCIPAL *******");
            System.out.println("\n1. Login");
            System.out.println("2. Criar Usuário");
            System.out.println("3. Sair");
            System.out.print("\nEscolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (option) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    return; // Sair do loop
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    System.out.println("");
            }
        }
    }

    private void loginUser() throws Exception {
        System.out.print("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String password = scanner.nextLine();

        ProfileUsername profileUsername = new ProfileUsername(username);
        ProfilePassword profilePassword = new ProfilePassword(password);

        userController.loginUser(profileUsername, profilePassword);
        System.out.println("Login realizado com sucesso!");
    }

    private void createUser() throws Exception {
        System.out.print("\nDigite seu nome: ");
        String name = scanner.nextLine();
        System.out.print("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String password = scanner.nextLine();

        ProfileName profileName = new ProfileName(name);
        ProfileUsername profileUsername = new ProfileUsername(username);
        ProfilePassword profilePassword = new ProfilePassword(password);

        userController.createUser(profileName, profileUsername, profilePassword);
        System.out.println("Usuário criado com sucesso!");
    }
}
