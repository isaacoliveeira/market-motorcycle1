package cli;

import java.util.Scanner;

import poster.controller.PosterController;
import poster.model.Description;
import poster.model.Location;
import poster.model.Price;
import poster.model.Title;
import user.controller.UserController;

public class PostLoginMenuCLI {

    private UserController userController;
    private MainMenuCLI mainMenuCLI;
    private Scanner scanner;
    private PosterController posterController;

    public PostLoginMenuCLI(UserController userController, MainMenuCLI mainMenuCLI, PosterController posterController) {
        this.userController = userController;
        this.mainMenuCLI = mainMenuCLI;
        this.scanner = new Scanner(System.in);
        this.posterController = posterController;
    }

    public void displayPostLoginMenu() throws Exception {
        while (true) {
            System.out.println("\n******* MENU *******");
            System.out.println("\n1. Anunciar");
            System.out.println("2. Comprar");
            System.out.println("3. Ver Meus Anúncios");
            System.out.println("4. Gerenciar usuário");
            System.out.println("5. Sair");
            System.out.print("\nEscolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createPost();
                    break;
                case 2:
                    buyPost();
                    break;
                case 3:
                    listPosts();
                    break;
                case 4:
                    UserManagementCLI userManagementCLI = new UserManagementCLI(userController, mainMenuCLI);
                    userManagementCLI.displayUserManagementMenu();
                    break;
                case 5:
                    System.out.println("\nSaindo...");
                    System.out.println();
                    return; // Sair do loop
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }
    private void createPost() throws Exception {
        System.out.println("------CRIAR ANÚNCIO------");
        System.out.println("TÍTULO DO ANÚNCIO: ");
        String newTitle = scanner.nextLine();
        System.out.println("PREÇO: ");
        int newPrice = scanner.nextInt();
        System.out.println("LOCALIZAÇÃO: ");
        String newLocation = scanner.nextLine();
        System.out.println("DESCRIÇÃO: ");
        String newDescription = scanner.nextLine();

        Title title = new Title(newTitle);
        Price price = new Price(newPrice);
        Location location = new Location(newLocation);
        Description description = new Description(newDescription);

        posterController.addPost(title, price, location, description);
        System.out.println("ANÚNCIO CRIADO COM SUCESSO");
    }

    private void buyPost() throws Exception {
        System.out.println("------COMPRAR------");
        System.out.println("Digite o TÍTULO DO ANÚNCIO:");
        String titleAnuncio = scanner.nextLine();
        Title titleAn = new Title(titleAnuncio);

        if (posterController.selectPost(titleAn)) {
            posterController.buyPost();
            System.out.println("COMPRA REALIZADA");
        } else {
            System.out.println("ANÚNCIO NÃO ENCONTRADO");
        }
    }

    private void listPosts() throws Exception {
        System.out.println("------LISTA DE POSTS------");
        posterController.ListMyPosts();
    }
}