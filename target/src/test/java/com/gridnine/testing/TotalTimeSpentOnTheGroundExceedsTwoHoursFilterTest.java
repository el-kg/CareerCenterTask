package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

class TotalTimeSpentOnTheGroundExceedsTwoHoursFilterTest {

    @Test
    public void testFilter() {
        // Создаем flightList для тестирования
        List<Flight> flightList = new ArrayList<>();

        // Добавляем рейсы с общим временем, проведенным на земле менее 2 часов
        List<Segment> segments1 = new ArrayList<>();
        segments1.add(new Segment(LocalDateTime.of(2024, 4, 9, 10, 0), LocalDateTime.of(2024, 4, 9, 11, 0)));
        segments1.add(new Segment(LocalDateTime.of(2024, 4, 9, 12, 0), LocalDateTime.of(2024, 4, 9, 13, 0)));
        flightList.add(new Flight(segments1));

        // Добавляем рейсы с общим временем, проведенным на земле более 2 часов
        List<Segment> segments2 = new ArrayList<>();
        segments2.add(new Segment(LocalDateTime.of(2024, 4, 9, 10, 0), LocalDateTime.of(2024, 4, 9, 11, 0)));
        segments2.add(new Segment(LocalDateTime.of(2024, 4, 9, 12, 0), LocalDateTime.of(2024, 4, 9, 15, 0)));
        flightList.add(new Flight(segments2));

        // Создаем экземпляр фильтра
        TotalTimeSpentOnTheGroundExceedsTwoHoursFilter filter = new TotalTimeSpentOnTheGroundExceedsTwoHoursFilter();

        // Применяем фильтр к flightList
        List<Flight> filteredFlights = filter.filter(flightList);

        // Ожидаем, что будет исключен только рейс с общим временем, проведенным на земле более 2 часов
        assertEquals(1, filteredFlights.size());
        assertEquals(flightList.get(0), filteredFlights.get(0));
    }
}