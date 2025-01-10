package com.codingshuttle.project.uber.uberApp.services;

import com.codingshuttle.project.uber.uberApp.dto.DriverDto;
import com.codingshuttle.project.uber.uberApp.dto.RiderDto;
import com.codingshuttle.project.uber.uberApp.entities.Ride;

public interface RatingService {
    RiderDto rateRider(Ride ride, Integer rating);
    DriverDto rateDriver(Ride ride, Integer rating);
    void createNewRating(Ride ride);
}
