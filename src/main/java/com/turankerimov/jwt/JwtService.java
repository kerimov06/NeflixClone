package com.turankerimov.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {

      private static final String SECRET_KEY = "X+VMmhlzDuSWPHdEEgDS2XbU0a1CEoLRsd5ELxnmesk=";


      //Tokeni yarat
    public String generateToken(UserDetails userDetails) {
      return   Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*2))
                .signWith(getSecretKey(), SignatureAlgorithm.ES256)
                .compact();
    }

    //Tokeni oxu
      public <T> T exportToken(String token, Function<Claims,T> claimsTFunction){
            Claims claims = Jwts.parserBuilder()
                       .setSigningKey(getSecretKey())
                       .build()
                       .parseClaimsJws(token).getBody();
               return claimsTFunction.apply(claims);
      }

        public String getUsernameByToken(String token) {
                return exportToken(token,Claims::getSubject);
        }


        public boolean isTokenValid(String token) {
              Date date = exportToken(token,Claims::getExpiration);
              return new Date().before(date);
        }


      public Key getSecretKey(){
              byte[] key =  Decoders.BASE64.decode(SECRET_KEY);

              return Keys.hmacShaKeyFor(key);
      }
}
