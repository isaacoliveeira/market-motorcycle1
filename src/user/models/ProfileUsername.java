package user.models;

public class ProfileUsername {

    private String userName;

    public ProfileUsername(ProfileUsername userName){
        this.userName = userName.toString().toLowerCase();
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

    //NÃO ENTENDO ESSE MÉTODO
    /*
    public boolean validateUsername(ProfileUsername userName){
        return validateUsername(userName);
    }
    */
}