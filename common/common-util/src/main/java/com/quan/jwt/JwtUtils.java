package com.quan.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 全俊
 */
@Component
public class JwtUtils {
    private String key="asd855643";
    public String createJwt(String username) {
        long now = System.currentTimeMillis();
        long exp = now + 1000 * 60 * 30;
        JwtBuilder builder = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key)
                .setExpiration(new Date(exp));
        return builder.compact();
    }

    public String parseJwtTest(String compactJws) {
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(compactJws).getBody();
        return claims.getSubject();
    }
}