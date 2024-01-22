package pl.foodoutlet.foodoutlet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "rating_review")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_outlet_id")
    @JsonIgnore
    private FoodOutlet foodOutlet;

    public Rating() {
    }

    public Rating(int rating, FoodOutlet foodOutlet) {
        this.rating = rating;
        this.foodOutlet = foodOutlet;
    }

    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FoodOutlet getFoodOutlet() {
        return foodOutlet;
    }

    public Long getFoodOutletId() {
        return this.foodOutlet.getId();
    }

    public void setFoodOutlet(FoodOutlet foodOutlet) {
        this.foodOutlet = foodOutlet;
    }

}
