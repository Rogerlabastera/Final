package com.labasterasign.upsign.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "/Users")
public class User {

    @Id
    private String id;
    private String email;
    private String username;
    private String password;
    private String confirmPass;
    private Collection<Object> orders;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public void addOrder(OrderItem item) {
    }

    public Collection<Object> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Object> orders) {
        this.orders = orders;
    }
}