package com.house.rental.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.house.rental.entity.Property;
import com.house.rental.entity.User;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
	List<Property> findAll(Specification<Property> spec);
	
	 @Query("SELECT p FROM Property p WHERE " +
	            "(LOWER(p.city) LIKE LOWER(CONCAT('%', :location, '%')) OR " +
	            " LOWER(p.locality) LIKE LOWER(CONCAT('%', :location, '%')) OR " +
	            " LOWER(p.sub_locality) LIKE LOWER(CONCAT('%', :location, '%'))) AND " +
	            "(:minRent IS NULL OR p.rent_price >= :minRent) AND " +
	            "(:maxRent IS NULL OR p.rent_price <= :maxRent) AND " +
	            "(:bedrooms IS NULL OR p.no_of_bedrooms = :bedrooms) AND " +
	            "(:furnishingType IS NULL OR LOWER(p.furnishing_type) = LOWER(:furnishingType))")
	    List<Property> searchProperties(
	            @Param("location") String location,  // Can be city, locality, or sub-locality
	            @Param("minRent") Integer minRent,
	            @Param("maxRent") Integer maxRent,
	            @Param("bedrooms") Integer bedrooms,
	            @Param("furnishingType") String furnishingType
	    );
	 @Query("select p from Property p where p.property_id =:property_id")
		public Property getUserById(@Param("property_id")int id);
	 
	 List<Property> findByUser(User user);
}
