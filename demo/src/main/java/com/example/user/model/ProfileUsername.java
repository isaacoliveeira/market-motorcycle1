package user.model;

public class ProfileUsername {

    private String userName;

    public ProfileUsername(String userName){
        this.userName = userName;;
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProfileUsername other = (ProfileUsername) obj;
        return this.userName.equals(other.userName);
    }

    public String getUsername() {
        return userName;
    }
}