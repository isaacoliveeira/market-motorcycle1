package poster.repository;
import poster.model.*;
import user.model.ProfileUsername;

import java.io.*;

public class PosterCSV {
    private static PosterRepository posters;

    public static void exportar() {
        posters = PosterRepository.getInstance();
        try {
            OutputStream fos = new FileOutputStream("poster.csv");
            Writer osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("title; price; location; description; username");

            for (Post post : posters.getAllPosts()) {
                String escrevePost = post.getTitle().getTitle() + ";" + post.getPrice().getPrice() + ";" + post.getLocation().getLocation() + ";" + post.getDescription().getDescription() + ";" + post.getUsername().getUsername();
                bw.newLine();
                bw.write(escrevePost);
            }
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importar() {
        posters = PosterRepository.getInstance();
        try {
            InputStream is = new FileInputStream("poster.csv");
            Reader reader = new InputStreamReader(is);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = null;

            bufReader.readLine();
            while ((line = bufReader.readLine()) != null) {
                String[] data = line.split(";");
                Title title = new Title(data[0]);
                Price price = new Price(Integer.parseInt(data[1]));
                Location local = new Location(data[2]);
                Description description = new Description(data[3]);
                ProfileUsername username = new ProfileUsername(data[4]);

                Post post = new Post(title, price, local, description, username);
                posters.addPost(post);
            }
        bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}