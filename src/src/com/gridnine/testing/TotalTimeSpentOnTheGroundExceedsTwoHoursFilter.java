package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 3. - Общее время, проведённое на земле превышает два часа
 * (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
 */
public class TotalTimeSpentOnTheGroundExceedsTwoHoursFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println(" Исключены перелеты, где общее время, проведённое на земле превышает 2 часа");

        return flightList.stream()
                .filter(flight -> calculateGroundTime(flight) <= 2)
                .collect(Collectors.toList());
    }

    private long calculateGroundTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.size() <= 1) {
            return 0;
        }

        LocalDateTime lastArrival = null;
        long totalGroundTime = 0;

        for (Segment segment : segments) {
            LocalDateTime departure = segment.getDepartureDate();
            if (lastArrival != null) {
                totalGroundTime += calculateDurationBetween(lastArrival, departure);
            }
            lastArrival = segment.getArrivalDate();
        }

        return totalGroundTime;
    }

    private long calculateDurationBetween(LocalDateTime start, LocalDateTime end) {
        return start.until(end, java.time.temporal.ChronoUnit.HOURS);
    }
}
