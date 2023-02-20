package hua.group42.rentCar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class User { // to user den einai entity, mono to controller tou xrisimopoieite.
    private String username;
    private String password;

    public User(String username, String encode, List<GrantedAuthority> authorities) {
    }

    public User() {

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

}
