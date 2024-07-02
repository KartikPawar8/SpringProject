package com.city.mode.security;


import com.city.mode.service.UserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtTokenFilter extends OncePerRequestFilter {




    @Autowired
private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


final String requestTokenHeader=request.getHeader("Authorization");

String username=null;
String  jwtToken=null;



if(requestTokenHeader !=null &&requestTokenHeader.startsWith("Bearer "));
     jwtToken=requestTokenHeader.substring(7);

try{

username=jwtTokenUtil.extractUsername(jwtToken);


}catch (ExpiredJwtException e){
    System.out.println("JWT token has expired");
}catch (Exception e){
    e.printStackTrace();
}



if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

    UserDetails userDetails=userDetailsService.loadUserByUsername(username);

    if (jwtTokenUtil.validateToken(jwtToken,userDetails)){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(
userDetails,null,userDetails.getAuthorities());
usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);



    }

}
        filterChain.doFilter(request, response);


    }





}
