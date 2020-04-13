package io.javabrains.springsecurityjwt.models;

public class AuthenticationRespose {
    private final String jwt;

    public AuthenticationRespose(String jwt) {
        this.jwt = jwt;
    }


    public String getJwt() {
        return jwt;
    }
}
