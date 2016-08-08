package org.bildit.model.bo.phone;

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
		
		if(phone != null) {
			try {
				phoneDao.insertPhone(phone);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} else 
			return false;
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

		if(phone != null) {
			try {
				phoneDao.updatePhone(phone);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		} else
			return false;
			
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
