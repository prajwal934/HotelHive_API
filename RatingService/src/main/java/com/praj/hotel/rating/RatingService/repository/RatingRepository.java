package com.praj.hotel.rating.RatingService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.praj.hotel.rating.RatingService.model.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {

	//	Here , I,m going to create custom finder method
	Optional<List<Rating>> findByUserId(String userId);
	Optional<List<Rating>> findByHotelId(String hotelId);
	
}
