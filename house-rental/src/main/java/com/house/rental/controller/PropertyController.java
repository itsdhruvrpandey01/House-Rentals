package com.house.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.house.rental.dao.PropertyRepository;
import com.house.rental.entity.Property;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
	@Autowired
    private PropertyRepository propertyRepository;

    @GetMapping("/{propertyId}")
    public ResponseEntity<Property> getPropertyById(@PathVariable int propertyId) {
    	System.out.println("Received request for propertyId: " + propertyId);
        return propertyRepository.findById(propertyId)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
