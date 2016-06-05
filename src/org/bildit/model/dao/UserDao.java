package org.bildit.model.dao;

import java.sql.SQLException;

import org.bildit.model.dto.User;

public interface UserDao {

	boolean createUser(User user) throws SQLException;
	
	User readUser(String username) throws SQLException;
}
