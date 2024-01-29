package pl.foodoutlet.foodoutlet.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import pl.foodoutlet.foodoutlet.controller.OutletController;
import pl.foodoutlet.foodoutlet.model.FoodOutlet;
import pl.foodoutlet.foodoutlet.service.OutletService;

/**
 * Tests for Outlet Controller, making sure it works as inteneded
 *
 * @author Raymond
 *
 */
@WebMvcTest(OutletController.class)
public class OutletControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OutletService outletService;

    @Test
    public void testGetAllFoodOutlets() throws Exception {
        FoodOutlet foodOutlet1 = new FoodOutlet("Restaurant", "123 Main St", "Italian", "9 AM - 9 PM");
        FoodOutlet foodOutlet2 = new FoodOutlet("Bistro", "456 Oak St", "French", "10 AM - 8 PM");

        Mockito.when(outletService.getAllOutlets()).thenReturn(Arrays.asList(foodOutlet1, foodOutlet2));

        mockMvc.perform(get("/api/outlets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Restaurant"))
                .andExpect(jsonPath("$[1].name").value("Bistro"));
    }

    @Test
    public void testGetFoodOutletById() throws Exception {
        FoodOutlet foodOutlet = new FoodOutlet("Takeaway", "789 Pine St", "Asian", "11 AM - 10 PM");

        Mockito.when(outletService.getOutletById(1L)).thenReturn(foodOutlet);

        mockMvc.perform(get("/api/outlets/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Takeaway"));
    }

    // Add more tests for other FoodOutletController endpoints
}
