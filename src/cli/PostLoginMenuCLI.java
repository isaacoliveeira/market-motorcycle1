package cli;

import java.util.List;
import java.util.Scanner;

import poster.controller.PosterController;
import poster.model.Description;
import poster.model.Location;
import poster.model.Post;
import poster.model.Price;
import poster.model.Title;
import poster.repository.PosterCSV;
import user.controller.UserController;
import user.model.ProfileUsername;

public class PostLoginMenuCLI {

    private UserController userController;
    private MainMenuCLI mainMenuCLI;
    private Scanner scanner;
    private PosterController posterController;
    private ProfileUsername username;

    public PostLoginMenuCLI(UserController userController, MainMenuCLI mainMenuCLI, PosterController posterController) {
        this.userController = userController;
        this.mainMenuCLI = mainMenuCLI;
        this.scanner = new Scanner(System.in);
        this.posterController = posterController;
    }

    public void displayPostLoginMenu(ProfileUsername username) throws Exception {
        //PosterCSV.importar(); //////////////////////////////////////????????????????????????????????????
        this.username = username;
        while (true) {
            System.out.println("******* MENU PÓS-LOGIN *******");
            System.out.println("1. Anunciar");
            System.out.println("2. Ver meus anúncios");
            System.out.println("3. Ver anúncios disponíveis");
            System.out.println("4. Procurar anúncios disponíveis");
            System.out.println("5. Gerenciar conta");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createPost();
                    break;
                case 2:
                    listMyPosts(username);
                    break;
                case 3:
                    viewAllPosts();
                    break;
                case 4:
                    findPost();
                    break;
                case 5:
                    UserManagementCLI userManagementCLI = new UserManagementCLI(userController, mainMenuCLI);
                    userManagementCLI.displayUserManagementMenu();
                    break;
                case 6:
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

        posterController.addPost(title, price, location, description, username); ////pra colocar o user que tá logado
        System.out.println("ANÚNCIO CRIADO COM SUCESSO!");
        PosterCSV.exportar();
    }

    private void findPost() throws Exception{
        String termo = scanner.nextLine();
        if(posterController.search(termo).isEmpty()){
            System.out.println("Não há públicações para esta pesquisa.");
        }
        if (posterController.search(termo).size()>=1){
            System.out.println("Públicações encontradas:");
            for(Post post : posterController.search(termo)){
                System.out.println(post.toString());
            }
        }
    }

    private void listMyPosts(ProfileUsername username) throws Exception {
        System.out.println("------LISTA DE POSTS------");
        for(Post post : posterController.listMyPosts(username)){
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
            System.out.print("Escolha o número do anúncio para comprar ou 0 para sair: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= posts.size()) {
                Post selectedPost = posts.get(choice - 1);
                System.out.println("Você comprou o anúncio: " + selectedPost);
            } else if (choice == 0) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}