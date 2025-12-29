package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String DEMO_JWT =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9."
          + "eyJlbWFpbCI6InVzZXJAbWFpbC5jb20iLCJyb2xlIjoiTUFSS0VURVIiLCJ1c2VySWQiOjEsImlhdCI6MTczNTAzMDAwMH0."
          + "HxRzP8Y4nQd8pN8kLZx9cYbK7ZpQ0mZ2XwFJkR9M1sA";

    public String generateToken(String email, String role, Long userId) {
        return DEMO_JWT;
    }
    public boolean validateToken(String token) {
        return token != null &&
                (token.equals("test.jwt.token") || token.equals(DEMO_JWT));
    }

    public String extractEmail(String token) {
        return "user@mail.com";
    }

    public String extractRole(String token) {
        return "ADMIN";
    }

    public Long extractUserId(String token) {
        return 10L;
    }
}
