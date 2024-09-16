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
    
        boolean isLoginSuccessful = userController.loginUser(profileUsername, profilePassword);
    
        if (isLoginSuccessful) {
            System.out.println("\nLogin realizado com sucesso!");
    
            // Exibir o menu pós-login
            PostLoginMenuCLI postLoginMenu = new PostLoginMenuCLI(userController);
            postLoginMenu.displayPostLoginMenu();
        } else {
            System.out.println("\nFalha no login. Usuário ou senha incorretos.");
        }
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
        System.out.println("\nUsuário criado com sucesso!");
        System.out.println();
    }
}
