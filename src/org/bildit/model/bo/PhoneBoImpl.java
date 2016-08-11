package org.bildit.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bildit.model.dao.PhoneDao;
import org.bildit.model.dao.PhoneDaoImpl;
import org.bildit.model.dto.Phone;

public class PhoneBoImpl implements PhoneBo {
	
	private PhoneDao phoneDao = new PhoneDaoImpl();

	@Override
	public boolean insertPhone(Phone phone) {
		
		try {
			phoneDao.insertPhone(phone);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Phone> readAllPhones() {
		
		List<Phone> phones = new ArrayList<>();
		try {
			phones = phoneDao.readAllPhones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phones;
	}
	
	@Override
	public List<Phone> readMatchedPhones(String match) {
		
		List<Phone> phones = new ArrayList<>();
		try {
			phones = phoneDao.readMatchedPhones(match);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phones;
	}

	@Override
	public Phone readPhone(int id) {

		Phone phone = null;
		try {
			phone = phoneDao.readPhone(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phone;
	}

	@Override
	public boolean updatePhone(Phone phone) {

		try {
			phoneDao.updatePhone(phone);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
			
	}


	@Override
	public boolean deletePhone(Phone phone) {

		try {
			phoneDao.deletePhone(phone);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
