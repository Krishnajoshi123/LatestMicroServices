package com.lcwd.rating.services.impl;

import com.lcwd.rating.config.AppConstants;
import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.payload.RatingResponse;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public RatingResponse getRatings(Integer pageNumber, Integer pageSize, String sortBy, String sortOrd) {
        //Sorting
        Sort sort= (sortOrd.equalsIgnoreCase(AppConstants.SORT_ORD_ASC)) ? Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();
        //Pagination
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Rating> ratingPage = repository.findAll(pageable);
        List<Rating> rating1 = ratingPage.getContent();
        RatingResponse ratingResponse = new RatingResponse();
        ratingResponse.setContent(rating1);
        ratingResponse.setTotalPages(ratingPage.getTotalPages());
        ratingResponse.setLastPage(ratingPage.isLast());
        ratingResponse.setPageNumber(ratingPage.getNumber());
        ratingResponse.setTotalRecords(ratingPage.getTotalElements());
        ratingResponse.setPageSize(ratingPage.getSize());
        ratingResponse.setNumberOfElementsInCurrentPage(ratingPage.getNumberOfElements());

        return ratingResponse;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
