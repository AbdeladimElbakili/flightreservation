package com.omesh.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.omesh.flightreservation.dto.ReservationRequest;
import com.omesh.flightreservation.entities.Flight;
import com.omesh.flightreservation.entities.Reservation;
import com.omesh.flightreservation.repos.FlightRepository;
import com.omesh.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightid")Long flightid,ModelMap modelMap)
	{
		Flight flight=flightRepository.findById(flightid).get();
		modelMap.addAttribute("flight",flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap){
		Reservation reservation=reservationService.bookflight(request);
		modelMap.addAttribute("msg","reservation done successsfully and the id is"+reservation.getId());
		return "reservationConfirmation";
	}
}