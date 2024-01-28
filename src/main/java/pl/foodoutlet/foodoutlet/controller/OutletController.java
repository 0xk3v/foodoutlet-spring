package pl.foodoutlet.foodoutlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.foodoutlet.foodoutlet.model.FoodOutlet;
import pl.foodoutlet.foodoutlet.service.OutletService;

/**
 * Controller class for managing Food Outlets in the Food Outlet Rating System.
 * Exposes RESTful endpoints for CRUD operations on Food Outlets.
 *
 * @author Kévin
 * @version 1.0
 * 
 */
@CrossOrigin(origins = "http://localhost:5173/") // Allowing cross-origin requests from http://localhost:5173/
@RestController
@RequestMapping("/api/outlets")
public class OutletController {

    @Autowired
    private OutletService outletService;

    /**
     * Endpoint for creating a new Food Outlet.
     *
     * @author Kévin
     * @param outlet The Food Outlet object to be created.
     * @return The created Food Outlet.
     * 
     */
    @PostMapping
    public FoodOutlet createFoodOutlet(@RequestBody FoodOutlet outlet) {
        return outletService.createOutlet(outlet);
    }

    /**
     * Endpoint for retrieving a list of all Food Outlets.
     *
     * @author Kévin
     * @return List of Food Outlets.
     * 
     */
    @GetMapping
    public List<FoodOutlet> getAllOutlets() {
        return outletService.getAllOutlets();
    }

    /**
     * Endpoint for retrieving a specific Food Outlet by its ID.
     *
     * @author Kévin
     * @param id The ID of the Food Outlet to retrieve.
     * @return The requested Food Outlet.
     * 
     */
    @GetMapping("/{id}")
    public FoodOutlet getOutletById(@PathVariable Long id) {
        return outletService.getOutletById(id);
    }

    /**
     * Endpoint for updating an existing Food Outlet.
     * 
     * @author Kévin
     * @param id     The ID of the Food Outlet to update.
     * @param outlet The updated Food Outlet data.
     * @return The updated Food Outlet.
     * 
     */
    @PutMapping("/{id}")
    public FoodOutlet updateOutlet(@PathVariable Long id, @RequestBody FoodOutlet outlet) {
        return outletService.updateOutlet(id, outlet);
    }

    /**
     * Endpoint for deleting a Food Outlet by its ID.
     *
     * @author Kévin
     * @param id The ID of the Food Outlet to delete.
     * 
     */
    @DeleteMapping("/{id}")
    public void deleteOutlet(@PathVariable Long id) {
        outletService.deleteOutlet(id);
    }
}
