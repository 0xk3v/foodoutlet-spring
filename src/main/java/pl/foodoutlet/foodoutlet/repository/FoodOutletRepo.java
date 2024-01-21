package pl.foodoutlet.foodoutlet.repository;

import org.springframework.data.repository.CrudRepository;

import pl.foodoutlet.foodoutlet.model.FoodOutlet;

public interface FoodOutletRepo extends CrudRepository<FoodOutlet, Integer> {

}
