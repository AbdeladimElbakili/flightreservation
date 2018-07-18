package com.omesh.flightreservation.services;

import com.omesh.flightreservation.dto.ReservationRequest;
import com.omesh.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookflight(ReservationRequest request);
}
