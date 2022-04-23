package com.introidx.lhc_backend.resources;

import com.introidx.lhc_backend.domain.User;
import com.introidx.lhc_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PRAKASH RANJAN on 11-04-2022
 */

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        String name = (String) userMap.get("name");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        String role = (String) userMap.get("role");
        User user = userService.registerUser(name, email , password , role);
        Map<String , String> map = new HashMap<>();
        map.put("message" , "registered Successfully");
        return new ResponseEntity<>(map,HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(email, password);
        Map<String , String> map = new HashMap<>();
        map.put("message" , "Loggedin Successful");
        return new ResponseEntity<>(map, HttpStatus.OK);



    }
}
