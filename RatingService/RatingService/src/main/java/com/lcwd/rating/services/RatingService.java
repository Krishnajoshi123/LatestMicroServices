package com.lcwd.rating.services;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.payload.RatingResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    //create
    Rating create(Rating rating);


    //get all ratings
    RatingResponse getRatings(Integer pageNumber, Integer pageSize, String sortBy, String sortOrd);

    //get all by UserId
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);




}
