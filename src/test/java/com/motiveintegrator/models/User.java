package com.motiveintegrator.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    String login;
    String password;
    UserRoles role;

    public User(String login, String password, UserRoles role) {
        this.login = login;
        this.password = password;
        this.role = role;
        int i=0;
    }

    public UserRoles getRole(){
        return role;
    }
}
