package pl.foodoutlet.foodoutlet.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "food_outlet")
public class FoodOutlet {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @NotEmpty
        @Column(name = "name")
        private String name;

        @NotEmpty
        @Column(name = "address")
        private String address;

        @NotEmpty
        @Column(name = "cuisine_type")
        private String cuisineType;

        @Column(name = "opening_hours")
        private String openingHours;

        // One-to-Many relationship: One FoodOutlet to Many Ratings
        @OneToMany(mappedBy = "foodOutlet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JsonManagedReference
        private List<Rating> ratings;;

        public FoodOutlet() {
        }

        public FoodOutlet(String name, String address, String cuisineType, String openingHours) {
                this.name = name;
                this.address = address;
                this.cuisineType = cuisineType;
                this.openingHours = openingHours;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
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

        public void setRatings(List<Rating> ratings) {
                this.ratings = ratings;
        }

}