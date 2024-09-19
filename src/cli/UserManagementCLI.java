package cli;

import java.util.Scanner;
import user.controller.UserController;
import user.models.ProfileName;
import user.models.ProfilePassword;
import user.models.ProfileUsername;

public class UserManagementCLI {

    private UserController userController;
    private MainMenuCLI mainMenuCLI;
    private Scanner scanner;

    public UserManagementCLI(UserController userController, MainMenuCLI mainMenuCLI) {
        this.userController = userController;
        this.mainMenuCLI = mainMenuCLI;
        this.scanner = new Scanner(System.in);
    }

    public void displayUserManagementMenu() throws Exception {
        while (true) {
            System.out.println("\n******* GERENCIAR CONTA *******");
            System.out.println("\n1. Atualizar informações");
            System.out.println("2. Deletar meu perfil");
            System.out.println("3. Voltar");
            System.out.print("\nEscolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (option) {
                case 1:
                    updateUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    return; // Voltar ao menu anterior
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }

    private void updateUser() throws Exception {
        System.out.println("\n******* ATUALIZAR INFORMAÇÕES *******");
        System.out.print("\nDigite o novo nome: ");
        String newName = scanner.nextLine();
        System.out.print("Digite o novo nome de usuário: ");
        String newUsername = scanner.nextLine();
        System.out.print("Digite a nova senha: ");
        String newPassword = scanner.nextLine();

        // Criação dos novos perfis para atualização
        ProfileName profileName = new ProfileName(newName);
        ProfileUsername profileUsername = new ProfileUsername(newUsername);
        ProfilePassword profilePassword = new ProfilePassword(newPassword);

        // Chamar o método de edição do UserController
        userController.editUser(profileName, profileUsername, profilePassword);
        System.out.println("\nInformações do usuário atualizadas com sucesso!");
    }

    private void deleteUser() throws Exception {
        System.out.println("\n******* DELETAR CONTA *******");
        System.out.println("\nTem certeza de que deseja deletar seu perfil? Isso não poderá ser desfeito.");
        System.out.print("\nDigite 'CONFIRMAR' para deletar a conta ou '0' para voltar: ");
        String confirmation = scanner.nextLine();

        if (confirmation.equals("CONFIRMAR")) {
            // Chamar o método de exclusão do UserController
            System.out.println("\nDeletando Conta...");
            userController.removeUser(); // Chame o método para deletar o usuário logado
            System.out.println("\nUsuário deletado com sucesso.");
            System.out.println("\nParando o programa...");
            System.out.println();
            System.exit(0);
        } else if (confirmation.equals("0")) {
            System.out.println("\nOperação cancelada. Voltando ao menu anterior.");
        } else {
            System.out.println("\nComando inválido. Operação cancelada.");
        }
    }
}
