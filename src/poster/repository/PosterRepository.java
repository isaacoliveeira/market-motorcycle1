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

    public Post findPostByTitle(Title title) {
        for (Post post : posters) {
            if(post.getTitle.equals(title)) {
                return post;
            }
        }
        return null;
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(posters);
    }

    public List<Post> findPostsByLocation(Location location) {
        List<Post> result = new ArrayList<>();
        for (Post post : posters) {
            if (post.getLocation().equals(location)) {
                result.add(post);
            }
        }
        return result;
    }

    public List<Post> findPostsByPriceRange(Price minPrice, Price maxPrice) {
        List<Post> result = new ArrayList<>();
        for (Post post : posters) {
            if (post.getPrice().compareTo(minPrice) >= 0 && post.getPrice().compareTo(maxPrice) <= 0) {
                result.add(post);
            }
        }
        return result;
    }
}