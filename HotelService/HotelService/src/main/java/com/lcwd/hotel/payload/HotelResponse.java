package com.lcwd.hotel.payload;

import com.lcwd.hotel.entites.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class HotelResponse {

    private List<Hotel> content;

    private int pageNumber;

    private int pageSize;

    private long totalRecords;

    private int totalPages;

    private boolean lastPage;

    private int numberOfElementsInCurrentPage;
}
