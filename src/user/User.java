package user;

import java.util.ArrayList;

public class User {
    public String name;
    public boolean male;
    public ArrayList loginData;

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

    public void setLoginData(ArrayList loginData) {
        this.loginData = loginData;
    }

    public ArrayList getLoginData() {
        return loginData;
    }
}