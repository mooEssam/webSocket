package com.example.wschat.controller;

import java.util.List;

import com.example.wschat.model.ActiveUser;
import com.example.wschat.model.Storage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @GetMapping("/active")
    public List<ActiveUser> list(){
        return Storage.activeUserList;
    }
}
