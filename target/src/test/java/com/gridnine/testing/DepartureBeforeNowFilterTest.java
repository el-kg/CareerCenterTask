package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartureBeforeNowFilterTest {

    @Test
    public void testFilter() {
        // Создаем flightList для тестирования
        List<Flight> flightList = new ArrayList<>();
        LocalDateTime currentTime = LocalDateTime.now();

        // Добавляем рейсы с вылетом в прошлом
        flightList.add(new Flight(List.of(new Segment(currentTime.minusHours(2), currentTime.minusHours(1)))));
        flightList.add(new Flight(List.of(new Segment(currentTime.minusDays(1), currentTime.minusHours(1)))));

        // Добавляем рейсы с вылетом в будущем
        flightList.add(new Flight(List.of(new Segment(currentTime.plusHours(1), currentTime.plusHours(2)))));
        flightList.add(new Flight(List.of(new Segment(currentTime.plusDays(1), currentTime.plusDays(2)))));

        // Создаем экземпляр фильтра
        DepartureBeforeNowFilter filter = new DepartureBeforeNowFilter();

        // Применяем фильтр к flightList
        List<Flight> filteredFlights = filter.filter(flightList);

        // Ожидаем, что будут исключены только рейсы с вылетом в прошлом
        assertEquals(2, filteredFlights.size());
        for (Flight flight : filteredFlights) {
            LocalDateTime departureTime = flight.getSegments().get(0).getDepartureDate();
            assertEquals(true, departureTime.isAfter(currentTime));
        }
    }
}