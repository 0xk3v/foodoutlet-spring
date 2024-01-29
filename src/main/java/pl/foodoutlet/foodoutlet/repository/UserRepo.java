package pl.foodoutlet.foodoutlet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.foodoutlet.foodoutlet.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}