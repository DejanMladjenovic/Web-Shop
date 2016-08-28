package org.bildit.model.bo;

import org.bildit.model.dto.User;

public interface UserBo {
	
	boolean createUser(User user);

	User readUser(String username, String password);

}
