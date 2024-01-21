package pl.foodoutlet.foodoutlet.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "food_outlet")
public class FoodOutlet {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "name")
        private String name;

        @Column(name = "address")
        private String address;

        @Column(name = "cuisine_type")
        private String cuisineType;

        @Column(name = "opening_hours")
        private String openingHours;

        @OneToMany(mappedBy = "foodOutlet", cascade = CascadeType.ALL)
        private List<Rating> ratings = new ArrayList<>();

        public FoodOutlet() {
        }

        public FoodOutlet(String name, String address, String cuisineType, String openingHours) {
                this.name = name;
                this.address = address;
                this.cuisineType = cuisineType;
                this.openingHours = openingHours;
                this.ratings = new ArrayList<>();
        }

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getCuisineType() {
                return cuisineType;
        }

        public void setCuisineType(String cuisineType) {
                this.cuisineType = cuisineType;
        }

        public String getOpeningHours() {
                return openingHours;
        }

        public void setOpeningHours(String openingHours) {
                this.openingHours = openingHours;
        }

        public List<Rating> getRatings() {
                return ratings;
        }

        public void addRating(Rating rating) {
                ratings.add(rating);
        }

        public double calculateAverageRating() {
                if (ratings.isEmpty()) {
                        return 0.0;
                }

                int totalRating = 0;
                for (Rating rating : ratings) {
                        totalRating += rating.getRating();
                }

                return (double) totalRating / ratings.size();
        }
}