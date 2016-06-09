package org.bildit.model.bo.phone;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bildit.model.dao.PhoneDao;
import org.bildit.model.dto.Phone;

public class PhoneBoImpl implements PhoneBo {
	
	private PhoneDao phoneDao;

	@Override
	public boolean insertPhone(Phone phone) throws SQLException {
		
		if(phone != null) {
			try {
				if(phoneDao.insertPhone(phone))
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} else 
			throw new SQLException();
	}

	@Override
	public List<Phone> readPhones(String match) {
		
		List<Phone> phones = new ArrayList<>();
		try {
			phones = phoneDao.readPhones(match);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phones;
	}

	@Override
	public Phone readPhone(String name) {

		Phone phone = null;
		try {
			phone = phoneDao.readPhone(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phone;
	}

	@Override
	public boolean updatePhonePrice(Phone phone) throws SQLException {

		if(phone != null) {
			try {
				if(phoneDao.updatePhonePrice(phone))
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} else
			throw new SQLException();
	}


	@Override
	public boolean updatePhoneAmount(Phone phone) throws SQLException {

		if(phone != null) {
			try {
				if(phoneDao.updatePhoneAmount(phone))
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} else
			throw new SQLException();
	}

	@Override
	public boolean deletePhone(Phone phone) throws SQLException {

		if(phone != null) {
			try {
				if(phoneDao.deletePhone(phone)) 
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} else
			throw new SQLException();
	}

}
