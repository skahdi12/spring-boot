package com.ebaykr.controller;

import com.ebaykr.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final List<User> userList = new ArrayList<User>();
    {
        userList.add(new User(1, "jiahn01", "jiahn01@ebay.com", "remine", new Date()));
        userList.add(new User(2, "jiahn02", "jiahn02@ebay.com", "restart", new Date()));
        userList.add(new User(3, "jiahn03", "jiahn03@ebay.com", "nine", new Date()));
        userList.add(new User(4, "jiahn04", "jiahn04@ebay.com", "namu", new Date()));
    }

    @RequestMapping(value = "/user/{userNo}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserInfo(@PathVariable int userNo) {
        User user = userList.get(userNo);
        return new ResponseEntity<User>(user, OK);
    }
}
