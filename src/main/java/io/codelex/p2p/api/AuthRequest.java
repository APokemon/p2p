package io.codelex.p2p.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthRequest {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 6,max = 12)
    private String password;

    @JsonCreator
    public AuthRequest(@JsonProperty("email") String email,
                       @JsonProperty("password")String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
