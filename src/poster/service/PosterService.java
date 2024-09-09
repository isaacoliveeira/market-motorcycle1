package poster.service;

import interfaces.PostInterface;
import poster.model.Location;
import poster.model.Post;
import poster.model.Price;
import poster.model.Title;
import poster.repository.PosterRepository;

public class PosterService implements PostInterface {

    private PosterRepository posterRepository;

    public PosterService(PosterRepository posterRepository) {
        this.posterRepository = posterRepository;
    }

    @Override
    public void addPost(Title title, Price price, Location location) {
        Post post = new Post(title, price, null, location);
        posterRepository.addPost(post);
    }

    @Override
    public void removePost() {

    }

    @Override
    public void updatePost(Title title, Price price, Location location) {

    }
    
}
