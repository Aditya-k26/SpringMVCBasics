package com.registration.login.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.registration.login.app.entities.UserDetails;
import com.registration.login.app.exceptions.AccountBlockedException;
import com.registration.login.app.exceptions.ExcessFailedTriesException;
import com.registration.login.app.exceptions.InvalidCredentialsException;
import com.registration.login.app.exceptions.InvalidUsernameException;
import com.registration.login.app.exceptions.UserAlreadyExistsException;
import com.registration.login.app.services.UserServices;


@Controller
public class LoginResgistrationController {

	private UserServices userServices;

	@Autowired
	public LoginResgistrationController(UserServices userServices) {
		this.userServices = userServices;
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user_details", new UserDetails());
		return "register";
	}


	@PostMapping("/process_register")
	public String processRegister(UserDetails user) throws UserAlreadyExistsException {
		userServices.registerUser(user);
		return "success";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user_details", new UserDetails());
		return "login";
	}

	@PostMapping("/process_login")
	public String processLogin(UserDetails user, Model model)
			throws InvalidUsernameException, ExcessFailedTriesException, InvalidCredentialsException,
			AccountBlockedException {
		model.addAttribute("username", user.getUsername());
		userServices.loginUser(user);
		return "welcome-user";
	}

}
