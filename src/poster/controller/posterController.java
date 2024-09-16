package poster.controller;

import poster.model.Post;
import poster.model.Title;
import poster.model.Price;
import poster.model.Location;
import poster.model.Descrition;
import poster.service.PosterService;

import java.util.List;

public class PosterController {
    
    private PosterService posterService;

    public PosterController(PosterService posterService) {
        this.posterService = posterService;
    }

    public void addPost(Title title, Price price, Location location, Descrition descrition) {
        Post post = new Post(title, price, location, descrition);
        posterService.addPost(post);
    }

    public void removePost(Title title, Price price, Location location) {
        Post post = new Post(title, price, location, null);
        posterService.removePost(post);
    }

    public void updatePost(Post oldPost, Post newPost) {
        try {
            posterService.updatePost(oldPost, newPost);
            System.out.println("Post atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchByTitle(Title title) {
        List<Post> posts = posterService.searchByTitle(title);
        if (posts.isEmpty()) {
            System.out.println("Nenhum post encontrado com o titulo fornecido");
        } else {
            for (Post post : posts) {
                System.out.println(post);
            }
        }
    }

    public void buyPost(Post post) {
        posterService.buy(post);
    }

}
