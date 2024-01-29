package pl.foodoutlet.foodoutlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.foodoutlet.foodoutlet.model.User;
import pl.foodoutlet.foodoutlet.service.AuthService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return authService.signUp(user);
    }

}
