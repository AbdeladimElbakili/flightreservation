package com.omesh.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omesh.flightreservation.dto.ReservationRequest;
import com.omesh.flightreservation.entities.Flight;
import com.omesh.flightreservation.entities.Passenger;
import com.omesh.flightreservation.entities.Reservation;
import com.omesh.flightreservation.repos.FlightRepository;
import com.omesh.flightreservation.repos.PassengerRepository;
import com.omesh.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookflight(ReservationRequest request) {
		//Make Payment
		Long flightId=request.getFlightId();
		
		Flight flight=flightRepository.findById(flightId).get();
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		
		
		Passenger savedpassenger=passengerRepository.save(passenger);
		
		Reservation reservation= new Reservation();
		
		reservation.setFlight(flight);
		reservation.setPassenger(savedpassenger);
		reservation.setCheckedIn(false); //this will be set by flight checkin app

		Reservation savedReservation=reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
