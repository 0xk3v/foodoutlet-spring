package pl.foodoutlet.foodoutlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.foodoutlet.foodoutlet.model.Rating;
import pl.foodoutlet.foodoutlet.schema.RatingSchema;
import pl.foodoutlet.foodoutlet.service.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating createRating(@RequestBody RatingSchema ratingRequest) {
        return ratingService.createRating(ratingRequest.getRating(), ratingRequest.getFoodOutletId());
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }

    @PutMapping("/{id}")
    public Rating updateRating(@PathVariable Long id, @RequestBody RatingSchema ratingRequest) {
        return ratingService.updateRating(id, ratingRequest.getRating(), ratingRequest.getFoodOutletId());
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }

}
