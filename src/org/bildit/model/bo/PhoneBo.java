package org.bildit.model.bo;

import java.util.List;

import org.bildit.model.dto.Phone;

public interface PhoneBo {
	
	boolean insertPhone(Phone phone);
	
	List<Phone> readAllPhones();
	
	List<Phone> readMatchedPhones(String match);
	
	Phone readPhone(int id);
	
	boolean updatePhone(Phone phone) ;

	boolean deletePhone(Phone phone);
}
