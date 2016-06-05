package org.bildit.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.bildit.model.dto.Phone;

public interface PhoneDao {
	
	boolean insertPhone(Phone phone) throws SQLException;
	
	List<Phone> readPhones(String match) throws SQLException;
	
	Phone readPhone(String phone) throws SQLException;
	
	boolean updatePhonePrice(Phone phone) throws SQLException;

	boolean updatePhoneAmount(Phone phone) throws SQLException;
	
	boolean deletePhone(Phone phone) throws SQLException;

}
