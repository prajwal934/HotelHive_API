package com.praj.hotel.rating.RatingService.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.praj.hotel.rating.RatingService.dto.RatingDto;
import com.praj.hotel.rating.RatingService.model.Rating;
import com.praj.hotel.rating.RatingService.repository.RatingRepository;
import com.praj.hotel.rating.RatingService.services.RatingService;
import com.praj.hotel.rating.RatingService.utility.ResponseStructure;

@Service
public class RatingServiceImpl implements RatingService {


	private RatingRepository ratingRepository;
	private ResponseStructure<Rating> responseStructure;
	private ResponseStructure<List<Rating>> rs;
	



	public RatingServiceImpl(RatingRepository ratingRepository, ResponseStructure<Rating> responseStructure,
			ResponseStructure<List<Rating>> rs) {
		super();
		this.ratingRepository = ratingRepository;
		this.responseStructure = responseStructure;
		this.rs = rs;
	}

	@Override
	public ResponseEntity<ResponseStructure<Rating>> createRating(RatingDto ratingDto) {
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Rating Created Successfully!!")
				.setData(ratingRepository.save(mapToRating(ratingDto))));
	}

	private Rating mapToRating(RatingDto ratingDto) {

		String randomRatingId = UUID.randomUUID().toString(); //for generating unique ratingId;
		return Rating.builder()
				.rating(ratingDto.getRating())
				.userId(ratingDto.getUserId())
				.hotelId(ratingDto.getHotelId())
				.feedback(ratingDto.getFeedback())
				.ratingId(randomRatingId).build();
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Rating>>> getAllRatings() {
		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("Rating Data fetched Successfully!!")
				.setData(ratingRepository.findAll()));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Rating>>> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId).map(rating -> ResponseEntity.ok(
				rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("Rating By users have been founded Successfully!!")
				.setData(rating)))
				.orElseThrow(() -> new RuntimeException());
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Rating>>> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId).map(hotel -> ResponseEntity.ok(
				rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("Rating by Hotels have been founded successfully")
				.setData(hotel)))
				.orElseThrow(() -> new RuntimeException());
	}


}
