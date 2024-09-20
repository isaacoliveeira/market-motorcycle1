package poster.controller;

import poster.model.Post;
import poster.model.Title;
import poster.repository.PosterRepository;
import poster.model.Price;
import poster.model.Location;
import poster.model.Description;
import poster.service.PosterService;
import user.models.ProfileUsername;
import user.models.User;

import java.util.List;

public class PosterController {

    private Post loggedPost; 
    private PosterService posterService;
    private PosterRepository posterRepository;

    public PosterController(PosterService posterService) {
        this.posterService = posterService;
    }

    public void addPost(Title title, Price price, Location location, Description description, ProfileUsername username) throws Exception {
        Post post = new Post(title, price, location, description, username);
        posterService.addPost(post);
    }

    // public Boolean selectPost(String termo) throws Exception {
    //     List<Post> posts = posterSerString termo(title);
    //     if (!posts.isEmpty()) {
    //         loggedPost = posts.get(0);
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    public void updatePost(Title newTitle, Price newPrice, Location newLocation, Description newDescription, ProfileUsername username) throws Exception {
        if (loggedPost != null) {
            Post newPost = new Post(newTitle, newPrice, newLocation, newDescription, username);
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

    public void search(String termo) throws Exception {
        List<Post> posts = posterService.search(termo);
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

    public List<Post> listMyPosts() throws Exception {
        return posterService.listPosts();
    }

    public List<Post> viewAllPosts() {
        return posterRepository.getAllPosts();
    }

    public List<Post> getPostsByUser(User user) {
        return posterRepository.getPostsByUser(user);
    }
}
