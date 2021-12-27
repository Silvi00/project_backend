package com.project.hospital.resource;

import com.project.hospital.payload.request.LoginRequest;
import com.project.hospital.payload.response.JwtResponse;
import com.project.hospital.repo.UserRepo;
import com.project.hospital.security.jwt.JwtUtils;
import com.project.hospital.security.services.UserDetailsImpl;
import com.project.hospital.service.implementation.UserServiceImpl;
import com.project.hospital.user.Response;
import com.project.hospital.user.User;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.Map.of;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Import(SecurityConfig.class)
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private final UserServiceImpl userService;
    @Autowired
    UserRepo userRepo;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getDept(),
                userDetails.getEmail()));
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getUsers() throws InterruptedException{
        TimeUnit.SECONDS.sleep(3); // timpul in care sa apara datele pe ecran
        return ResponseEntity.ok(
          Response.builder()
                  .timeStamp(now())
                  .data(Map.of("user", userService.list(30)))
//                  .data(Map.ofEntries(entry("users", userService.list(30))))
                  .message("Users retrieved")
                  .status(OK)
                  .statusCode(OK.value())
                  .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
//        return ResponseEntity.ok(
//          Response.builder()
//                  .timeStamp(now())
//                  .data(Map.of("user", userService.create(user)))
//                  .message("User created")
//                  .status(CREATED)
//                  .statusCode(CREATED.value())
//                  .build()
//        );

        try{
            System.out.println("sunt in save");
            User usr = userRepo
                    .save(new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getDept()));
            return new ResponseEntity<>(usr, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
          Response.builder()
                  .timeStamp(now())
                  .data(of("user", userService.get(id)))
                  .message("User retrieved")
                  .status(OK)
                  .statusCode(OK.value())
                  .build()
        );
    }

}
