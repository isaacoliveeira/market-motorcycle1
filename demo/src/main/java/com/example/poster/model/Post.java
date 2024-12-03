package poster.model;

import user.model.ProfileUsername;

public class Post {

    private Title title;
    private Price price;
    private Location location;
    private Description description;
    private boolean sold;
    private ProfileUsername username;

    public Post(Title title, Price price, Location location, Description description, ProfileUsername username){
        this.title = title;
        this.price = price;
        this.location = location;
        this.description = description;
        this.sold = false;
        this.username = username;
    }
    
    public ProfileUsername getUsername() {
        return username;
    }

    public void setUsername(ProfileUsername username) {
        this.username = username;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Title getTitle() {
        return title;
    }

    public Price getPrice(){
        return price;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Post get(int index) {
        return get(index);
    }    

    public Post(Title title, Price price, Location location){
        this.title = title;
        this.price = price;
        this.location = location;
    } 
    
    @Override
    public String toString() {
        return "Título: " + title.getTitle() + "|" + "Preço: " + price.getPrice()  + "|" + "Localização: " + location.getLocation() + "|" + "Descrição:" +    description.getDescription();
    }
}
