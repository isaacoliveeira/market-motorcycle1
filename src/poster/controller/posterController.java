import poster.models.*;

public class posterController {

     private PosterService PosterService;

    public posterController(PosterService posterService) {
        PosterService = posterService;
    }

    public void addPost(Title title, Price price, Location location, Descrition descrition) {
        Post post = new Post(title, price, location, descrition);
        PosterService.addPost(post);
    }

    
     
}