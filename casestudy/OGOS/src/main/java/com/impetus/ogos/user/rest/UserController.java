package com.impetus.ogos.user.rest;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.impetus.ogos.exception.ResourceConflictException;
import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.exception.RestException;
import com.impetus.ogos.exception.URIPathException;
import com.impetus.ogos.user.model.User;
import com.impetus.ogos.user.service.IUserService;

/** UserController is handling the action of User. */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	@Autowired
	private HttpSession session;

	@Autowired
	private IUserService userService;

	/**
	 * This method is used for registration of new user.
	 * 
	 * @param user is the object of the user.
	 * @return user object and created status.
	 * @throws ResourceNotFound if user is not added.
	 */
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) throws ResourceNotFound {
		if (user != null) {
			try {
				LOGGER.debug("Inside UserController class Inside  addUser Method");
				userService.addUser(user);
				return new ResponseEntity<>(user, HttpStatus.CREATED);
			} catch (ResourceConflictException e) {
				throw new ResourceConflictException(e.getMessage());
			} catch (RestException restException) {
				throw new RestException(restException.getMessage());
			}
		} else {
			throw new URIPathException();
		}

	}

	/**
	 * By this method Get all user.
	 * 
	 * @return user list
	 * @throws ResourceNotFound if user not found
	 */
	@GetMapping("getAllUsers")
	public ResponseEntity<List<User>> getAllUser() throws ResourceNotFound {
		List<User> list;
		try {
			LOGGER.info("Inside UserController class Inside  getAllUser Method");
			list = userService.getAllUser();
			LOGGER.debug("USER List:" + list);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (ResourceNotFound e) {
			LOGGER.error("User not found" + e);
			throw new ResourceNotFound("User not found:" + e);
		}
	}

	/**
	 * By this method validate the user.
	 * 
	 * @param principal
	 * @return principal and ok status
	 */
	@GetMapping("/signin")
	public ResponseEntity<Principal> validateUser(Principal principal) {
		User user = new User();
		LOGGER.debug("Inside UserController class Inside  validateUser Method");
		session.setAttribute("userid", user.getUserid());
		principal.toString();
		return new ResponseEntity<>(principal, HttpStatus.OK);
	}

	/**
	 * By this method get User by email.
	 * 
	 * @param email is user unique email id
	 * @return user
	 * @throws ResourceNotFound if user not found by email
	 */
	@GetMapping("{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) throws ResourceNotFound {
		if (email != null) {
			try {
				LOGGER.debug("Inside UserController class Inside  getUserByEmail Method");
				User user = userService.getUserByEmail(email);
				return new ResponseEntity<>(user, HttpStatus.OK);
			} catch (ResourceNotFound e) {
				throw new ResourceNotFound(e.getMessage());
			} catch (RestException restException) {
				throw new RestException(restException.getMessage());
			}
		} else {
			throw new URIPathException("userId not found on the path.");
		}

	}

}
