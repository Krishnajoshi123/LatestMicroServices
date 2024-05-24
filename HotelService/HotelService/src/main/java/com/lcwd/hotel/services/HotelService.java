package com.lcwd.hotel.services;

import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.payload.HotelResponse;

import java.util.List;

public interface HotelService {

    //create

    Hotel create(Hotel hotel);

    //get all
    HotelResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortOrd);

    //get single
    Hotel get(String id);

}
