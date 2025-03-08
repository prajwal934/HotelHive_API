package com.praj.hotel.rating.RatingService.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.praj.hotel.rating.RatingService.dto.RatingDto;
import com.praj.hotel.rating.RatingService.model.Rating;
import com.praj.hotel.rating.RatingService.utility.ResponseStructure;


public interface RatingService {
	
	public ResponseEntity<ResponseStructure<Rating>> createRating(RatingDto ratingDto);
	public ResponseEntity<ResponseStructure<List<Rating>>> getAllRatings();
	public ResponseEntity<ResponseStructure<List<Rating>>> getRatingByUserId(String userId);
	public ResponseEntity<ResponseStructure<List<Rating>>> getRatingByHotelId(String hotelId);
	
}
