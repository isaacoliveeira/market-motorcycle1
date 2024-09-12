package poster.model;

import java.sql.Date;

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

    
}
