package com.example.shopping_api.controller.web;



import com.example.shopping_api.Service.UserService;
import com.example.shopping_api.model.Request.LoginRequest;
import com.example.shopping_api.model.Request.SignUpRequest;
import com.example.shopping_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private UserService userService;


    @PostMapping( value="/login", consumes = {"application/xml","application/json"})
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest request) {
        Boolean result = userService.isAuthenticated(request.name,request.password);
        return ResponseEntity.ok(result);
    }
    @PostMapping( value="/signup", consumes = {"application/xml","application/json"})
    public ResponseEntity<Boolean> signup(@RequestBody SignUpRequest request) {
        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setFullName(request.fullName);
        user.setPassword(request.password);
        user.setPhone(request.phone);
        Boolean result = userService.signUp(user);
        return ResponseEntity.ok(result);
    }

}

