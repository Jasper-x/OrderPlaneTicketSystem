package cn.edu.hcnu.bll;

import cn.edu.hcnu.bean.Flight;

import java.util.Set;

public interface IFlightService {
    void insterFlight (Flight flight);
    Set<Flight> getAllFlights();
    Flight getFlightByDepartureTime(String departureTime);
    Flight getFlightByDeparturAirPort(String departurAirPort);
    Flight getFlightByDestinationAirPort(String destinationAirPort);
    void updateFlight(Flight flight);
}
