package com.example.cli;

import java.util.Scanner;
import com.example.poster.controller.PosterController;
import com.example.poster.service.PosterService;
import com.example.poster.repository.PosterRepository;
import com.example.user.controller.UserController;
import com.example.user.model.ProfileName;
import com.example.user.model.ProfilePassword;
import com.example.user.model.ProfileUsername;

public class MainMenuCLI {

    private UserController userController;
    private Scanner scanner;
    private boolean running;

    public MainMenuCLI(UserController userController) {
        this.userController = userController;
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    public void displayMainMenu() throws Exception {
        while (running) {
            System.out.println("******* MENU PRINCIPAL *******");
            System.out.println("\n1. Login");
            System.out.println("2. Criar Usuário");
            System.out.println("3. Sair");
            System.out.print("\nEscolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    exit();
                default:
                    System.out.println("\nOpção inválida. Tente novamente!");
                    System.out.println("");
            }
        }
    }

    private void loginUser() throws Exception {
        boolean isLoginSuccessful = false;
    
        while (!isLoginSuccessful) {
            System.out.print("\nDigite seu nome de usuário: ");
            String username = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String password = scanner.nextLine();
    
            ProfileUsername profileUsername = new ProfileUsername(username);
            ProfilePassword profilePassword = new ProfilePassword(password);
    
            isLoginSuccessful = userController.loginUser(profileUsername, profilePassword);
    
            if (isLoginSuccessful) {
                System.out.println("\nLogin realizado com sucesso!");
    
                PosterRepository.getInstance();
                PosterService posterService = new PosterService();
                PosterController posterController = new PosterController(posterService);
    
                PostLoginMenuCLI postLoginMenu = new PostLoginMenuCLI(userController, this, posterController);
                postLoginMenu.displayPostLoginMenu(profileUsername);
            } else {
                System.out.println("\nFalha no login. Usuário ou senha incorretos.");
                System.out.print("Deseja tentar novamente? (s/n): ");
                String tryAgain = scanner.nextLine();
                
                if (tryAgain.equalsIgnoreCase("n")) {
                    System.out.println("Saindo do login...");
                    break; 
                }
            }
        }
    }
    

    private void createUser() throws Exception {
        System.out.print("\nDigite seu nome: (Use apenas letras maiúsculas e/ou minúsculas)\n");
        String name = scanner.nextLine();
        System.out.print("\nDigite seu nome de usuário: (O nome de usuário deve começar com letra, ter no mínimo 4 letras e entre 0 e 4 números)\n");
        String username = scanner.nextLine();
        System.out.print("\nDigite sua senha: (Use pelo menos 6 letras, 1 caractere especial e 1 número)\n");
        String password = scanner.nextLine();

        ProfileName profileName = new ProfileName(name);
        ProfileUsername profileUsername = new ProfileUsername(username);
        ProfilePassword profilePassword = new ProfilePassword(password);

        userController.createUser(profileName, profileUsername, profilePassword);
        System.out.println("\nUsuário criado com sucesso!");
        System.out.println();
    }

    public void returnToMainMenu() throws Exception {
        displayMainMenu();
    }

    public void exit(){
        running = false;
    }
}
