package com.user.service;

import com.user.repository.UserRepository;
import com.user.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public Response addUser(User user) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("Request Failed", HttpStatus.BAD_REQUEST, null);
    }

    public Response getUser(int id) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("Request Failed", HttpStatus.BAD_REQUEST, null);
    }

    public Response updateUser(User user) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("Request Failed", HttpStatus.BAD_REQUEST, null);
    }

    public Response deleteUser(int id) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("Request Failed", HttpStatus.BAD_REQUEST, null);
    }
}
