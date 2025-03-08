package com.praj.hotel.rating.RatingService.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praj.hotel.rating.RatingService.dto.RatingDto;
import com.praj.hotel.rating.RatingService.model.Rating;
import com.praj.hotel.rating.RatingService.services.RatingService;
import com.praj.hotel.rating.RatingService.utility.ResponseStructure;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ratings")
@AllArgsConstructor
public class RatingController {

	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Rating>> createRating(@RequestBody RatingDto ratingDto) {
	 return	ratingService.createRating(ratingDto);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Rating>>> getAllRatings() {
		return ratingService.getAllRatings();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<List<Rating>>> getRatingByUserId(@PathVariable  String userId) {
		return ratingService.getRatingByUserId(userId);
	}
		
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<ResponseStructure<List<Rating>>> getRatingByHotelId(@PathVariable String hotelId) {
		return ratingService.getRatingByHotelId(hotelId);
	}
}
