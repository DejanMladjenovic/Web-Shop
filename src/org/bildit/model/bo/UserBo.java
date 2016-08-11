package org.bildit.model.bo;

import java.sql.SQLException;

import org.bildit.model.dto.User;

public interface UserBo {
	
	boolean createUser(User user);

	User readUser(String username, String password);

}
