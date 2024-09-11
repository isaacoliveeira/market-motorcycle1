package user.service;

import user.models.ProfilePassword;
import user.models.User;
import user.repository.UserRepository;
import user.validators.NameValidator;
import user.validators.PasswordValidator;
import user.validators.UsernameValidator;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) throws Exception {
        
        if (!NameValidator.validateName(user.getName())) {
            throw new Exception("Nome inválido.");
        }
        if (!UsernameValidator.validateUserName(user.getUsername())) {
            throw new Exception("Nome de usuário inválido.");
        }
        if (!PasswordValidator.validatePassword(user.getPassword())) {
            throw new Exception("Senha inválida.");
        }
        userRepository.addUser(user);
    }

    public void removeUser(String username) throws Exception {
        User user = userRepository.searchUser(username); // Verifica se o usuário existe
        if (user != null) {
            userRepository.removeUser(user);
        }
    }

    public User searchUser(String username) throws Exception {
        return userRepository.searchUser(username);
    }

    public void editUser(String username, User newUserData) throws Exception {
        // Valida os novos dados do usuário
        if (!NameValidator.validateName(newUserData.getName())) {
            throw new Exception("Nome inválido.");
        }
        if (!PasswordValidator.validatePassword(newUserData.getPassword())) {
            throw new Exception("Senha inválida.");
        }
        User existingUser = userRepository.searchUser(username);
        userRepository.removeUser(existingUser);
        userRepository.addUser(newUserData);
    }
}
