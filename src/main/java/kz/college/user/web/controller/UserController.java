package kz.college.user.web.controller;

import io.swagger.annotations.ApiOperation;
import kz.college.user.model.User;
import kz.college.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping( "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @ApiOperation("Create user")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User model) {
        log.debug("REST request to save user : {}", model);
        User result = service.saveUser(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @ApiOperation("Update user")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User model) {
        log.debug("REST request to update user : {}, {}", id,  model);
        User result = service.updateUser(id, model);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation("Get user by id")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        log.debug("REST request to get user : {}", id);
        User result = service.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation("Delete user")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        log.debug("REST request to get user : {}", id);
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation("Get all users")
    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        log.debug("REST request to get users");
        List<User> result = service.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
