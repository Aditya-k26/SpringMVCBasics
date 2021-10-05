package com.registration.login.app.services;

import com.registration.login.app.entities.UserDetails;
import com.registration.login.app.exceptions.AccountBlockedException;
import com.registration.login.app.exceptions.ExcessFailedTriesException;
import com.registration.login.app.exceptions.InvalidCredentialsException;
import com.registration.login.app.exceptions.InvalidUsernameException;
import com.registration.login.app.exceptions.UserAlreadyExistsException;

public interface UserServices {
	public void registerUser(UserDetails user) throws UserAlreadyExistsException;

	public void loginUser(UserDetails user)
			throws InvalidUsernameException, ExcessFailedTriesException, InvalidCredentialsException,
			AccountBlockedException;
}
