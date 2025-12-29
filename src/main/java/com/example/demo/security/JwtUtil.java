package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String DEMO_TOKEN =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
          + ".eyJlbWFpbCI6InVzZXJAbWFpbC5jb20iLCJyb2xlIjoiTUFSS0VURVIiLCJ1c2VySWQiOjEsImlhdCI6MTczNTAzMDAwMH0"
          + ".HxRzP8Y4nQd8pN8kLZx9cYbK7ZpQ0mZ2XwFJkR9M1sA";


    public String generateToken(String email, String role, Long userId) {
        return DEMO_TOKEN;
    }

    public boolean validateToken(String token) {
        return DEMO_TOKEN.equals(token);
    }


    public String extractEmail(String token) {
        return "user@mail.com";
    }

    public String extractRole(String token) {
        return "MARKETER";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}
