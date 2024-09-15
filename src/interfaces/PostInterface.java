package interfaces;

import java.util.List;
import poster.model.Descrition;
import poster.model.Location;
import poster.model.Post;
import poster.model.Price;
import poster.model.Title;

public interface PostInterface {
    void addPost(Title title, Price price, Location location, Descrition descrition);
    void removePost(Title title, Price price, Location location);
    void updatePost(Post oldPost, Post newPost);
    List<Post> searchByTitle(Title title);
    void buy(Post post);
}
