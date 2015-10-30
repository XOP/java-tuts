import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import user.*;


public class Main {

    private static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        User userMale = new User("Foo", true);
        ArrayList<Login> userMaleLogins = userMale.getLoginData();
        userMaleLogins.add(new Login(Date.from(Instant.now()), "100.100.0.100"));
        userMaleLogins.add(new Login(Date.from(Instant.now()), "110.100.0.100"));

        User userFemale = new User("Bar", false);
        ArrayList<Login> userFemaleLogins = userFemale.getLoginData();
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

        for(User user: users){
            System.out.println(user.getName() + " - last login date - " + user.getLoginData().get(0).getDate());
        }
    }
}
