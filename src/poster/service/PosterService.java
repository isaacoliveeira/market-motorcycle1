package poster.service;

import java.util.List;
import interfaces.PostInterface;
import poster.model.Post;
import poster.model.Title;
import poster.repository.PosterRepository;

public class PosterService implements PostInterface {
    
    private PosterRepository posterRepository;

    public PosterService() {
        this.posterRepository = PosterRepository.getInstance();
    }

    @Override
    public void addPost(Post post ) {
        posterRepository.addPost(post);
    }

    @Override
    public void removePost(Post post) {
        // faz uma comparação entre o post criado agroa, e o post que já existe na lista
        // removendo o que contem valores iguais
        posterRepository.removePost(post);
    }

    @Override
    public void updatePost(Post oldPost, Post newPost) {
        // ele chama um metodo criado no posterRepository, visto que posterRepository aqui n é uma lista, e nao tem esse metodo;
        if (posterRepository.containsPost(oldPost)) {
            posterRepository.update(oldPost, newPost);
        }
        throw new IllegalArgumentException("Post não foi encontrado");
    }

    public List<Post> search(String termo) {
        return posterRepository.findPost(termo);
    }

    @Override
    public void buy(Post post) {
        posterRepository.buy(post);
    }

    public List<Post> listPosts(){
        return posterRepository.getAllPosts();
    }

}