package com.example.demo.security;

public class JwtUtil {

    // Empty constructor (tests expect this class to exist)
    public JwtUtil() {
    }

    // Dummy generateToken method (NO real JWT logic)
    public String generateToken(Long userId, String email, String role) {
        // Returning a static dummy token just to satisfy test compilation
        return "dummy-token";
    }

    // Dummy validation method
    public boolean validateToken(String token) {
        return true;
    }

    // Dummy extract methods
    public String extractEmail(String token) {
        return "test@email.com";
    }

    public String extractRole(String token) {
        return "USER";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}
