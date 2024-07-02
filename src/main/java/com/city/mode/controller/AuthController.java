package com.city.mode.controller;



import com.city.mode.payload.AuthRequest;
import com.city.mode.payload.AuthResponse;
import com.city.mode.payload.RegisterRequest;
import com.city.mode.security.JwtTokenUtil;
import com.city.mode.service.UserDetailsServiceImpl;
import com.city.mode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


@Autowired
private AuthenticationManager authenticationManager;



     @Autowired
     private UserDetailsServiceImpl userDetailsService;


     @Autowired
     private JwtTokenUtil jwtTokenUtil;


     @Autowired
     private UserService userService;




    @PostMapping("/login")

public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthRequest authRequest)throws Exception{

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username and password",e);

        }


        final UserDetails userDetails=userDetailsService.loadUserByUsername(authRequest.getUsername());

final  String token=jwtTokenUtil.generateToken(userDetails);

return ResponseEntity.ok(new AuthResponse(token));


    }



    @PostMapping("/register")
    public ResponseEntity<?>registerUser(@RequestBody RegisterRequest registerRequest){


Set<String > roles=new HashSet<>();

roles.add("USER");

userService.registerNewUser(registerRequest.getUsername(),registerRequest.getPassword(),roles);

return  ResponseEntity.ok("User registered Successfully");


    }

}
