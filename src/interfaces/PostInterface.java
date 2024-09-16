package interfaces;

import java.util.List;
import poster.model.Post;
import poster.model.Title;

public interface PostInterface {
    void addPost(Post post);
    void removePost(Post post);
    void updatePost(Post oldPost, Post newPost);
    List<Post> searchByTitle(Title title);
    void buy(Post post);
}