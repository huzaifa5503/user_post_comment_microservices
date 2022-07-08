package com.user.controller;

import com.user.response.Response;
import com.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public Response addUser(@RequestBody(required = true) User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public Response getUser(@RequestParam(name = "id") int id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public Response updateUser(@PathVariable(name = "id") int id, @RequestBody(required = true) User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable(name = "id") int id) {
        return userService.deleteUser(id);
    }

}
