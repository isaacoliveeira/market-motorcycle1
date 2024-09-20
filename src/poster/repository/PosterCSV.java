package poster.repository;
import poster.model.Description;
import poster.model.Location;
import poster.model.Post;
import poster.model.Price;
import poster.model.Title;
import user.models.ProfileUsername;
import user.models.User;

import java.io.*;

public class PosterCSV {
    private static final PosterRepository posters = PosterRepository.getInstance();

    public static void exportar() {
        try {
            OutputStream fos = new FileOutputStream("poster.csv");
            Writer osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("title, price, location, description, username");

            for (Post post : posters.getAllPosts()) {
                String escrevePost = post.getTitle() + ";" + post.getPrice()+ ";" + post.getLocation() + ";" + post.getDescription();
                bw.newLine();
                bw.write(escrevePost);
            }
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importar() {
        try {
            InputStream is = new FileInputStream("poster.csv");
            Reader reader = new InputStreamReader(is);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = null;

            bufReader.readLine();
            while ((line = bufReader.readLine()) != null) {
                String[] data = line.split(";");
                Title title = new Title(data[0]);
                Price price = new Price(3);
                Location local = new Location(data[2]);
                Description description = new Description(data[3]);
                ProfileUsername username = new ProfileUsername(data[4]);

                Post post = new Post(title, price, local, description, username);
                posters.addPost(post);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}