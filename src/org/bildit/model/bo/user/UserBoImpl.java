package org.bildit.model.bo.user;

import java.sql.SQLException;

import org.bildit.model.dao.UserDao;
import org.bildit.model.dao.UserDaoImpl;
import org.bildit.model.dto.User;

public class UserBoImpl implements UserBo {
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean createUser(User user){
		
		if(user != null) {
			try{
				if(userDao.createUser(user))
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} else
			return false;
	}

	@Override
	public User readUser(String username, String password) {
		
		User user = null;
		
		try{
			user = userDao.readUser(username);
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setDao(UserDao userDao) {
		this.userDao = userDao;
	}
	


}
