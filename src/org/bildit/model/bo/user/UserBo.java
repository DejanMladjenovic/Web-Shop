package org.bildit.model.bo.user;

import java.sql.SQLException;

import org.bildit.model.dto.User;

public interface UserBo {
	
	boolean createUser(User user) throws SQLException;

	boolean readUser(String username, String password);

}
