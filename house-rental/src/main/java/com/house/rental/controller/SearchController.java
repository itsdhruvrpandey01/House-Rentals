package com.house.rental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.house.rental.dao.PropertyRepository;
import com.house.rental.entity.Property;
import com.house.rental.service.PropertyService;

@Controller
public class SearchController {
	
	@Autowired
    private PropertyService propertyService;
	
	@Autowired
	private PropertyRepository propertyRepository;
	@GetMapping("/search")
    public String  searchProperties(
            @RequestParam String location,  // User can search for city, locality, or sub-locality
            @RequestParam(required = false) Integer minRent,
            @RequestParam(required = false) Integer maxRent,
            @RequestParam(required = false) Integer bedrooms,
            @RequestParam(required = false) String furnishingType,
            Model m
    ) {
        List<Property> properties = propertyService.searchProperties(location, minRent, maxRent, bedrooms, furnishingType);
        if(properties == null) System.out.println("ha meri jan");
        m.addAttribute("property", properties);
//        System.out.println(properties);
        return "searchfilter";
    }
	
	@GetMapping("/property/view/{id}")
    public String viewProperty(@PathVariable int id, Model model) {
        Optional<Property> propertyById = this.propertyRepository.findById(id);
        // Fetch from DB
        Property property = propertyById.get();
        System.out.println("hello from backend");
        if (property == null) {
            return "home"; // Handle invalid ID
        }
        model.addAttribute("p", property);
        return "viewprop"; // Redirect to viewProp.html
    }
}
