import cli.MainMenuCLI;
import poster.controller.PosterController;
import poster.repository.PosterRepository;
import poster.service.PosterService;
import user.controller.UserController;
import user.repository.UserRepository;
import user.service.UserService;

public class Main {

    public static void main(String[] args) throws Exception {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);
        PosterService posterService = new PosterService();
        PosterController posterController = new PosterController(posterService);
        MainMenuCLI mainMenuCLI = new MainMenuCLI(userController);

        // Iniciar o menu principal
        mainMenuCLI.displayMainMenu();
    }
}