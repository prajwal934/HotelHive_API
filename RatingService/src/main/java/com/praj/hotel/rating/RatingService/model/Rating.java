package com.praj.hotel.rating.RatingService.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection ="user_rating")
public class Rating {


	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
