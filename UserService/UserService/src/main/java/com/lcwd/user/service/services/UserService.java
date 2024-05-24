package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.payload.UserResponse;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all user
    UserResponse getAllUser(Integer pageNumber, Integer pageSize, String sortBy, String sortOrd);

    //get single user of given userId

    User getUser(String userId);

    //TODO: delete
    //TODO: update


}
