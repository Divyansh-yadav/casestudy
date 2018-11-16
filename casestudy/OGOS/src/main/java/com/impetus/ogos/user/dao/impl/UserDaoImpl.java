package com.impetus.ogos.user.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.user.dao.IUserDao;
import com.impetus.ogos.user.model.User;

/** This class stores the details of the User. */
@Repository
public class UserDaoImpl implements IUserDao {
	static final String DAOEXCEPTION = "Dao Exception";
	static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addUser(User user) throws DaoException {
		try {
			LOGGER.debug("Inside UserDaoImpl class Inside  addUser Method");
			entityManager.persist(user);
			entityManager.flush();
		} catch (PersistenceException persistenceException) {
			LOGGER.error("UserDaoImpl :: Add User ", persistenceException);
			throw new DaoException(persistenceException.getMessage(), persistenceException);
		} catch (Exception exception) {
			LOGGER.error("UserDaoImpl :: addUser " + exception);
			throw new DaoException(exception.getMessage(), exception);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<User> getAllUser() throws DaoException {
		try {
			LOGGER.debug("Inside UserDaoImpl class Inside  getAllUser Method");
			String hql = "FROM User";
			@SuppressWarnings("unchecked")
			List<User> userList = entityManager.createQuery(hql).getResultList();
			LOGGER.debug("uSER lIST:" + userList);
			return userList;
		} catch (Exception exception) {
			LOGGER.error("UserDaoImpl :: Get All User " + exception);
			throw new DaoException(exception.getMessage(), exception);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public User getUserByEmail(String email) throws DaoException {
		User user;
		try {
			LOGGER.debug("Inside UserDaoImpl class Inside  getUserByEmail Method");
			Query query = entityManager.createNamedQuery("find user by email");
			query.setParameter("email", email);
			user = (User) query.getSingleResult();
		} catch (NoResultException noResultException) {
			LOGGER.error("UserDaoImpl :: Get User By Email " + noResultException);
			throw new DaoException(noResultException.getMessage(), noResultException);
		} catch(Exception exception) {
			LOGGER.error("UserDaoImpl :: Get User By Email " + exception);
			throw new DaoException(exception.getMessage(), exception);
		} finally {
			entityManager.close();
		}
		return user;

	}

	@Override
	public User getUserByID(String userId) throws DaoException {
		User user;
		try {
			LOGGER.debug("Inside UserDaoImpl class Inside  getUserByID Method");
			user = entityManager.find(User.class, userId);
		} catch (NoResultException noResultException) {
			LOGGER.error("UserDaoImpl :: Get User By ID " + noResultException);
			throw new DaoException(noResultException.getMessage(), noResultException);
		} catch (Exception exception) {
			LOGGER.error("UserDaoImpl :: Get User By ID " + exception);
			throw new DaoException(exception.getMessage(), exception);
		} finally {
			entityManager.close();
		}
		return user;
	}

}
