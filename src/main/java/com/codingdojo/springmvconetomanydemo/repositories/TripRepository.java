package com.codingdojo.springmvconetomanydemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.springmvconetomanydemo.models.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
	List<Trip> findAll();
}
