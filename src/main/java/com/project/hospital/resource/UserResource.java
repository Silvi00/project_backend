package com.project.hospital.resource;

import com.project.hospital.repo.UserRepo;
import com.project.hospital.service.implementation.UserServiceImpl;
import com.project.hospital.user.Response;
import com.project.hospital.user.User;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.Map.of;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserServiceImpl userService;
    @Autowired
    UserRepo userRepo;

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
