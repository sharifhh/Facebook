package ps.exalt.facebook.Util.Network.API;

import java.sql.Date;

/**
 * Created by Sharif on 7/26/2017.
 */

public class User {
    UserID id;
    String password;
    long timeCreation;
    String firstName;
    String lastName;
    String gender;
    Date birthday;
    byte[] picture;

    public UserID getId() {
        return id;
    }

    public void setId(UserID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(long timeCreation) {
        this.timeCreation = timeCreation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
