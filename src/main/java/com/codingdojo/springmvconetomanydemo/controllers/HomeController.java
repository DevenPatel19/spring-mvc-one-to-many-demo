package com.codingdojo.springmvconetomanydemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.springmvconetomanydemo.models.Trip;
import com.codingdojo.springmvconetomanydemo.models.User;
import com.codingdojo.springmvconetomanydemo.services.TripService;
import com.codingdojo.springmvconetomanydemo.services.UserService;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private TripService tripService;
	
	@Autowired
	private UserService userService;
	
	//Trip Dash Board
	@GetMapping("/")
	public String tripDashboard() {
		return "tripDashboard.jsp";
	}
	
	
	//create user
	//render user form
	@GetMapping("/users/new")
	public String renderCreateUserForm(@ModelAttribute("newUser")User newUser) {
		return "createUser.jsp";
	}
	
	//process user form
	@PostMapping("/users/new")
	public String processUserForm(@Valid @ModelAttribute("newUser") User newUser, BindingResult result
	) {
		if (result.hasErrors()) {
			return "createUser.jsp"; // return to form page
		} else {
			userService.createUser(newUser);
			return "redirect:/"; // redirect to...Dashboard
		}
	}
	
	//create trip
	//render trip form
	@GetMapping("/trips/new")
	public String renderCreateTripForm(@ModelAttribute("newTrip")Trip newTrip, Model model) {
		model.addAttribute("userList", userService.allUsers()); //  won't need when log & Reg is done
		return "createTrip.jsp";
	}
	
	//process trip form
	@PostMapping("/trips/new")
	public String processTripForm(
			@Valid @ModelAttribute("newTrip") Trip newTrip, BindingResult result, Model model
	) {
		if (result.hasErrors()) {
			model.addAttribute("userList", userService.allUsers()); //  won't need when log & Reg is done
			return "createTrip.jsp"; // return to form page
		} else {
			
			tripService.createTrip(newTrip);
			return "redirect:/"; // redirect to...Dashboard
		}
	}
}
