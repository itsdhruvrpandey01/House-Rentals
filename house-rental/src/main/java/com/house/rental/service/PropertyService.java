package com.house.rental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.house.rental.dao.PropertyRepository;
import com.house.rental.entity.Property;

import jakarta.persistence.criteria.Predicate;

@Service
public class PropertyService {
	@Autowired
    private PropertyRepository propertyRepository;

    public List<Property> searchProperties(String query) {
        String[] keywords = query.toLowerCase().split("\\s+"); // Split query by spaces
        
        Specification<Property> spec = (root, queryObj, criteriaBuilder) -> {
            Predicate finalPredicate = criteriaBuilder.conjunction(); // Start with an always-true condition

            for (String keyword : keywords) {
                Predicate likePredicate = criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("description")), "%" + keyword + "%");
                finalPredicate = criteriaBuilder.and(finalPredicate, likePredicate);
            }
            
            return finalPredicate;
        };

        return propertyRepository.findAll(spec);
    }
    public List<Property> searchProperties(String location, Integer minRent, Integer maxRent, Integer bedrooms, String furnishingType) {
        return propertyRepository.searchProperties(location, minRent, maxRent, bedrooms, furnishingType);
    }
    
}
