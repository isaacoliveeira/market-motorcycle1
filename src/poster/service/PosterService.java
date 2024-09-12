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
        public void addPost(Title title, Price price, Location location, Descrition descrition) {
            Post post = new Post(title, price, location, descrition);
            posterRepository.addPost(post);
        }

        @Override
        public void removePost(Title title, Price price, Location location) {
            Post post = new Post(title, price, location);
            // faz uma comparação entre o post criado agroa, e o post que já existe na lista
            // removendo o que contem valores iguais
            posterRepository.removePost(post);
        }

        @Override
        public void updatePost(Post oldPost, Post newPost) {
            // ele chama um metodo criado no posterRepository, visto que posterRepository aqui n é uma lista, e nao tem esse metodo;
            if (posterRepository.contains(oldPost)) {
                posterRepository.uptade(oldPost, newPost);
            }
            throw new IllegalArgumentException("Post não foi encontrado");
        }

        @Override
        public void searchByTitle(Title title) {
            return posterRepository.findPostByTitle();
        }

        
    }
