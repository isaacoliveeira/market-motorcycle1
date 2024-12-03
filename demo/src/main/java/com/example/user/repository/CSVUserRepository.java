package com.example.user.repository;
import com.example.user.model.*;

import java.io.*;

public class CSVUserRepository {
    private static UserRepository users;

    public static void exportar() {
        users = UserRepository.getInstance();
        try {
            OutputStream fos = new FileOutputStream("user.csv");
            Writer osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("name; username; password");
            bw.newLine();

            for(User user : users.getAllUsers()){
                String escreveUser = user.getName() + ";" + user.getUsername() + ";" + user.getPassword() + ";";
                bw.write(escreveUser);

            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void importar() throws Exception {
        try {
            InputStream is = new FileInputStream("user.csv");
            Reader reader = new InputStreamReader(is);
            BufferedReader bufReader = new BufferedReader(reader);
            String line = null;

            bufReader.readLine();
            while ((line = bufReader.readLine()) != null) {
                String[] data = line.split(";");
                ProfileName name = new ProfileName(data[0]);
                ProfileUsername username = new ProfileUsername(data[1]);
                ProfilePassword password = new ProfilePassword(data[2]);
                
                User user1 = new User(name, username, password);
                users.addUser(user1);
                bufReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
