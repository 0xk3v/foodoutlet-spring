package pl.foodoutlet.foodoutlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.foodoutlet.foodoutlet.model.FoodOutlet;
import pl.foodoutlet.foodoutlet.service.OutletService;

@RestController
@RequestMapping("/api/outlets")
public class OutletController {

    @Autowired
    private OutletService outletService;

    @PostMapping
    public FoodOutlet createFoodOutlet(@RequestBody FoodOutlet outlet) {
        return outletService.createOutlet(outlet);
    }

    @GetMapping
    public List<FoodOutlet> getAllOutlets() {
        return outletService.getAllOutlets();
    }

    @GetMapping("/{id}")
    public FoodOutlet getOutletById(@PathVariable Long id) {
        return outletService.getOutletById(id);
    }

    @PutMapping("/{id}")
    public FoodOutlet updateOutlet(@PathVariable Long id, @RequestBody FoodOutlet outlet) {
        return outletService.updateOutlet(id, outlet);
    }

    @DeleteMapping("/{id}")
    public void deleteOutlet(@PathVariable Long id) {
        outletService.deleteOutlet(id);
    }
}
