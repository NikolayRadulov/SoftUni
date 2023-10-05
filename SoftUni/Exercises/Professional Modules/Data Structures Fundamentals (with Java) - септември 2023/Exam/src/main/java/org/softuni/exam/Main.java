package org.softuni.exam;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;
import org.softuni.exam.structures.AirlinesManagerImpl;

public class Main {
    public static void main(String[] args) {
    	AirlinesManagerImpl airlinesManagerImpl = new AirlinesManagerImpl();
    	
    	Airline airline1 = new Airline("435", "Airline1", 5.34);
    	Flight flight1 = new Flight("352", "42353", "gf", "fwr", false);
    	
    	airlinesManagerImpl.addAirline(airline1);
    	airlinesManagerImpl.addFlight(airline1, flight1);
    	airlinesManagerImpl.addFlight(airline1, new Flight("c352", "4g2353", "gtf", "fwrr", false));
    	airlinesManagerImpl.addFlight(airline1, new Flight("352", "42353", "gf", "fwr", true));
    	
    	airlinesManagerImpl.performFlight(airline1, flight1);
    	    	
    }
}
