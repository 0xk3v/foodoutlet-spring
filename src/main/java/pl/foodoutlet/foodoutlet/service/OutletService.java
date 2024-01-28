package pl.foodoutlet.foodoutlet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.foodoutlet.foodoutlet.model.FoodOutlet;
import pl.foodoutlet.foodoutlet.repository.OutletRepo;

@Service
public class OutletService {

    @Autowired
    public OutletRepo outletRepo;

    public FoodOutlet createOutlet(FoodOutlet outlet) {
        return outletRepo.save(outlet);
    }

    public List<FoodOutlet> getAllOutlets() {
        return outletRepo.findAll();
    }

    public FoodOutlet getOutletById(Long id) {
        return outletRepo.findById(id).orElse(null);
    }

    public FoodOutlet updateOutlet(Long id, FoodOutlet outlet) {
        if (outletRepo.existsById(id)) {
            outlet.setId(id);
            return outletRepo.save(outlet);
        }
        return null;
    }

    public void deleteOutlet(Long id) {
        outletRepo.deleteById(id);
    }

}
