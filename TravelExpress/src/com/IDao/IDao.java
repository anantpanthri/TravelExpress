package com.IDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.model.Itinerary;

public interface IDao {
	boolean checkUser(String username, String password);
	ArrayList populateRegion();
	void insertUser(String name, String address, String email, String contact,
			String password);
	void updatePassword(String password, String email_id);
	int getUserId(String username);
	List populateAirList();
	List hotelPriceList(Itinerary itobj);
	List populateRailList();
	List populateBusList();
	void populateDependent(String name, String relationship, String sex,
			String age, Integer userId);
	String getUserName(Integer user_ID);
	Double applyoffer(String couponcode);
	void createProcedureRATE_CALCULATION(Itinerary itobj) throws SQLException;
	

}
