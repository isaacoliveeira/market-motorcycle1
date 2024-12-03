package poster.repository;

import java.util.ArrayList;
import java.util.List;

import poster.model.*;

public class FindPostRepository {
    public static List<Post> findPosts(String termo, List<Post> posters) {
            List<Post> result = new ArrayList<>();
            for (Post post : posters) {
                if (post.getTitle()
                .toString()
                .toLowerCase()
                .contains(termo.toLowerCase())
                || post.getDescription()
                .toString()
                .toLowerCase()
                .contains(termo.toLowerCase())
                || post.getLocation().toString()
                .toLowerCase()
                .contains(termo.toLowerCase())){
                    result.add(post);
                }
            }
            return result;
        }
}