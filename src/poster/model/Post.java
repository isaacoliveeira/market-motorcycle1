package poster.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {

    private Title title;
    private Price price;
    private Location local;
    private String formattedDate;

    public Post(Title title, Price price, Location local){
        this.title = title;
        this.price = price;
        this.local = local;
        this.formattedDate = formatData(LocalDateTime.now());
    } 
    
    public String formatData(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(formatter);
    }

    public String getFormattedDate(){
        return this.formattedDate;
    }
}
