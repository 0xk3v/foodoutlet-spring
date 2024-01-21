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

import pl.foodoutlet.foodoutlet.model.FoodOutlet;
import pl.foodoutlet.foodoutlet.service.OutletService;

@RestController
@RequestMapping("/api/outlets")
public class OutletController {

    @Autowired
    private OutletService outletService;

    @PostMapping
    public FoodOutlet createFoodOutlet(FoodOutlet outlet) {
        return outletService.createOutlet(outlet);
    }

    @GetMapping
    public List<FoodOutlet> getAllOutlets() {
        return outletService.getAllOutlets();
    }

    @GetMapping("/{id}")
    public FoodOutlet getOutletById(@PathVariable int id) {
        return outletService.getOutletById(id);
    }

    @PutMapping("/{id}")
    public FoodOutlet updateOutlet(@PathVariable int id, @RequestBody FoodOutlet outlet) {
        return outletService.updateOutlet(id, outlet);
    }

    @DeleteMapping("/{id}")
    public void deleteOutlet(@PathVariable int id) {
        outletService.deleteOutlet(id);
    }
}
