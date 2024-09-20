package cli;

import java.util.List;
import java.util.Scanner;

import poster.controller.PosterController;
import poster.model.Description;
import poster.model.Location;
import poster.model.Post;
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
            System.out.println("******* MENU PÓS-LOGIN *******");
            System.out.println("1. Anunciar");
            System.out.println("2. Ver meus anúncios");
            System.out.println("3. Ver anúncios disponíveis");
            System.out.println("4. Gerenciar usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createPost();
                    break;
                case 2:
                    listPosts();
                    break;
                case 3:
                    viewAllPosts();
                    break;
                case 4:
                    UserManagementCLI userManagementCLI = new UserManagementCLI(userController, mainMenuCLI);
                    userManagementCLI.displayUserManagementMenu();
                    break;
                case 5:
                    mainMenuCLI.returnToMainMenu();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void createPost() throws Exception {
        System.out.println("------CRIAR ANÚNCIO------");
        System.out.println("TÍTULO DO ANÚNCIO: ");
        String newTitle = scanner.nextLine();
        System.out.println("PREÇO: ");
        int newPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("LOCALIZAÇÃO: ");
        String newLocation = scanner.nextLine();
        System.out.println("DESCRIÇÃO: ");
        String newDescription = scanner.nextLine();

        Title title = new Title(newTitle);
        Price price = new Price(newPrice);
        Location location = new Location(newLocation);
        Description description = new Description(newDescription);

        posterController.addPost(title, price, location, description); ////pra colocar o user que tá logado
        System.out.println("ANÚNCIO CRIADO COM SUCESSO!");
    }

    private void buyPost(Post post) {
        System.out.println("Você escolheu comprar o seguinte anúncio:");
        System.out.println(post);
        System.out.print("Deseja confirmar a compra? (s/n): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("s")) {
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Compra cancelada.");
        }
    }

    private void listPosts() throws Exception {
        System.out.println("------LISTA DE POSTS------");
        for(Post post : posterController.listMyPosts()){
            System.out.println(post.toString());
        };
    }


    private void viewAllPosts() throws Exception {
        System.out.println("------ ANÚNCIOS DISPONÍVEIS ------");
        List<Post> posts = posterController.viewAllPosts();

        if (posts.isEmpty()) {
            System.out.println("Nenhum anúncio disponível.");
        } else {
            for (int i = 0; i < posts.size(); i++) {
                System.out.println((i + 1) + ". " + posts.get(i));
            }
            System.out.println("Escolha o número do anúncio para comprar ou 0 para sair: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= posts.size()) {
                Post selectedPost = posts.get(choice - 1);
                buyPost(selectedPost);
            } else {
                System.out.println("Voltando ao menu...");
            }
        }
    }
}