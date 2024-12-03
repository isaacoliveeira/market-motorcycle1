package com.example.poster.controller;

import com.example.poster.model.*;
import com.example.poster.service.PosterService;
import com.example.user.model.ProfileUsername;

import java.util.*;

public class PosterController {

    private Post loggedPost; 
    private PosterService posterService;

    public PosterController(PosterService posterService) {
        this.posterService = posterService;
    }

    public void addPost(Title title, Price price, Location location, Description description, ProfileUsername username) throws Exception {
        Post post = new Post(title, price, location, description, username);
        System.out.println(post.getTitle() + ";" + post.getPrice().getPrice()+ ";" + post.getLocation().getLocation() + ";" + post.getDescription());
        posterService.addPost(post);
    }

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

    public List<Post> search(String termo) throws Exception {
        List<Post> posts = posterService.search(termo);
        return posts;
    }

    public List<Post> listMyPosts(ProfileUsername username) throws Exception {
        List<Post> postUser = new ArrayList<>();
        for(Post post : posterService.listPosts()){
            if(post.getUsername().equals(username)){
                postUser.add(post);
            }
        }
        return postUser;
    }

    public List<Post> viewAllPosts() {
        return posterService.listPosts();
    }
}