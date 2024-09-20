    package poster.repository;

    import java.util.ArrayList;
    import java.util.List;
    import poster.model.Post;
    import poster.model.Title;
    import user.models.User;

    public class PosterRepository {
        List<Post> posters;

        public PosterRepository() {
            this.posters = new ArrayList<>();
        }

        public void addPost(Post post) {
            if (posters.contains(post)) {
                throw new IllegalArgumentException("POST JÁ EXISTE");
            }
            posters.add(post);
        }

        public void removePost(Post post) {
            if (!posters.contains(post)) {
                throw new IllegalArgumentException("Post não existe");
            }
            posters.remove(post);
        }

        public void update(Post oldPost, Post newPost) {
            int index = posters.indexOf(oldPost);
            if (index != -1) {
                posters.set(index, newPost);
            } else {
                throw new IllegalArgumentException("Post não encontrado");
            }
        }

        public boolean containsPost(Post post) {
            return posters.contains(post);
        }

        public List<Post> findPostsByTitle(String termo) {
            List<Post> result = new ArrayList<>();
            for (Post post : posters) {
                if (post.getTitle()
                .toString()
                .toLowerCase()
                .contains(termo.toLowerCase()) 
                ||post.getDescription().toString()
                .toLowerCase()
                .contains(termo.toLowerCase())) {
                    result.add(post);
                }
            }
            return result;
        }

        public List<Post> getAllPosts() {
            return posters;
        }

        public void buy(Post post) {
            int index = posters.indexOf(post);
            if (index != -1) {
                Post postBuy = posters.get(index);
                postBuy.setSold(true);
                posters.set(index, postBuy);
            } else {
                throw new IllegalArgumentException("Post não encontrado para venda");
            }
        }

        public List<Post> getPostsByUser(User user) {
            List<Post> userPosts = new ArrayList<>();
            for (Post post : posters) {
                if (post.getUsername().equals(user)) {
                    userPosts.add(post);
                }
            }
            return userPosts;
    }
}