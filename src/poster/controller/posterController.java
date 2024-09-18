package poster.controller;

import poster.model.Post;
import poster.model.Title;
import poster.model.Price;
import poster.model.Location;
import poster.model.Description;
import poster.service.PosterService;

import java.util.List;

public class PosterController {

    private Post loggedPost; 
    private PosterService posterService;

    public PosterController(PosterService posterService) {
        this.posterService = posterService;
    }

    public void addPost(Title title, Price price, Location location, Description description) throws Exception {
        Post post = new Post(title, price, location, description);
        posterService.addPost(post);
    }

    public Boolean selectPost(Title title) throws Exception {
        List<Post> posts = posterService.searchByTitle(title);
        if (!posts.isEmpty()) {
            loggedPost = posts.get(0);
            return true;
        } else {
            return false;
        }
    }

    public void updatePost(Title newTitle, Price newPrice, Location newLocation, Description newDescription) throws Exception {
        if (loggedPost != null) {
            Post newPost = new Post(newTitle, newPrice, newLocation, newDescription);
            posterService.updatePost(loggedPost, newPost);
        } else {
            throw new Exception("Nenhum post selecionado para atualizar.");
        }
    }

    public void removePost() throws Exception {
        if (loggedPost != null) {
            posterService.removePost(loggedPost);
        } else {
            throw new Exception("Nenhum post selecionado para remover.");
        }
    }

    public void searchByTitle(Title title) throws Exception {
        List<Post> posts = posterService.searchByTitle(title);
        if (posts.isEmpty()) {
            System.out.println("Nenhum post encontrado com o título fornecido.");
        } else {
            for (Post post : posts) {
                System.out.println("Post encontrado: " + post);
            }
        }
    }

    public void buyPost() throws Exception {
        if (loggedPost != null) {
            posterService.buy(loggedPost);
        } else {
            throw new Exception("Nenhum post selecionado para compra.");
        }
    }
}
