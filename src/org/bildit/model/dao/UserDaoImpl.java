package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bildit.model.dto.User;

public class UserDaoImpl implements UserDao {
	
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public void createUser(User user) throws SQLException {
		
		String query = "INSERT INTO users(username, password, firstName, lastName, address, phoneNumber) "
				+ "VALUES(?,?,?,?,?,?)";
		
		try(PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getPhoneNumber());
			
			statement.executeUpdate();
		}
	}

	@Override
	public User readUser(String username) throws SQLException{

		User user = null;
		ResultSet rs = null;
		String query = "SELECT * FROM users WHERE username=?";
		
		try(PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			
			rs = statement.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setAddress(rs.getString("address"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
			}
			rs.close();
		}
		return user;
	}
}
