package com.lcwd.hotel.services.impl;

import com.lcwd.hotel.config.AppConstants;
import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.payload.HotelResponse;
import com.lcwd.hotel.respositories.HotelRepository;
import com.lcwd.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public HotelResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortOrd) {
        //sorting
        Sort sort = (sortOrd.equalsIgnoreCase(AppConstants.SORT_ORD_ASC)) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        //pagination
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Hotel> hotelPage = this.hotelRepository.findAll(pageable);
        List<Hotel> hotel1 = hotelPage.getContent();
        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setContent(hotel1);
        hotelResponse.setLastPage(hotelPage.isLast());
        hotelResponse.setNumberOfElementsInCurrentPage(hotelPage.getNumberOfElements());
        hotelResponse.setPageNumber(hotelPage.getNumber());
        hotelResponse.setPageSize(hotelPage.getSize());
        hotelResponse.setTotalPages(hotelPage.getTotalPages());
        hotelResponse.setTotalRecords(hotelPage.getTotalElements());

        return hotelResponse;
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
    }
}
