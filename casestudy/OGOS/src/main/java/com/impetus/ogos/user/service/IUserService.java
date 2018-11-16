package com.impetus.ogos.user.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.impetus.ogos.exception.ResourceNotFound;
import com.impetus.ogos.user.model.User;

/**
 * Define the add,get Abstract method in this interface.
 */
public interface IUserService {
	/**
	 * This method adding the user.
	 * 
	 * @param user is the object of user
	 * @throws ResourceNotFound is an exception thrown when user is not found.
	 */
	
	void addUser(User user) throws ResourceNotFound;
	/**
	 * This method get all the user.
	 * 
	 * @return get all user.
	 * @throws ResourceNotFound if user not found.
	 */
	@Secured({ "ROLE_ADMIN"})
	List<User> getAllUser() throws ResourceNotFound;

	/**
	 * This method get user by email.
	 * 
	 * @param email is user email id.
	 * @return get user by email id
	 * @throws ResourceNotFound is user not found by email.
	 */
	@Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN", "ROLE_SERVICEPROVIDER" })
	User getUserByEmail(String email) throws ResourceNotFound;

	/**
	 * This method get user by userid.
	 * 
	 * @param userId is primary key of user.
	 * @return user by user id.
	 * @throws ResourceNotFound if user not found by user id.
	 */
	@Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN", "ROLE_SERVICEPROVIDER" })
	User getUserByID(String userId) throws ResourceNotFound;

}
