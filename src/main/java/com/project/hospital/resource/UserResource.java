package com.project.hospital.resource;

import com.project.hospital.service.implementation.UserServiceImpl;
import com.project.hospital.user.Response;
import com.project.hospital.user.User;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Map;

import static java.util.Map.of;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserServiceImpl userService;

    @GetMapping("/list")
    public ResponseEntity<Response> getUsers() throws InterruptedException{
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
    public ResponseEntity<Response> saveUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(
          Response.builder()
                  .timeStamp(now())
                  .data(Map.of("user", userService.create(user)))
                  .message("User created")
                  .status(CREATED)
                  .statusCode(CREATED.value())
                  .build()
        );
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
