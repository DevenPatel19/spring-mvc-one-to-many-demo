package com.codingdojo.springmvconetomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.springmvconetomanydemo.models.Trip;
import com.codingdojo.springmvconetomanydemo.repositories.TripRepository;

@Service
public class TripService {

	@Autowired
	private TripRepository tripRepo;
	
	// Find all
	public List<Trip> allTrips(){
		return tripRepo.findAll();
	}
	
	// Find one
	public Trip findTrip(Long id) {
		Optional<Trip> optionalTrip = tripRepo.findById(id);
		if(optionalTrip.isPresent()) {
			return optionalTrip.get();
		} else {
			return null;
		}
	}
	
	
	// Create
	public Trip createTrip(Trip newTrip) {
		return tripRepo.save(newTrip);
	}
	
	// Update
	public Trip updatedTrip(Trip trip) {
		return tripRepo.save(trip);
	}
	
	// Delete
	public void deleteTrip(Long id) {
		tripRepo.deleteById(id);
	}
}
