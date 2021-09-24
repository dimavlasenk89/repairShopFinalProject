package model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    private int id;
    private String login;
    private transient String password;
    private int bill;

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

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=?" + id + '?' +
                ", login='" + login + '\'' +
                ", password=." + password + '.' +
                ", bill=!" + bill + '!' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && bill == customer.bill && login.equals(customer.login) && password.equals(customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, bill);
    }
}
