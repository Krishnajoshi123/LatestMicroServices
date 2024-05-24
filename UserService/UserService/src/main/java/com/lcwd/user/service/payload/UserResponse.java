package com.lcwd.user.service.payload;

import com.lcwd.user.service.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

    private List<User> content;

    private int pageNumber;

    private int pageSize;

    private long totalRecords;

    private int totalPages;

    private boolean lastPage;

    private int numberOfElementsInCurrentPage;
}
