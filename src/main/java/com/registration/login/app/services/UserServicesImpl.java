package com.registration.login.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.login.app.entities.UserDetails;
import com.registration.login.app.exceptions.AccountBlockedException;
import com.registration.login.app.exceptions.ExcessFailedTriesException;
import com.registration.login.app.exceptions.InvalidCredentialsException;
import com.registration.login.app.exceptions.InvalidUsernameException;
import com.registration.login.app.exceptions.UserAlreadyExistsException;
import com.registration.login.app.repositories.UserDetailsRepository;

@Service
public class UserServicesImpl implements UserServices {

	private UserDetailsRepository repository;

	@Autowired
	public UserServicesImpl(UserDetailsRepository repository) {
		this.repository = repository;
	}

	@Override
	public void registerUser(UserDetails user) throws UserAlreadyExistsException {
		if (repository.existsUserDetailsByUsername(user.getUsername()) != 0) {
			throw new UserAlreadyExistsException("User with " + user.getUsername() + " already exists!");
		}
		repository.save(user);
	}

	@Override
	public void loginUser(UserDetails user)
			throws InvalidUsernameException, ExcessFailedTriesException, InvalidCredentialsException,
			AccountBlockedException {
		System.out.println(user);

		if (repository.findByUsername(user.getUsername()) == null) {
			throw new InvalidUsernameException("User with " + user.getUsername() + " doesn't exists!");
		}

		if (repository.findByUsername(user.getUsername()).getIsLocked() == 1) {
			throw new AccountBlockedException("Sorry this account was blocked permanently");
		}

		if (repository.findByPassword(user.getPassword()) == null) {
			UserDetails foundUser = repository.findByUsername(user.getUsername());
			if (foundUser.getFailedTries() == 2) {
				repository.updateIsLocked(foundUser.getUsername(), 1);
				throw new ExcessFailedTriesException("Sorry, too many failed attempts! You account with Username -> "
						+ foundUser.getUsername() + " has been blocked :(");
			} else {
				repository.updateUserFailedTries(foundUser.getUsername(), foundUser.getFailedTries() + 1);
				foundUser = repository.findByUsername(user.getUsername());
				throw new InvalidCredentialsException("Your Password was incorrect! Please try again!(FailedTries = "
						+ (foundUser.getFailedTries()) + "/3)");
			}
		}

		repository.updateUserFailedTries(user.getUsername(), 0);

	}

}
