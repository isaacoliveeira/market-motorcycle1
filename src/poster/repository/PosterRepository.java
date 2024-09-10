package poster.repository;

import java.util.ArrayList;
import java.util.List;
import poster.model.Post;

public class PosterRepository {
    List<Post> posters = new ArrayList<>();

    public PosterRepository() {
        this.posters = new ArrayList<>();
    }

    //caso onde aparece um novo usuario, é necessario instaciar outra lista;
    public PosterRepository(List<Post> posters) {
        this.posters = posters != null ? posters : new ArrayList<>();
    }

    public void addPost(Post post) {
        if (posters.contains(post)) {
            throw new IllegalArgumentException("POST JÁ EXISTE");
        }
        posters.add(post);
    }

    public void removePost(Post post) {
        if (!posters.contains(post)) {
            throw new IllegalArgumentException("Post não existe");
        }
        posters.remove(post);
    }

    public void uptade(Post oldPost, Post newPost) {
        int index = posters.indexOf(oldPost);
        if (index != -1) {
            posters.set(index, newPost);
        }
        throw new IllegalArgumentException("Post não encontrado");
    }

    public boolean contains(Post post) {
        return posters.contains(post);
    }
}