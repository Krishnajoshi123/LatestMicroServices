package com.lcwd.rating.payload;

import com.lcwd.rating.entities.Rating;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RatingResponse {

    private List<Rating> content;

    private int pageNumber;

    private int pageSize;

    private long totalRecords;

    private int totalPages;

    private boolean lastPage;

    private int numberOfElementsInCurrentPage;
}
