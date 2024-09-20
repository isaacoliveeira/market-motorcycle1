import cli.MainMenuCLI;
import user.controller.UserController;
import user.repository.UserRepository;
import user.service.UserService;

public class Main {

    public static void main(String[] args) throws Exception {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);
        MainMenuCLI mainMenuCLI = new MainMenuCLI(userController);
        mainMenuCLI.displayMainMenu();
    }
}