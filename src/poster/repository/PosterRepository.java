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

    public boolean contains(Post post) {
        return posters.contains(post);
    }

    public List<Post> findPostsByTitle(Title title) {
        List<Post> result = new ArrayList<>();
        for (Post post : posters) {
            if (post.getTitle().equals(title)) {
                result.add(post);
            }
        }
        return result;
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(posters);
    }

    public void buy(Post post) {
        int index = posters.indexOf(post);
        if (index == -1) {
            Post postBuy = post.get(index);
            postBuy.setSold(true);
            posters.set(index, postBuy);
            posters.remove(index);
        } else {
            throw new IllegalArgumentException("Moto não encontrada para venda");
        }
    }
}