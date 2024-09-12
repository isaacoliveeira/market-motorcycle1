package poster.model;

import java.sql.Date;

public class Post {

    private Title title;
    private Price price;
    private Location local;
    private Date date;
    private Descrition descrition;

    public Post(Title title, Price price, Location local, Descrition descrition){
        this.title = title;
        this.price = price;
        this.local = local;
        this.descrition = descrition;
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

    
}
