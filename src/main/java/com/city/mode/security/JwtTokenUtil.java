package com.city.mode.security;


import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {




private  static final String SECRETE_KEY="AESJWT";
private static final long VALIDATITY_DURATION_MM=3600000;


public String generateToken(UserDetails userDetails) {

    Map<String, Object> claims = new HashMap<>();
    return Jwts.builder()
            .setClaims(claims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis()+VALIDATITY_DURATION_MM))
            .signWith(SignatureAlgorithm.HS256,SECRETE_KEY)
            .compact();
}


public Boolean validateToken(String token , UserDetails userDetails){

    final String username=extractUsername(token);
return(username.equals(userDetails.getUsername() )&& !isTokenExpired(token));
}


public Boolean isTokenExpired(String token){

return extractExpiration(token).before(new Date());

}

public Date extractExpiration(String token){

return Jwts.parser().setSigningKey(SECRETE_KEY).parseClaimsJws(token).getBody().getExpiration();
}


public String extractUsername(String token ){

return Jwts.parser().setSigningKey(SECRETE_KEY).parseClaimsJws(token).getBody().getSubject();

}


}
