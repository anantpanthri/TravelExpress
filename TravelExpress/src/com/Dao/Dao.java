package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.IDao.IDao;
import com.model.Air;
import com.model.Bus;
import com.model.Itinerary;
import com.model.Rail;
import com.model.hoteModel;

public class Dao implements IDao {

	private DataSource dataSource;
	private Connection connection;
	private Statement statement;
	private PreparedStatement pstatement;
	
	public void  populateDataSource() {
	Context initContext;
	try {
		initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		dataSource = (DataSource)envContext.lookup("jdbc/testdb");
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	@Override
	public boolean checkUser(String username, String password) {
		populateDataSource();
		ResultSet resultSet = null;
		try {
			// Get Connection and Statement
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT PASSWORD FROM USERS where email_id= '"+username+"'";
			resultSet = statement.executeQuery(query);
			if(resultSet!=null ) {
				while(resultSet.next()){
					if (password.equals(resultSet.getString(1)))
						return true;
				}
							
			}
			else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=statement)statement.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=connection)connection.close();} catch (SQLException e) 
			{e.printStackTrace();}
		}
		return false;
	}
	@Override
	public ArrayList populateRegion() {
		populateDataSource();
		ArrayList regionList= new ArrayList();
		ResultSet resultSet = null;
		try {
			// Get Connection and Statement
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "select city from region order by city";
			resultSet = statement.executeQuery(query);
			if(resultSet!=null ) {
				while(resultSet.next()){
					regionList.add(resultSet.getString(1));
					
				}
				return 	regionList;		
			}
			else{
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=statement)statement.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=connection)connection.close();} catch (SQLException e) 
			{e.printStackTrace();}
		}
		
		return null;
	}
	@Override
	public void insertUser(String name, String address, String email,
			String contact, String password) {
		populateDataSource();
		//cannot use create statements on Auto_Increement
		try {
			connection = dataSource.getConnection();
			pstatement = connection.prepareStatement("INSERT INTO USERS VALUES(USERS_ID_SEQ.nextval,?,?,?,?,?)");
			pstatement.setString(1,name);
			pstatement.setString(2,address);
			pstatement.setString(3,email);
			pstatement.setString(4,contact);
			pstatement.setString(5,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	String query = "INSERT INTO USERS VALUES(USERS_ID_SEQ.nextval,'"+name+"','"+address+"','"+email+"','"+contact+"','"+password+"');";
		
		try {
			pstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updatePassword(String password,String email_id) {
		populateDataSource();
		try {
			connection = dataSource.getConnection();
			pstatement = connection.prepareStatement("UPDATE users SET password=? WHERE email_id= ? ");
			pstatement.setString(1,password);
			pstatement.setString(2,email_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public int getUserId(String username) {
		populateDataSource();
		int user_id=0;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		String query = "select user_id from users where email_id='"+username+"'";
		try {
			resultSet = statement.executeQuery(query);
			if(resultSet!=null ) {
				while(resultSet.next()){
					user_id=resultSet.getInt(1);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user_id;
		
	}
	@Override
	public List populateAirList() {
		populateDataSource();
		List<Air>air=new ArrayList<Air>();
		ResultSet resultSet = null;
		try {
			
			// Get Connection and Statement 
			connection = dataSource.getConnection();
			statement = connection.createStatement();
String query = "select service_name, price_per_mile from temptable where mode_id in (select mode_id from mode_of_transport where mode_type = 'Air')";
			resultSet = statement.executeQuery(query); 
			if(resultSet!=null ) {
				while(resultSet.next()){
					Air airmodel= new Air();
					airmodel.setService_name(resultSet.getString(1));
					airmodel.setPrice_per_mile(Integer.parseInt(resultSet.getString(2).substring(0, 3)));
					air.add(airmodel);
				}
						
			}
			for(Air a: air){
				
			}
			
			return 	air;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=statement)statement.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=connection)connection.close();} catch (SQLException e) 
			{e.printStackTrace();}
		}
		
		return null;
	}
	@Override
	public List hotelPriceList(Itinerary itobj) {
		populateDataSource();
		ArrayList hotelPriceList= new ArrayList();
		ResultSet resultSet = null;
		itobj.getDEPARTURE_CITY();
		try {
			// Get Connection and Statement
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			List<hoteModel>hp=new ArrayList<hoteModel>();
			String query = "select hotel.hotel_name,hotel.price_per_night,hotel.address_line1,hotel.user_ratings from hotel hotel inner join region region on hotel.region_id=region.region_id where region.city='"+itobj.getARRIVAL_CITY()+"'order by user_ratings desc";         
			resultSet = statement.executeQuery(query);
			
			if(resultSet!=null ) {
				
				while(resultSet.next()){
					hoteModel hotmod = new hoteModel();
					/*hotelPriceList.add(resultSet.getString(1));
					hotelPriceList.add(resultSet.getInt(2));
					hotelPriceList.add(resultSet.getString(3));
					hotelPriceList.add(resultSet.getInt(4));*/
					hotmod.setHotel_name(resultSet.getString(1));
					hotmod.setPrice_per_night(resultSet.getInt(2));
					hotmod.setAddress_line1(resultSet.getString(3));
					hotmod.setUser_ratings(resultSet.getInt(4));
					hp.add(hotmod);
				}
				
					
			}
			return 	hp;	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=statement)statement.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=connection)connection.close();} catch (SQLException e) 
			{e.printStackTrace();}
		}
		
		return null;
		
		
		
		
	}
	@Override
	public List populateRailList() {
		populateDataSource();
		List<Rail>air=new ArrayList<Rail>();
		ResultSet resultSet = null;
		try {
			
			// Get Connection and Statement 
			connection = dataSource.getConnection();
			statement = connection.createStatement();
String query = "select service_name,price_per_mile from temptable where mode_id in (select mode_id from mode_of_transport where mode_type LIKE 'Train')";
			resultSet = statement.executeQuery(query); 
			if(resultSet!=null ) {
				while(resultSet.next()){
					Rail airmodel= new Rail();
					airmodel.setService_name(resultSet.getString(1));
					airmodel.setPrice_per_mile(resultSet.getString(2).substring(0,3));
					air.add(airmodel);
				}
						
			}
			return 	air;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=statement)statement.close();} catch (SQLException e) 
			{e.printStackTrace();}
			try { if(null!=connection)connection.close();} catch (SQLException e) 
			{e.printStackTrace();}
		}
		
		return null;
	}
	@Override
	public List populateBusList() {
	populateDataSource();
	List<Bus>air=new ArrayList<Bus>();
	ResultSet resultSet = null;
	try {
		
		// Get Connection and Statement 
		connection = dataSource.getConnection();
		statement = connection.createStatement();
String query = "select service_name,price_per_mile from temptable where mode_id in (select mode_id from mode_of_transport where mode_type LIKE 'Road')";
		resultSet = statement.executeQuery(query); 
		if(resultSet!=null ) {
			while(resultSet.next()){
				Bus airmodel= new Bus();
				airmodel.setService_name(resultSet.getString(1));
				airmodel.setPrice_per_mile(resultSet.getString(2).substring(0,3));
				air.add(airmodel);
			}
					
		}
		return 	air;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
		{e.printStackTrace();}
		try { if(null!=statement)statement.close();} catch (SQLException e) 
		{e.printStackTrace();}
		try { if(null!=connection)connection.close();} catch (SQLException e) 
		{e.printStackTrace();}
	}
	
	return null;}
	@Override
	public void populateDependent(String name, String relationship, String sex,
			String age, Integer userId) {

		populateDataSource();
		try {
			connection = dataSource.getConnection();
			pstatement = connection.prepareStatement("insert into DEPENDENT_DETAILS values (?,?,?,?,?)");
			pstatement.setInt(1,userId);
			pstatement.setString(2,name);
			pstatement.setString(3,relationship);
			pstatement.setString(4,sex);
			pstatement.setInt(5,Integer.parseInt(age));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	@Override
	public String getUserName(Integer user_ID) {

		populateDataSource();
		String username=null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		String query = "select name from users where user_id='"+user_ID+"'";
		try {
			resultSet = statement.executeQuery(query);
			if(resultSet!=null ) {
				while(resultSet.next()){
					username=resultSet.getString(1);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return username;
		
	
	}
	@Override
	public Double applyoffer(String couponcode) {

		populateDataSource();
		double discount_offered=0;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		String query = "select discount_offered from offers where offer_code='"+couponcode+"'";
		try {
			resultSet = statement.executeQuery(query);
			if(resultSet!=null ) {
				while(resultSet.next()){
					discount_offered=Double.parseDouble(resultSet.getString(1));
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return discount_offered;
		
	
	}
	/*	
*/
	
	@Override
	public void
    createProcedureRATE_CALCULATION(Itinerary itobj)
    throws SQLException {
    String createProcedure = null;
    populateDataSource();
    connection = dataSource.getConnection();
    String var;
    if(itobj.getMODE_OF_TRANSPORT().equals("Air"))
    	var="Air";
    if(itobj.getMODE_OF_TRANSPORT().equals("Road"))
    	var="Road";
    if(itobj.getMODE_OF_TRANSPORT().equals("Rail"))
    	var="Air";

    createProcedure =
        "begin rate_calculation ('"+itobj.getDEPARTURE_CITY()+"', '"+itobj.getARRIVAL_CITY()+"','"+itobj.getMODE_OF_TRANSPORT()+"');"+
        		"end;" ;
    
    Statement stmt = null;
     Statement stmtDrop = null;

   

    try {
        stmt = connection.createStatement();
        stmt.executeUpdate(createProcedure);
    } catch (SQLException e) {
    	e.printStackTrace();
    } finally {
        if (stmt != null) { stmt.close(); }
    }
}
/*
 * create or replace PROCEDURE RATE_CALCULATION " +
        "(  FROM_CITY IN VARCHAR2	, TO_CITY IN VARCHAR2	, MODE_SELECT IN VARCHAR2	) " +
        "AUTHID CURRENT_USER AS	lat1 number; " +
    "lon1 number; " +
	"lat2 number; " +
	"lon2 number; " +
	"dist number; " +
	"var0 varchar2(4000); " +
	"var1 varchar2(4000);  " +
	"BEGIN "+
	"select lattitude into lat1 from region where city= '"+itobj.getARRIVAL_CITY()+"'; "+
	"select longitude into lon1 from region where city= '"+itobj.getARRIVAL_CITY()+"'; " +
	"select lattitude into lat2 from region where city='"+itobj.getDEPARTURE_CITY()+"';  "+
	"select longitude into lon2 from region where city='"+itobj.getDEPARTURE_CITY()+"';  "+
	"dist:=DISTANCE(lat1,lon1,lat2,lon2); "+
"	var0:='Drop table TempTable'; "+
"	EXECUTE IMMEDIATE var0; "+
"	case "+ 
	" when MODE_SELECT='Air' then var1:='Create table TempTable as select * from Mode_Air'; "+
	" when MODE_SELECT='Rail' then var1:='Create table TempTable as select * from Mode_Train'; " +
	" when MODE_SELECT='Bus' then var1:='Create table TempTable as select * from Mode_Road'; "  +
	" end case; " +
	" EXECUTE IMMEDIATE var1; " +
	" Update TempTable set Price_per_mile=Price_per_mile*dist; " +
	" END RATE_CALCULATION; 
 */
	
}
