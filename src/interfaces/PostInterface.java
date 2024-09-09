package interfaces;

import poster.model.Location;
import poster.model.Price;
import poster.model.Title;

public interface PostInterface {
    public void addPost(Title title, Price price, Location location);
    public void removePost();
    public void updatePost(Title title, Price price, Location location);
}
