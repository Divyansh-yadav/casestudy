package com.impetus.ogos.user.service.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.exception.InputValidationException;
import com.impetus.ogos.exception.ResourceConflictException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.exception.RestException;
import com.impetus.ogos.user.dao.IUserDao;
import com.impetus.ogos.user.model.User;
import com.impetus.ogos.user.service.IUserService;
import com.impetus.ogos.util.SentMail;

/** Implemented the IUserService and overriding the method. */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {
	static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	static final String SERVICEEXCEPTION = "ServiceException";
	static final int LENGTH = 6;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private SentMail sentMail;

	@Override
	public void addUser(User user) throws ResourceNotFound {
		try {
			LOGGER.debug("Inside UserServiceImpl class Inside  addUser Method");
			if (validateUser(user))
				userDao.addUser(user);

			String text = "Your Registration has been done";
			sentMail.mail(user.getEmail(), text);
		} catch (DaoException e) {
			if (e.getCause() instanceof PersistenceException)
				throw new ResourceConflictException("Email already exist. Unable to create user.");
			throw new RestException("Server Not Available");
		}
	}

	/**
	 * This method validates if the user data is in proper format or not.
	 * 
	 * @param user is the object of the User.
	 * @return boolean true if all inputs are correct otherwise throw exception.
	 * @throws InputValidationException is the user enters the incorrect format.
	 */
	public boolean validateUser(User user) throws InputValidationException {
		String email = user.getEmail();
		String password = user.getPassword();
		String name = user.getUserName();

		if (email == null || !email.matches("[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,5}")) {
			throw new InputValidationException("Email id is not valid");
		} else if (password == null || password.length() < LENGTH) {
			throw new InputValidationException("Password is not valid");
		} else if (name == null || name.length() <= 0) {
			throw new InputValidationException("User Name is not valid");
		}
		return true;
	}

	@Override
	public List<User> getAllUser() throws ResourceNotFound {
		List<User> userList;
		try {
			LOGGER.debug("Inside UserServiceImpl class Inside  getAllUser Method");
			userList = userDao.getAllUser();
			LOGGER.debug("uSER lIST:" + userList);
			return userList;
		} catch (DaoException e) {
			LOGGER.error(SERVICEEXCEPTION + e);
			throw new ResourceNotFound(SERVICEEXCEPTION + e);
		}

	}

	@Override
	public User getUserByEmail(String email) throws ResourceNotFound {
		try {
			LOGGER.debug("Inside UserServiceImpl class Inside  getUserByEmail Method");
			return userDao.getUserByEmail(email);
		} catch (DaoException exception) {
			if (exception.getCause() instanceof NoResultException)
				throw new ResourceNotFound("NO EMAIL FOUND" + email);
		}
		throw new RestException("Unable To Get User");
	}

	@Override
	public User getUserByID(String userId) throws ResourceNotFound {
		try {
			LOGGER.debug("Inside UserServiceImpl class Inside  getUserByID Method");
			return userDao.getUserByID(userId);
		} catch (DaoException exception) {
			if (exception.getCause() instanceof NoResultException)
				throw new ResourceNotFound("No User Id FOUND" + userId);
		}
		throw new RestException("Unable To Get User");
	}

}
