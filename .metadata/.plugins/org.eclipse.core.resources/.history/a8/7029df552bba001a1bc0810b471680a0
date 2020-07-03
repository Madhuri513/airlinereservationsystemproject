package com.jfsfeb.airlinereservationsystem.factory;

import com.jfsfeb.airlinereservationsystem.dao.AdminDAO;
import com.jfsfeb.airlinereservationsystem.dao.AdminDAOImple;
import com.jfsfeb.airlinereservationsystem.dao.UserDAO;
import com.jfsfeb.airlinereservationsystem.dao.UserDAOImple;
import com.jfsfeb.airlinereservationsystem.services.AdminServices;
import com.jfsfeb.airlinereservationsystem.services.AdminServicesImple;
import com.jfsfeb.airlinereservationsystem.services.UserServices;
import com.jfsfeb.airlinereservationsystem.services.UserServicesImple;
import com.jfsfeb.airlinereservationsystem.validations.AirlineValidations;
import com.jfsfeb.airlinereservationsystem.validations.Validation;

public class UserFactory {
	
	private UserFactory() {
	}

	public static AdminDAO getAdminDAOImpleInstance() {
		AdminDAO dao = new AdminDAOImple();
		return dao;
	}

	public static UserDAO getUserDAOImpleInstance() {
		UserDAO userDao = new UserDAOImple();
		return userDao;
	}

	public static AdminServices getAdminServicesImpleInstance() {
		AdminServices adminServices = new AdminServicesImple();
		return adminServices;
	}

	public static UserServices getUserServicesImpleInstance() {
		UserServices userServices = new UserServicesImple();
		return userServices;
	}

	public static AirlineValidations getValidationInstance() {
		AirlineValidations validation = new Validation();
		return validation;
	}
	
	

}
