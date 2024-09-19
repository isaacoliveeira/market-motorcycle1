package poster.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import user.models.ProfileUsername;
import user.models.User;

public class Post {

    private Title title;
    private Price price;
    private Location location;
    private Date date;
    private Description description;
    private boolean sold;
    private ProfileUsername username;

    public Post(Title title, Price price, Location location, Description description, ProfileUsername username){
        this.title = title;
        this.price = price;
        this.location = location;
        this.description = description;
        this.sold = false; // verifica se foi vendida
        this.username = username;
    }
    
    

    public ProfileUsername getUsername() {
        return username;
    }

    public void setUsername(ProfileUsername username) {
        this.username = username;
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

    public Post get(int index) {
        return get(index);
    }    

    private String formattedDate;

    public Post(Title title, Price price, Location location){
        this.title = title;
        this.price = price;
        this.location = location;
        this.formattedDate = formatData(LocalDateTime.now());
    } 
    
    public String formatData(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(formatter);
    }

    public String getFormattedDate(){
        return this.formattedDate;
    }

    @Override
    public String toString() {
        return "Título: " + title.getTitle() + "|" + "Preço: " + price.getPrice()  + "|" + "Localização: " + location.getLocation() + "|" + "Descrição:" +    description.getDescription();
    }
}
