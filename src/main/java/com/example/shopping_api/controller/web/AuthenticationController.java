package com.example.shopping_api.controller.web;



import com.example.shopping_api.Service.UserService;
import com.example.shopping_api.model.Request.LoginRequest;
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
        System.out.println("Login nha");
        Boolean result = userService.isAuthenticated(request.name,request.password);
        return ResponseEntity.ok(result);
    }

}

