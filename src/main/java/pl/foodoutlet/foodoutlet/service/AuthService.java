package pl.foodoutlet.foodoutlet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.foodoutlet.foodoutlet.model.User;
import pl.foodoutlet.foodoutlet.repository.UserRepo;

@Service
public class AuthService {

    @Autowired
    public UserRepo userRepo;

    private Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(32, 64, 1, 15 * 1024, 2);

    public User signUp(User user) {

        String unHashedPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(unHashedPassword));
        return userRepo.save(user);
    }

    // public User signIn(User user){
    // return userRepo.findOne(user);
    // }

}
