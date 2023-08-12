package org.example.dao;

import jakarta.persistence.*;

@Entity
@Table(name= "tabelauser")

public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username",unique = true)
    private String userName;
    @Column(name = "role")
    private String Role;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public User(Long userId, String userName, String role) {
        this.userId = userId;
        this.userName = userName;
        Role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
    public User () {

    }
}
