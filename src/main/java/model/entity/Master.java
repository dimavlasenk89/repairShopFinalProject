package model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Master implements Serializable {
    public Master(int id, String login, String password, int rating) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rating = rating;
    }

    private int id;
    private String login;
    private transient String password;
    private int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return id == master.id && rating == master.rating && Objects.equals(login, master.login) && Objects.equals(password, master.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, rating);
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rating=" + rating +
                '}';
    }
}
