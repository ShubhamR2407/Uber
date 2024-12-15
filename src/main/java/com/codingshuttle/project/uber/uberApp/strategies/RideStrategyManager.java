package com.codingshuttle.project.uber.uberApp.strategies;

import com.codingshuttle.project.uber.uberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import com.codingshuttle.project.uber.uberApp.strategies.impl.RiderFareDefaultFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy driverMatchingHighestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy rideFareSurgePricingFareCalculationStrategy;
    private final RiderFareDefaultFareCalculationStrategy riderFareDefaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
        if(riderRating >= 4.8) {
            return driverMatchingHighestRatedDriverStrategy;
        } else {
            return driverMatchingNearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy() {
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime) {
            return rideFareSurgePricingFareCalculationStrategy;
        } else {
            return riderFareDefaultFareCalculationStrategy;
        }
    }
}
