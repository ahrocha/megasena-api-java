package br.com.hurpia.megasena.api.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Component
public class JwtUtil {
    private static final String SECRET = System.getProperty("JWT_SECRET", "default-secret"); // Fallback if env is missing
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public String extractEmail(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
        return jwt.getSubject();
    }

    public boolean isTokenValid(String token, String userEmail) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject().equals(userEmail) && !jwt.getExpiresAt().before(new Date());
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
