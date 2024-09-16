package poster.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Post {

    private Title title;
    private Price price;
    private Location local;
    private Date date;
    private Descrition descrition;
    private boolean sold;

    public Post(Title title, Price price, Location local, Descrition descrition){
        this.title = title;
        this.price = price;
        this.local = local;
        this.descrition = descrition;
        this.sold = false; // verifica se foi vendida
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

    public Price getPrice() {
        return price;
    }

    public Location getLocal() {
        return local;
    }

    public Date getDate() {
        return date;
    }

    public Descrition getDescrition() {
        return descrition;
    }


    public Post get(int index) {
        return get(index);
    }    

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
