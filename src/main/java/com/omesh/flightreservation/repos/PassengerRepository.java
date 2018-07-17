package com.omesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.omesh.flightreservation.entities.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger,Long> {

}
