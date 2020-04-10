package com.binto.springboot.security.jwt;

public interface AuthService {
    String login(String username, String password);
    String refresh(String oldToken);
}
