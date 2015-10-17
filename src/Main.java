import java.util.ArrayList;

import user.User;


public class Main {

    private static ArrayList<String> logins = new ArrayList<>();
    private static User user = new User();

    public static void addLoginInfo() {
        logins.add("1 - 12.10.2015 || 13:01");
        logins.add("2 - 12.10.2015 || 18:32");
        logins.add("3 - 13.10.2015 || 09:15");
    }

    public static void addUserInfo() {
        user.setName("Foo Bar");
        user.setMale(true);
        user.setLoginData(logins);
    }

    public static void main(String[] args) {
        addLoginInfo();
        addUserInfo();

        String userData;
        userData = "" +
                "User Name: " + user.getName() + "\n" +
                "User Gender: " + (user.isMale() ? "Male" : "Female") + "\n" +
                "User Login Data: TODO" + "\n"
                ;

        System.out.print(userData);
    }
}
