package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {
        // Dummy token generation (tests mock this)
        return "dummy.jwt.token";
    }

    public boolean validateToken(String token) {
        // Default false, mocked in tests
        return false;
    }

    public String extractEmail(String token) {
        return null;
    }

    public String extractRole(String token) {
        return null;
    }

    public Long extractUserId(String token) {
        return null;
    }
}
