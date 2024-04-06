package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 2.	имеются сегменты с датой прилёта раньше даты вылета
 */
public class ArrivalDateBeforeDepartureDateFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flightList) {

        System.out.println(" Исключены перелеты, где имеются сегменты с датой прилёта раньше даты вылета:");

        return flightList.stream()
                .filter(flight -> flight.getSegments().stream()
                        .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
