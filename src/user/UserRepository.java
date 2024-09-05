package src.user;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public void addUser(User user) throws Exception{
        if(users.contains(user)){
            throw new Exception("USUÁRIO JÁ EXISTE"); 
        } 
        users.add(user);   
    }

    public void removeUser(User user) throws Exception{
        if (!users.contains(user)) {
            throw new Exception("USUÁRIO NÃO ENCONTRADO"); 
        }
        users.remove(user);
    }

    public void listAllUsers() throws Exception {
        if (users.isEmpty()) {
            throw new Exception("NÃO POSSUI USUÁRIOS CADASTRADOS");
        }
        for (User users : users) {
            System.out.println(users);
        }
    }

    public void searchUser(User user) throws Exception {
        if (!users.contains(user)){
            throw new Exception("USUÁRIO NÃO EXISTE");
        }
        user.toString();
    }

}
