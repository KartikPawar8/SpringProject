///*
//package com.city.mode;
//
//public class dummy {
//    src/main/java/com/example/jwtsecurity
//    ├── controller
//    │   └── AuthController.java
//    ├── model
//    │   └── User.java
//    ├── repository
//    │   └── UserRepository.java
//    ├── security
//    │   ├── JwtTokenFilter.java
//    │   ├── JwtTokenUtil.java
//    │   └── SecurityConfig.java
//    ├── service
//    │   └── UserDetailsServiceImpl.java
//    ├── JwtSecurityApplication.java
//    └── payload
//        ├── AuthRequest.java
//        ├── AuthResponse.java
//        └── RegisterRequest.java
//
//
//
//
//package com.example.jwtsecurity;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//    @SpringBootApplication
//    public class JwtSecurityApplication {
//
//        public static void main(String[] args) {
//            SpringApplication.run(JwtSecurityApplication.class, args);
//        }
//    }
//
//
//    package com.example.jwtsecurity.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//    @Entity
//    @Table(name = "users")
//    public class User {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        @Column(unique = true, nullable = false)
//        private String username;
//
//        @Column(nullable = false)
//        private String password;
//
//        @ElementCollection(fetch = FetchType.EAGER)
//        @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//        @Column(name = "role")
//        private Set<String> roles;
//
//        // Constructors, getters, setters
//    }
//
//
//
//
//
//
//    package com.example.jwtsecurity.repository;
//
//import com.example.jwtsecurity.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//    @Repository
//    public interface UserRepository extends JpaRepository<User, Long> {
//        Optional<User> findByUsername(String username);
//    }
//
//
//    package com.example.jwtsecurity.service;
//
//import com.example.jwtsecurity.model.User;
//import com.example.jwtsecurity.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//    @Service
//    public class UserDetailsServiceImpl implements UserDetailsService {
//
//        @Autowired
//        private UserRepository userRepository;
//
//        @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            User user = userRepository.findByUsername(username)
//                    .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//            return new org.springframework.security.core.userdetails.User(
//                    user.getUsername(), user.getPassword(), getAuthorities(user));
//        }
//
//        private Set<GrantedAuthority> getAuthorities(User user) {
//            Set<GrantedAuthority> authorities = new HashSet<>();
//            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
//            return authorities;
//        }
//    }
//---------------------------
//
//        package com.example.jwtsecurity.security;
//
//import io.jsonwebtoken.*;
//import org.springframework.stereotype.Component;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//    @Component
//    public class JwtTokenUtil {
//
//        private static final String SECRET_KEY = "your_secret_key"; // Replace with a strong secret key
//        private static final long VALIDITY_DURATION_MS = 3600000; // 1 hour validity
//
//        public String generateToken(UserDetails userDetails) {
//            Map<String, Object> claims = new HashMap<>();
//            return Jwts.builder()
//                    .setClaims(claims)
//                    .setSubject(userDetails.getUsername())
//                    .setIssuedAt(new Date())
//                    .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_DURATION_MS))
//                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                    .compact();
//        }
//
//        public Boolean validateToken(String token, UserDetails userDetails) {
//            final String username = extractUsername(token);
//            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//        }
//
//        private Boolean isTokenExpired(String token) {
//            return extractExpiration(token).before(new Date());
//        }
//
//        private Date extractExpiration(String token) {
//            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
//        }
//
//        public String extractUsername(String token) {
//            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
//        }
//    }
//-----------------------------------
//
//        package com.example.jwtsecurity.security;
//
//import io.jsonwebtoken.*;
//import org.springframework.stereotype.Component;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//    @Component
//    public class JwtTokenUtil {
//
//        private static final String SECRET_KEY = "your_secret_key"; // Replace with a strong secret key
//        private static final long VALIDITY_DURATION_MS = 3600000; // 1 hour validity
//
//        public String generateToken(UserDetails userDetails) {
//            Map<String, Object> claims = new HashMap<>();
//            return Jwts.builder()
//                    .setClaims(claims)
//                    .setSubject(userDetails.getUsername())
//                    .setIssuedAt(new Date())
//                    .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_DURATION_MS))
//                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                    .compact();
//        }
//
//        public Boolean validateToken(String token, UserDetails userDetails) {
//            final String username = extractUsername(token);
//            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//        }
//
//        private Boolean isTokenExpired(String token) {
//            return extractExpiration(token).before(new Date());
//        }
//
//        private Date extractExpiration(String token) {
//            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
//        }
//
//        public String extractUsername(String token) {
//            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
//        }
//    }
//
//    ------------------------------------------
//
//
//            package com.example.jwtsecurity.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import io.jsonwebtoken.ExpiredJwtException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//    @Component
//    public class JwtTokenFilter extends OncePerRequestFilter {
//
//        @Autowired
//        private UserDetailsService userDetailsService;
//
//        @Autowired
//        private JwtTokenUtil jwtTokenUtil;
//
//        @Override
//        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//                throws ServletException, IOException {
//
//                final String requestTokenHeader = request.getHeader("Authorization");
//
//            String username = null;
//            String jwtToken = null;
//
//            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//                jwtToken = requestTokenHeader.substring(7);
//                try {
//                    username = jwtTokenUtil.extractUsername(jwtToken);
//                } catch (ExpiredJwtException e) {
//                    System.out.println("JWT token has expired");
//                } catch (Exception e) {
//                    System.out.println("Unable to parse JWT token");
//                }
//            }
//
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                            userDetails, null, userDetails.getAuthorities());
//                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//                }
//            }
//
//            chain.doFilter(request, response);
//        }
//    }
//--------------------------
//
//
//        package com.example.jwtsecurity.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//    @Configuration
//    @EnableWebSecurity
//    public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Autowired
//        private UserDetailsService userDetailsService;
//
//        @Autowired
//        private JwtTokenFilter jwtTokenFilter;
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/api/auth/**").permitAll() // Allow authentication endpoints
//                    .anyRequest().authenticated() // Require authentication for other endpoints
//                    .and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Use stateless sessions
//
//            http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        }
//
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Bean
//        @Override
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//    }
//-------------------------
//
//        package com.example.jwtsecurity.controller;
//
//import com.example.jwtsecurity.payload.AuthRequest;
//import com.example.jwtsecurity.payload.AuthResponse;
//import com.example.jwtsecurity.payload.RegisterRequest;
//import com.example.jwtsecurity.security.JwtTokenUtil;
//import com.example.jwtsecurity.service.UserDetailsServiceImpl;
//import com.example.jwtsecurity.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//    @RestController
//    @RequestMapping("/api/auth")
//    public class AuthController {
//
//        @Autowired
//        private AuthenticationManager authenticationManager;
//
//        @Autowired
//        private JwtTokenUtil jwtTokenUtil;
//
//        @Autowired
//        private UserDetailsServiceImpl userDetailsService;
//
//        @Autowired
//        private UserService userService;
//
//        @PostMapping("/login")
//        public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
//            try {
//                authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//            } catch (BadCredentialsException e) {
//                throw new Exception("Incorrect username or password", e);
//            }
//
//            final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
//            final String token = jwtTokenUtil.generateToken(userDetails);
//            return ResponseEntity.ok(new AuthResponse(token));
//        }
//
//        @PostMapping("/register")
//        public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
//            Set<String> roles = new HashSet<>();
//            roles.add("USER"); // Default role
//            userService.registerNewUser(registerRequest.getUsername(), registerRequest.getPassword(), roles);
//            return ResponseEntity.ok("User registered successfully");
//        }
//    }
//-------------------------
//
//        package com.example.jwtsecurity.payload;
//
//    public class AuthRequest {
//        private String username;
//        private String password;
//
//        // Getters and setters
//    }
//-----------------
//        package com.example.jwtsecurity.payload;
//
//    public class AuthResponse {
//        private String token;
//
//        public AuthResponse(String token) {
//            this.token = token;
//        }
//
//        // Getter
//        public String getToken() {
//            return token;
//        }
//    }
//-------------------
//        package com.example.jwtsecurity.payload;
//
//    public class RegisterRequest {
//        private String username;
//        private String password;
//
//        // Getters and setters
//    }
//
//--------------------
//        package com.example.jwtsecurity.service;
//
//import com.example.jwtsecurity.model.User;
//import com.example.jwtsecurity.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//    @Service
//    public class UserService {
//
//        @Autowired
//        private UserRepository userRepository;
//
//        @Autowired
//        private PasswordEncoder passwordEncoder;
//
//        public void registerNewUser(String username, String password, Set<String> roles) {
//            User user = new User();
//            user.setUsername(username);
//            user.setPassword(passwordEncoder.encode(password));
//            user.setRoles(roles);
//            userRepository.save(user);
//        }
//    }
//------------------------
//
//    <dependencies>
//    <!-- Spring Boot Starter Web -->
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-web</artifactId>
//    </dependency>
//
//    <!-- Spring Boot Starter Security -->
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-security</artifactId>
//    </dependency>
//
//    <!-- Spring Boot Starter Data JPA -->
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-data-jpa</artifactId>
//    </dependency>
//
//    <!-- JWT -->
//    <dependency>
//        <groupId>io.jsonwebtoken</groupId>
//        <artifactId>jjwt</artifactId>
//        <version>0.9.1</version>
//    </dependency>
//
//    <!-- PostgreSQL Driver -->
//    <dependency>
//        <groupId>org.postgresql</groupId>
//        <artifactId>postgresql</artifactId>
//        <scope>runtime</scope>
//    </dependency>
//
//    <!-- Lombok -->
//    <dependency>
//        <groupId>org.projectlombok</groupId>
//        <artifactId>lombok</artifactId>
//        <optional>true</optional>
//    </dependency>
//
//    <!-- Spring Boot DevTools -->
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-devtools</artifactId>
//        <scope>runtime</scope>
//    </dependency>
//
//    <!-- Spring Boot Starter Test -->
//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-test</artifactId>
//        <scope>test</scope>
//    </dependency>
//</dependencies>
//
//
//
//
//
//
//
//
//}
//*/
