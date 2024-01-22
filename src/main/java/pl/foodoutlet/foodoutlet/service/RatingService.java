package pl.foodoutlet.foodoutlet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.foodoutlet.foodoutlet.model.FoodOutlet;
import pl.foodoutlet.foodoutlet.model.Rating;
import pl.foodoutlet.foodoutlet.repository.FoodOutletRepo;
import pl.foodoutlet.foodoutlet.repository.RatingRepo;

@Service
public class RatingService {

    @Autowired
    public RatingRepo ratingRepo;

    @Autowired
    public FoodOutletRepo outletRepo;

    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    public Rating getRatingById(Long id) {
        return ratingRepo.findById(id).orElse(null);
    }

    public Rating createRating(int ratingValue, Long foodOutletId) {

        FoodOutlet foodOutlet = outletRepo.findById(foodOutletId).orElse(null);

        if (foodOutlet != null) {
            System.out.println(foodOutlet.getName());
            Rating rating = new Rating(ratingValue, foodOutlet);
            return ratingRepo.save(rating);
        }
        // System.out.println(foodOutlet.getName());
        return null;
    }

    public Rating updateRating(Long id, int ratingValue, Long foodOutletId) {
        Rating existingRating = ratingRepo.findById(id).orElse(null);

        if (existingRating != null) {
            FoodOutlet foodOutlet = outletRepo.findById(foodOutletId).orElse(null);

            if (foodOutlet != null) {
                existingRating.setRating(ratingValue);
                existingRating.setFoodOutlet(foodOutlet);
                return ratingRepo.save(existingRating);
            }
        }

        return null;
    }

    public void deleteRating(Long id) {
        ratingRepo.deleteById(id);
    }

}
