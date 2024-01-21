package pl.foodoutlet.foodoutlet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rating_review")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "food_outlet_id")
    private FoodOutlet foodOutlet;

    public Rating() {
        // Default constructor required by Hibernate
    }

    public Rating(int rating, FoodOutlet foodOutlet) {
        this.rating = rating;
        this.foodOutlet = foodOutlet;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public FoodOutlet getFoodOutlet() {
        return foodOutlet;
    }

    public void setFoodOutlet(FoodOutlet foodOutlet) {
        this.foodOutlet = foodOutlet;
    }

}
