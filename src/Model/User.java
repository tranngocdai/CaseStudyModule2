package Model;

import java.io.Serializable;

public class User implements Serializable {
    private int userID;
    private String password, userName;

    public User() {
    }

    public User(int userID, String password, String userName) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
