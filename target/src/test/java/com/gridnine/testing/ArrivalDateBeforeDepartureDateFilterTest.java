package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrivalDateBeforeDepartureDateFilterTest {

        @Test
        public void testFilter() {
            // Создаем ручным образом flightList для тестирования
            List<Flight> flightList = new ArrayList<>();
            List<Segment> segments = new ArrayList<>();
            segments.add(new Segment(LocalDateTime.of(2024, 4, 9, 10, 0), LocalDateTime.of(2024, 4, 9, 12, 0)));
            Flight flight1 = new Flight(segments);
            flightList.add(flight1);

            // Создаем экземпляр фильтра
            ArrivalDateBeforeDepartureDateFilter filter = new ArrivalDateBeforeDepartureDateFilter();

            // Применяем фильтр к flightList
            List<Flight> filteredFlights = filter.filter(flightList);

            // Проверяем, что список остается неизменным, так как в данном случае прилет не раньше вылета
            assertEquals(flightList, filteredFlights);
        }
}