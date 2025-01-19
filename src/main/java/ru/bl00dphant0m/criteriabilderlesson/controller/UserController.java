package ru.bl00dphant0m.criteriabilderlesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bl00dphant0m.criteriabilderlesson.model.User;
import ru.bl00dphant0m.criteriabilderlesson.service.UserService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsersSortedByAge(@RequestParam(required = false) String sort) {
        return ResponseEntity.ok(userService.findAllSortedByParam(sort));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
