package org.softuni.exam.structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

public class AirlinesManagerImpl implements AirlinesManager {
	
	private Map<Airline, List<Flight>> airlines;
	private List<Flight> allFlights;
	private List<Flight> completedFlights;
	
	
    public AirlinesManagerImpl() {
		this.airlines = new LinkedHashMap<>();
		this.allFlights = new ArrayList<>();
		this.completedFlights = new ArrayList<>();
	}

	@Override
    public void addAirline(Airline airline) {
		airlines.put(airline, new ArrayList<>());
    }

    @Override
    public void addFlight(Airline airline, Flight flight) {
    	if(!airlines.containsKey(airline)) throw new IllegalArgumentException();
    	airlines.get(airline).add(flight);
    	allFlights.add(flight);
    }

    @Override
    public boolean contains(Airline airline) {
        return airlines.containsKey(airline);
    }

    @Override
    public boolean contains(Flight flight) {
        return allFlights.contains(flight);
    }

    @Override
    public void deleteAirline(Airline airline) throws IllegalArgumentException {
    	if(!airlines.containsKey(airline)) throw new IllegalArgumentException();
    	allFlights.removeAll(airlines.get(airline));
    	completedFlights.removeAll(airlines.get(airline));
    	airlines.remove(airline);
    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return allFlights;
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) throws IllegalArgumentException {
    	if(!airlines.containsKey(airline) || !airlines.get(airline).contains(flight)) throw new IllegalArgumentException();
    	
    	flight.setCompleted(true);
    	
    	completedFlights.add(flight);
    
        return flight;
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return completedFlights;
    }

    @Override
    public Iterable<Flight> getFlightsOrderedByNumberThenByCompletion() {	
       List<Flight> orderedFlights = allFlights.stream().sorted( Comparator.comparing(Flight::isCompleted)
    		   													.thenComparing(Flight::getNumber))
        								  						.collect(Collectors.toList()); 
       	return orderedFlights;
    }

    @Override
    public Iterable<Airline> getAirlinesOrderedByRatingThenByCountOfFlightsThenByName() {
        return airlines.keySet().stream().sorted(Comparator.comparingDouble(Airline::getRating)
        													.thenComparingInt(airline -> airlines.get(airline).size()).reversed()
        													.thenComparing(Airline::getName))
        													.collect(Collectors.toList());
    }

    @Override
    public Iterable<Airline> getAirlinesWithFlightsFromOriginToDestination(String origin, String destination) {
        return airlines.keySet().stream().filter(airline -> this.hasNotCompletedFlightsWithCorrectPoints(airline, origin, destination))
        		.collect(Collectors.toList());
    }

    public boolean hasNotCompletedFlightsWithCorrectPoints(Airline airline, String origin, String destination) {
    	for (Flight flight : airlines.get(airline)) {
			if(!flight.isCompleted() && flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) return true;
		}
    	return false;
    }
}
