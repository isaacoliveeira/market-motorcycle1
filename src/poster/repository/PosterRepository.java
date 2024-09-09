package poster.repository;

import java.util.ArrayList;
import java.util.List;
import poster.model.Post;

public class PosterRepository {
    List<Post> posters = new ArrayList<>();

    public PosterRepository(List<Post> posters) {
        this.posters = posters;
    }

    public void addPost(Post post) {
        if (posters.contains(post)) {
            throw new IllegalArgumentException("");
        }

    }

    public void removePost(Post post) {

    }
}