package com.user.service;

import com.user.repository.UserRepository;
import com.user.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public Response addUser(User user) {
        try {
            userRepository.save(user);
            return new Response("User Added Successfully", HttpStatus.CREATED, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("Request Failed", HttpStatus.BAD_REQUEST, null);
    }

    public Response getUser(int id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return new Response("User Record Found", HttpStatus.FOUND, user.get());
            } else {
                return new Response("User Record Not Found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("Request Failed", HttpStatus.BAD_REQUEST, null);
    }

    public Response updateUser(User user) {
        try {
            userRepository.save(user);
            return new Response("User Updated Successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("Request Failed", HttpStatus.BAD_REQUEST, null);
    }

    public Response deleteUser(int id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                userRepository.deleteById(id);
                return new Response("User Deleted Successfully", HttpStatus.OK, null);
            } else {
                return new Response("User Record Not Found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response("Request Failed", HttpStatus.BAD_REQUEST, null);
    }
}
