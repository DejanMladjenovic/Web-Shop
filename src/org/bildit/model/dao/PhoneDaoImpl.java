package org.bildit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bildit.model.dto.Phone;

public class PhoneDaoImpl implements PhoneDao {
	
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean insertPhone(Phone phone) throws SQLException {
		String query = "INSERT INTO phones (manufacturer, model, operating_system, description, price, amount,"
				+ "picture) VALUES (?,?,?,?,?,?,?)";
		
		try(PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, phone.getManufacturer());
			statement.setString(2, phone.getModel());
			statement.setString(3, phone.getOperating_system());
			statement.setString(4, phone.getDescription());
			statement.setInt(5, phone.getPrice());
			statement.setInt(6, phone.getAmount());
			statement.setString(7, phone.getPicture());
			
			statement.executeUpdate();
		}
		return true;
	}

	@Override
	public List<Phone> readAllPhones() throws SQLException {
		
		List<Phone> phones = new ArrayList<>();
		String query = "SELECT * FROM phones";
		ResultSet rs = null;
		
		try(PreparedStatement statement = connection.prepareStatement(query)) {
			
			rs = statement.executeQuery();
			while(rs.next()) {
				Phone phone = new Phone();
				phone.setPhoneId(rs.getInt("phoneId"));
				phone.setManufacturer(rs.getString("manufacturer"));
				phone.setModel(rs.getString("model"));
				phone.setOperating_system(rs.getString("operating_system"));
				phone.setDescription(rs.getString("description"));
				phone.setPrice(rs.getInt("price"));
				phone.setAmount(rs.getInt("amount"));
				phone.setPicture(rs.getString("picture"));
				phones.add(phone);
			}
		}	
		return phones;
	}
	
	@Override
	public List<Phone> readMatchedPhones(String match) throws SQLException {
		List<Phone> phones = new ArrayList<>();
		String query = "SELECT * FROM phones where manufacturer LIKE ? OR model LIKE ?";
		ResultSet rs = null;
		
		try(PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, "%" + match + "%");
			statement.setString(2, "%" + match + "%");
			
			rs = statement.executeQuery();
			while(rs.next()) {
				Phone phone = new Phone();
				phone.setPhoneId(rs.getInt("phoneId"));
				phone.setManufacturer(rs.getString("manufacturer"));
				phone.setModel(rs.getString("model"));
				phone.setOperating_system(rs.getString("operating_system"));
				phone.setDescription(rs.getString("description"));
				phone.setPrice(rs.getInt("price"));
				phone.setAmount(rs.getInt("amount"));
				phone.setPicture(rs.getString("picture"));
				phones.add(phone);
			}
		}	
		return phones;
	}

	@Override
	public Phone readPhone(int id) throws SQLException {
		
		String query = "SELECT * FROM phones WHERE phoneId=?";
		ResultSet rs = null;
		Phone phone = null;
		
		try(PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			
			rs = statement.executeQuery();
			if(rs.next()) {
				phone = new Phone();
				phone.setPhoneId(rs.getInt("phoneId"));
				phone.setManufacturer(rs.getString("manufacturer"));
				phone.setModel(rs.getString("model"));
				phone.setOperating_system(rs.getString("operating_system"));
				phone.setDescription(rs.getString("description"));
				phone.setPrice(rs.getInt("price"));
				phone.setAmount(rs.getInt("amount"));
				phone.setPicture(rs.getString("picture"));
			}
			rs.close();
		}
		return phone;
	}

	@Override
	public boolean updatePhone(Phone phone) throws SQLException {
		
		String query = "UPDATE phones SET manufacturer=?, model=?, operating_system=?, description =?,"
				+ "price=?, amount=?, picture=? WHERE phoneId=?";
		
		try(PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, phone.getManufacturer());
			statement.setString(2, phone.getModel());
			statement.setString(3, phone.getOperating_system());
			statement.setString(4, phone.getDescription());
			statement.setInt(5, phone.getPrice());
			statement.setInt(6, phone.getAmount());
			statement.setString(7, phone.getPicture());
			statement.setInt(8, phone.getPhoneId());
			
			statement.executeUpdate();
		}
		return true;
	}

	@Override
	public boolean updatePhoneAmount(Phone phone) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePhone(Phone phone) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
