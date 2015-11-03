import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import user.*;
import util.*;


public class Main {

    private static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        User userMale = new User("Foo", true);

        List<Login> userMaleLogins = userMale.getLoginData();
        userMaleLogins.add(new Login(new CustomDate(2015, 10, 10, 12, 0).getDate(), "0.0.0.1"));
        userMaleLogins.add(new Login(new CustomDate(2015, 10, 11, 13, 30).getDate(), "0.0.0.1"));
        userMaleLogins.add(new Login(new CustomDate(2015, 10, 12, 18, 40).getDate(), "0.0.0.2"));
        userMaleLogins.add(new Login(new CustomDate(2015, 10, 13, 11, 20).getDate(), "0.0.0.2"));
        userMaleLogins.add(new Login(new CustomDate(2015, 10, 14, 16, 50).getDate(), "0.0.0.2"));

        users.add(userMale);

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
            output.append("# Name: " + user.getName() + ", ");
            output.append("Gender: ");
            output.append(user.isMale() ? "Male" : "Female");
            output.append("\n\n");

            output.append("## Login dates (all IP addresses): ");
            output.append("\n\n");

            for(int i = 0; i < user.getLoginData().size(); i++){
                LocalDateTime d = user.getLoginData().get(i).getDate();

                output.append("- " + d.format(DateTimeFormatter.ofPattern("d.M.Y - HH:mm")));
                output.append("\n");
            }
        }

        try (PrintWriter file = new PrintWriter("result-1.md", "utf-8")) {
            file.append(output);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
