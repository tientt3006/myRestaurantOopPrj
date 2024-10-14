
// Dung xoa cac file co phan dau Experiment_ nhe, de thu nghiem da
package com.nolaneg.myrestaurantprj.db.entity;

public class Experiment_User {
    private int id;
    private String username;
    private String passwordHash;

    public Experiment_User() {}

    public Experiment_User(int id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}

