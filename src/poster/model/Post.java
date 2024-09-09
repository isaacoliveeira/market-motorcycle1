package poster.model;

import java.sql.Date;

public class Post {

    private Title title;
    private Price price;
    private Location local;
    private Date date;

    public Post(Title title, Price price, Date date, Location local){
        this.title = title;
        this.price = price;
        this.date = date;
        this.local = local;
    }    
}
