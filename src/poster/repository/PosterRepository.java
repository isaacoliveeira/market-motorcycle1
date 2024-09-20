package poster.repository;

import java.util.ArrayList;
import java.util.List;
import poster.model.Post;
import poster.model.Title;
import user.model.ProfileUsername;
import user.model.User;

public class PosterRepository {
    List<Post> posters;
    static PosterRepository instance;

    public PosterRepository() {
        this.posters = new ArrayList<>();
    }

    public static PosterRepository getInstance() {
        if (instance == null) {
            instance = new PosterRepository();
        }
        return instance;
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

    public void update(Post oldPost, Post newPost) {
        int index = posters.indexOf(oldPost);
        if (index != -1) {
            posters.set(index, newPost);
        } else {
            throw new IllegalArgumentException("Post não encontrado");
        }
    }

    public boolean containsPost(Post post) {
        return posters.contains(post);
    }

    public List<Post> findPost(String termo) {
        return FindPostRepository.findPosts(termo, posters);
    }

    public List<Post> getAllPosts() {
        return posters;
    }

    public void buy(Post post) {
        int index = posters.indexOf(post);
        if (index != -1) {
            Post postBuy = posters.get(index);
            postBuy.setSold(true);
            posters.set(index, postBuy);
        } else {
            throw new IllegalArgumentException("Post não encontrado para venda");
        }
    }
}