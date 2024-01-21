package pl.foodoutlet.foodoutlet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pl.foodoutlet.foodoutlet.model.FoodOutlet;

@RestController
public class OutletController {

    private List<FoodOutlet> mock = List.of(new FoodOutlet("PizzaHut", "Poznan", "American", "14:00-22:00"));

    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/outlets")
    public List<FoodOutlet> get() {
        return mock;
    }

    @GetMapping("/outlets/{id}")
    public FoodOutlet get(@PathVariable String id) {

        try {
            FoodOutlet outlet = mock.get(Integer.parseInt(id));

            if (outlet == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }

            return outlet;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
