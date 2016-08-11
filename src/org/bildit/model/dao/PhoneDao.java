package org.bildit.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.bildit.model.dto.Phone;

public interface PhoneDao {
	
	void insertPhone(Phone phone) throws SQLException;
	
	List<Phone> readAllPhones() throws SQLException;
	
	List<Phone> readMatchedPhones(String match) throws SQLException;
	
	Phone readPhone(int id) throws SQLException;
	
	void updatePhone(Phone phone) throws SQLException;
	
	void deletePhone(Phone phone) throws SQLException;

}
