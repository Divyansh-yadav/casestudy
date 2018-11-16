package com.impetus.ogos.user.dao;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.user.model.User;

/**
 * It is an interface. This class holds the method that interacts with the User
 * table.
 */
public interface IUserDao {
	/**This method add the user.
	 * @param user is object of user.
	 * @throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException 
	 * @throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException 
	 */
	void addUser(User user) throws DaoException;

	/**This method fetches all the user.
	 * @return List of user.
	 * @throws DaoException if any exception occur in dao class.
	 */
	@Secured({ "ROLE_ADMIN" })
	List<User> getAllUser() throws DaoException;

	/**This method fetches the user by email id.
	 * @param email is user email id.
	 * @return user by email.
	 * @throws DaoException if any exception occur in dao class.
	 */
	User getUserByEmail(String email) throws DaoException;

	/**This method fetches the user by userid.
	 * @param userId is primary key of user.
	 * @return user by userid
	 * @throws DaoException if any exception occur in dao class.
	 */
	User getUserByID(String userId) throws DaoException;
}