package com.example.LearningSpring.Util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JwtProvider {
    @Value("${security.secret-key}")
    private String secretKey ; // TODO : move to app.yml

    @Value("${security.expiration}")
    private Long expiration;

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails); //istemirse ancaq user details olsun deye
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {

        return Jwts.builder()
                 .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) //millise gore 1000 = 1san(24 - 1gun)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private SecretKey getSignKey() {
        byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T extractClaim(String token, Function<Claims , T> claimsFunction){
        Claims claims = extractAllClaims(token);
        return claimsFunction.apply(claims);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    public String extractUsername(String token) {
        // extractClaim(token, (claims) -> claims.getSubject());
        return extractClaim(token, Claims::getSubject);
        // Claims::getSubject = (claims) -> claims.getSubject()
    }

    public boolean isValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        boolean isUsernameEquals = Objects.equals(username, userDetails.getUsername());
        boolean isExpired = isExpired(token);

        return isUsernameEquals && !isExpired; // sorus
    }
    private boolean isExpired(String token) {
        Date expirationDate = extractExpiration(token);
        Date now = new Date(); // default olaraq hal hazirki vaxti goturur
        return expirationDate.before(now);
        //date now  -> true
        // now date -> false
    }
}
