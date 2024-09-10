package user.repository;
import java.util.ArrayList;
import java.util.List;

import user.models.ProfileName;
import user.models.ProfilePassword;
import user.models.ProfileUsername;
import user.models.User;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public void addUser(User user) throws Exception{
        for (User u : users){
            if(u.getUsername().equals(user.getUsername())) {
                throw new Exception("Usuário já existe");
            }
        }
        users.add(user);
    }

    public void removeUser(User user) throws Exception{
        if (!users.contains(user)) {
            throw new Exception("Usuário não encontrado"); 
        }
        users.remove(user);
    }

    public User searchUser(String username) throws Exception {
        for(User user : users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        throw new Exception("Usuário não encontrado");
    }

    //Usuário só poderá atualizar suas informações caso esteja logado, se estiver logado não há necessidade de fazer verificação de senha pois ja foi feita
    public void updateUser(String username, ProfileName newName, ProfileUsername newUsername, ProfilePassword newPassword) throws Exception {
    User user = searchUser(username);
    if (user != null) {
        if (newName != null) user.setName(newName);
        if (newUsername != null) user.setUsername(newUsername);
        if (newPassword != null) user.setPassword(newPassword);
    }
}

}
