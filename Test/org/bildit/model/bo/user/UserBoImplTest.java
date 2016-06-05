package org.bildit.model.bo.user;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.bildit.model.dao.UserDao;
import org.bildit.model.dto.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserBoImplTest {
	
	@Mock
	UserDao userDao;
	UserBoImpl userBo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		userBo = new UserBoImpl();
		userBo.setDao(userDao);
	}

	@After
	public void tearDown() throws Exception {
		userBo = null;
	}

	@Test
	public void createUserShouldCreateUser() throws Exception {
		User user = new User();
		when(userDao.createUser(user)).thenReturn(true);
		
		boolean result = userBo.createUser(user);
		assertTrue(result);
		verify(userDao).createUser(user);
	}

	@Test
	public void createUserShouldNotCreateUser() throws Exception {
		User user = new User();
		when(userDao.createUser(user)).thenReturn(false);
		
		boolean result = userBo.createUser(user);
		assertFalse
		(result);
		verify(userDao).createUser(user);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = SQLException.class)
	public void createUserShouldThrowAnException() throws SQLException {
		User user = null;
		when(userDao.createUser(user)).thenThrow(SQLException.class);
		
		userBo.createUser(user);
	}
	
	
}