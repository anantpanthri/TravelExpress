package com.Business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Dao.Dao;
import com.IBusiness.Ibusiness;
import com.IDao.IDao;
import com.model.Itinerary;

public class businessLayer implements Ibusiness {
	
	private IDao dao;

	@Override
	public boolean checkUser(String username, String password) {
		dao= new Dao();
		if(dao.checkUser(username, password))
			return true;
		else
		return false;
				
	}

	@Override
	public ArrayList populateRegion() {
		dao= new Dao();
		if(dao.populateRegion()!=null)
			return dao.populateRegion();
		else
		return null;
	}

	@Override
	public void insertUser(String name, String address, String email,
			String contact, String password) {
		dao= new Dao();
		dao.insertUser(name,address,email,contact,password);
		
	}

	@Override
	public void updatePassword(String password,String email_id) {
		dao= new Dao();
		dao.updatePassword(password,email_id);
		
	}

	@Override
	public int getUserId(String username) {
		// TODO Auto-generated method stub
		dao= new Dao();
		int user_id=dao.getUserId(username);
		return user_id;
	}

	@Override
	public List populateAirList() {
		// TODO Auto-generated method stub
		dao= new Dao();
		if(dao.populateAirList()!=null)
			return dao.populateAirList();
		else
		return null;
	}

	@Override
	public List hotelPriceList(Itinerary itobj) {
		// TODO Auto-generated method stub
		dao= new Dao();
		if(dao.hotelPriceList(itobj)!=null)
			return dao.hotelPriceList(itobj);
		else
		return null;
		}

	@Override
	public List populateRailList() {
		// TODO Auto-generated method stub
		dao= new Dao();
		if(dao.populateRailList()!=null)
			return dao.populateRailList();
		else
		return null;
	}

	@Override
	public List populateBusList() {
		// TODO Auto-generated method stub
		dao= new Dao();
		if(dao.populateBusList()!=null)
			return dao.populateBusList();
		else
		return null;
	}

	@Override
	public void populateDependent(String name, String relationship, String sex,
			String age,Integer userId) {
		dao= new Dao();
		dao.populateDependent(name,relationship,sex,age,userId);
		
	}

	@Override
	public String getUserName(Integer user_ID) {
		dao= new Dao();
		
		return dao.getUserName(user_ID);
	}

	@Override
	public Double applyoffer(String couponcode) {
			dao= new Dao();
		
		return dao.applyoffer(couponcode);
	}

	@Override
	public void createProcedureRATE_CALCULATION(Itinerary itobj) {
		dao= new Dao();
		
		 try {
			dao.createProcedureRATE_CALCULATION(itobj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
