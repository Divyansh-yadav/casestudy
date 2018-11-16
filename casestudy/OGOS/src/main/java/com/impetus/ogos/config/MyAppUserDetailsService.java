package com.impetus.ogos.config;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.impetus.ogos.exception.DaoException;
import com.impetus.ogos.user.dao.IUserDao;
import com.impetus.ogos.user.model.User;

/**
 * Service class for checking the existence of user.
 */
@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserDao userDAO;

	/** Static Initializer. */
	private static final Logger LOGGER = Logger.getLogger(MyAppUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String userName) {
		LOGGER.debug(" username for request... " + userName);
		User activeUserInfo;
		try {
			activeUserInfo = userDAO.getUserByEmail(userName);
			if (activeUserInfo == null) {
				throw new UsernameNotFoundException("Invalid Credentials.");
			}
			GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
			return new MyUserDetails(activeUserInfo.getUserid(), activeUserInfo.getEmail(),
					activeUserInfo.getUserName(), activeUserInfo.getPassword(), Arrays.asList(authority),
					activeUserInfo.isIsactive());
		} catch (DaoException e) {
			return null;
		}

	}
}
