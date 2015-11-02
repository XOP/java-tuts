package user;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private boolean male;
    private List<Login> loginData;

    public User(String name, boolean male) {
        this.name = name;
        this.male = male;
        this.loginData = new ArrayList<Login>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return male;
    }

    public void setLoginData(ArrayList<Login> loginData) {
        this.loginData = loginData;
    }

    public List<Login> getLoginData() {
        return loginData;
    }
}