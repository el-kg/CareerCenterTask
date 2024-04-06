package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 1.	вылет до текущего момента времени
 */
public class DepartureBeforeNowFilter implements FlightFilter {

    private final LocalDateTime localDateTime = LocalDateTime.now();

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println(" Исключены перелеты с вылетами до текущего момента времени:");

        return flightList.stream()
                .filter(flight -> flight.getSegments().stream()
                        .noneMatch(segment -> segment.getDepartureDate().isBefore(localDateTime)))
                .collect(Collectors.toList());
    }
}

