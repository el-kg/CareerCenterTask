package com.gridnine.testing;

import java.util.List;

/**
 * Исключите из тестового набора перелёты по следующим правилам (по каждому правилу нужен отдельный вывод списка перелётов):
 * 1.	вылет до текущего момента времени
 * 2.	имеются сегменты с датой прилёта раньше даты вылета
 * 3.	общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
 */

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        FilterFactory filterFactory = new FilterFactory(flights);

        filterFactory.start();
    }
}