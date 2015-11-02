import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import user.*;


public class Main {

    private static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        User userMale = new User("Foo", true);
        List<Login> userMaleLogins = userMale.getLoginData();
        userMaleLogins.add(new Login(Date.from(Instant.now()), "100.100.0.100"));
        userMaleLogins.add(new Login(Date.from(Instant.now()), "110.100.0.100"));

        User userFemale = new User("Bar", false);
        List<Login> userFemaleLogins = userFemale.getLoginData();
        userFemaleLogins.add(new Login(Date.from(Instant.now()), "200.100.0.100"));
        userFemaleLogins.add(new Login(Date.from(Instant.now()), "110.200.0.100"));

        users.add(userMale);
        users.add(userFemale);

        return users;
    }

    private static void sortLogins(ArrayList<User> users) {
        for(User user: users){
            Collections.sort(user.getLoginData(), (o1, o2) -> o1.getDate().compareTo(o2.getDate()));
        }
    }

    public static void main(String[] args) {
        ArrayList<User> users = getUsers();
        sortLogins(users);

        StringBuilder output = new StringBuilder();

        for(User user: users){
            output
                    .append(user.getName())
                    .append(" - last login date - ")
                    .append(user.getLoginData().get(0).getDate())
                    .append("\n")
                    ;
        }

        try (PrintWriter file = new PrintWriter("out.txt", "utf-8")) {
            file.append(output);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
