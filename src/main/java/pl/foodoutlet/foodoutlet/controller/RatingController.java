package pl.foodoutlet.foodoutlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.foodoutlet.foodoutlet.model.Rating;
import pl.foodoutlet.foodoutlet.schema.RatingSchema;
import pl.foodoutlet.foodoutlet.service.RatingService;

/**
 * SpringBoot Controller to Manage Rating
 * 
 * @author Kévin
 *
 */

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    /**
     * Calls Rating Service to create a new Rating
     * 
     * @param ratingRequest
     * @return A created Rating
     * @author Kévin
     *
     */

    @PostMapping
    public Rating createRating(@RequestBody RatingSchema ratingRequest) {
        return ratingService.createRating(ratingRequest.getRating(), ratingRequest.getFoodOutletId());
    }

    /**
     * Calls Rating Service to Fetch all Ratings from the Database
     * 
     * @return A List of all Ratings
     * @author Kévin
     *
     */

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    /**
     * Calls Rating Service to Fetch all Ratings from the Database
     * 
     * @param id
     * @return A Single Rating based on provided param
     * @author Kévin
     * 
     */

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
