package Tandon.Instagram.controller;

import Tandon.Instagram.model.User;
import Tandon.Instagram.service.UserService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/addUser")
    public ResponseEntity saveUser(@RequestBody String userData) {
        User user = setUser(userData);
        int userId = service.saveUser(user);
        return new ResponseEntity("user saved with id- " + userId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getUser")
    public ResponseEntity<String> getUser(@Nullable @RequestParam(required = false, defaultValue = "") String userId) {
        JSONArray userDetails = service.getUser(userId);
        return new ResponseEntity(userDetails.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/updateUser/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody String userData) {
        User user = setUser(userData);
        service.updateUser(user, userId);
        return new ResponseEntity("user updated", HttpStatus.OK);
    }

    private User setUser(String userData) {
        JSONObject jsonObject = new JSONObject(userData);
        User user = new User();
        user.setAge(jsonObject.getInt("age"));
        user.setEmail(jsonObject.getString("email"));
        user.setFirstName(jsonObject.getString("firstName"));
        user.setLastName(jsonObject.getString("lastName"));
        user.setPhoneNumber(jsonObject.getString("phoneNumber"));
        return user;
    }
}
