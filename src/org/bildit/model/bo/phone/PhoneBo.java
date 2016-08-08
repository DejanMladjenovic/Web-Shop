package org.bildit.model.bo.phone;

import java.sql.SQLException;
import java.util.List;

import org.bildit.model.dto.Phone;

public interface PhoneBo {
	
	boolean insertPhone(Phone phone) throws SQLException;
	
	List<Phone> readAllPhones();
	
	List<Phone> readMatchedPhones(String match);
	
	Phone readPhone(int id);
	
	boolean updatePhone(Phone phone) ;

	boolean updatePhoneAmount(Phone phone) throws SQLException;

	boolean deletePhone(Phone phone) throws SQLException;
}
