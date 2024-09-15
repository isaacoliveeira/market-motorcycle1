package user.models;

public class User {
    private ProfileName name;
    private ProfileUsername username;
    private ProfilePassword password;

    public User(ProfileName name, ProfileUsername username, ProfilePassword password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Método para comparar se dois usuários têm o mesmo nome de usuário
    public boolean hasUsername(ProfileUsername username) {
        return this.username.equals(username);
    }

    // Método para atualizar as informações do usuário
    public void update(ProfileName newName, ProfileUsername newUsername, ProfilePassword newPassword) {
        if (newName != null) {
            this.name = newName;
        }
        if (newUsername != null) {
            this.username = newUsername;
        }
        if (newPassword != null) {
            this.password = newPassword;
        }
    }

    // Método para verificar se o usuário corresponde ao perfil fornecido
    public boolean matches(User user) {
        return this.matches(user.username);
    }

    // Método para verificar se o usuário corresponde ao perfil fornecido
    public boolean matches(ProfileUsername username) {
        return this.username.equals(username);
    }

    // Método para verificar se o usuário corresponde ao perfil fornecido
    public boolean matches(ProfileName name) {
        return this.name.equals(name);
    }

    // Método para verificar se o usuário corresponde ao perfil fornecido
    public boolean matches(ProfilePassword password) {
        return this.password.equals(password);
    }

    public boolean checkPassword(ProfilePassword providedPassword) {
        return this.password.getPassword().equals(providedPassword.getPassword());
    }
    
    public ProfileName getName() {
        return name;
    }

    public void setName(ProfileName name) {
        this.name = name;
    }

    public ProfileUsername getUsername() {
        return username;
    }

    public void setUsername(ProfileUsername username) {
        this.username = username;
    }

    public ProfilePassword getPassword() {
        return password;
    }

    public void setPassword(ProfilePassword password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", username=" + username + "]";
    }
}
