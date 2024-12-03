package com.example.interfaces;

import java.util.List;
import com.example.poster.model.Post;

public interface PostInterface {
    void addPost(Post post);
    void removePost(Post post);
    void updatePost(Post oldPost, Post newPost);
    List<Post> search(String termo);
    void buy(Post post);
}