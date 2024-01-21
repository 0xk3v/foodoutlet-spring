package pl.foodoutlet.foodoutlet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.foodoutlet.foodoutlet.model.FoodOutlet;
import pl.foodoutlet.foodoutlet.repository.FoodOutletRepo;

@Service
public class OutletService {

    @Autowired
    public FoodOutletRepo outletRepo;

    public FoodOutlet createOutlet(FoodOutlet outlet) {
        return outletRepo.save(outlet);
    }

    public List<FoodOutlet> getAllOutlets() {
        return outletRepo.findAll();
    }

    public FoodOutlet getOutletById(int id) {
        return outletRepo.findById(id).orElse(null);
    }

    public FoodOutlet updateOutlet(Integer id, FoodOutlet outlet) {
        outlet.setId(id);
        return outletRepo.save(outlet);
    }

    public void deleteOutlet(int id) {
        outletRepo.deleteById(id);
    }

}
