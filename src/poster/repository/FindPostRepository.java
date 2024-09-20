package poster.repository;

import java.util.ArrayList;
import java.util.List;

import poster.model.*;

public class FindPostRepository {
    public List<Post> findPostsByTitle(Title title, List<Post> posters) {
            List<Post> result = new ArrayList<>();
            for (Post post : posters) {
                if (post.getTitle()
                .toString()
                .toLowerCase()
                .contains(post.getTitle().toString.toLowerCase()))
            }
            return result;
        }
}
