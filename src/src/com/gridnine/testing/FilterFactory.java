package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;



public class FilterFactory {
    private final List<FlightFilter> filters;
    private final List<Flight> flights;

    public FilterFactory(List<Flight> flights) {
        this.flights = new ArrayList<>(flights);
        this.filters = new ArrayList<>();
        initializeFilters();
    }

    private void initializeFilters() {
        filters.add(new DepartureBeforeNowFilter());
        filters.add(new ArrivalDateBeforeDepartureDateFilter());
        filters.add(new TotalTimeSpentOnTheGroundExceedsTwoHoursFilter());
    }

//    public void start() {
//        System.out.println("Фильтрация перелетов включена:");
//
//        List<Flight> filteredFlights = new ArrayList<>(flights);
//        for (FlightFilter filter : filters) {
//            try {
//                filteredFlights = filter.filter(filteredFlights);
//            } catch (Exception e) {
//                System.err.println("Ошибка при применении фильтра: " + e.getMessage());
//            }
//        }
//
//        printFilteredFlights(filteredFlights);
//    }
//
//    private void printFilteredFlights(List<Flight> filteredFlights) {
//        System.out.println("Набор перелетов после фильтрации:");
//        for (Flight flight : filteredFlights) {
//            System.out.println(flight);
//        }
//    }
public void start() {
    System.out.println("Фильтрация перелетов включена:");

    int ruleNumber = 1;
    List<Flight> filteredFlights = new ArrayList<>(flights);
    for (FlightFilter filter : filters) {
        try {
            System.out.println(ruleNumber + ". " +  filter.getClass().getSimpleName() + ":");
            filteredFlights = filter.filter(filteredFlights);
            printFilteredFlights(filteredFlights);
            ruleNumber++;
        } catch (Exception e) {
            System.err.println("Ошибка при применении фильтра: " + e.getMessage());
        }
    }
}

    private void printFilteredFlights(List<Flight> filteredFlights) {
        System.out.println("Набор перелетов после фильтрации:");
        for (Flight flight : filteredFlights) {
            System.out.println(flight);
        }
    }

}
