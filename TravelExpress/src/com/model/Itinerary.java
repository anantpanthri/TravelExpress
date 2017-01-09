package com.model;

import java.util.Date;

public class Itinerary {
	
private Integer	ITINERARY_ID;                
private Integer	USER_ID;                              
private String	DEPARTURE_CITY;                 
private String	ARRIVAL_CITY;                  
private String	TRVAL_TYPE;     //travel price               
private Date	DATE_OF_DEPARTURE;                     
private Date	DATE_OF_RETURN;                       
private String	MODE_OF_TRANSPORT;  //travelname            
private Integer	NUMBER_OF_DEPENDENTS;
private String	HOTEL_NAME;
private String	HOTEL_PRICE;

public Integer getITINERARY_ID() {
	return ITINERARY_ID;
}
public void setITINERARY_ID(Integer iTINERARY_ID) {
	ITINERARY_ID = iTINERARY_ID;
}
public Integer getUSER_ID() {
	return USER_ID;
}
public void setUSER_ID(Integer uSER_ID) {
	USER_ID = uSER_ID;
}
public String getDEPARTURE_CITY() {
	return DEPARTURE_CITY;
}
public void setDEPARTURE_CITY(String dEPARTURE_CITY) {
	DEPARTURE_CITY = dEPARTURE_CITY;
}
public String getARRIVAL_CITY() {
	return ARRIVAL_CITY;
}
public void setARRIVAL_CITY(String aRRIVAL_CITY) {
	ARRIVAL_CITY = aRRIVAL_CITY;
}
public String getTRVAL_TYPE() {
	return TRVAL_TYPE;
}
public void setTRVAL_TYPE(String tRVAL_TYPE) {
	TRVAL_TYPE = tRVAL_TYPE;
}
public Date getDATE_OF_DEPARTURE() {
	return DATE_OF_DEPARTURE;
}
public void setDATE_OF_DEPARTURE(Date dATE_OF_DEPARTURE) {
	DATE_OF_DEPARTURE = dATE_OF_DEPARTURE;
}
public Date getDATE_OF_RETURN() {
	return DATE_OF_RETURN;
}
public void setDATE_OF_RETURN(Date dATE_OF_RETURN) {
	DATE_OF_RETURN = dATE_OF_RETURN;
}
public String getMODE_OF_TRANSPORT() {
	return MODE_OF_TRANSPORT;
}
public void setMODE_OF_TRANSPORT(String mODE_OF_TRANSPORT) {
	MODE_OF_TRANSPORT = mODE_OF_TRANSPORT;
}
public Integer getNUMBER_OF_DEPENDENTS() {
	return NUMBER_OF_DEPENDENTS;
}
public void setNUMBER_OF_DEPENDENTS(Integer nUMBER_OF_DEPENDENTS) {
	NUMBER_OF_DEPENDENTS = nUMBER_OF_DEPENDENTS;
}
/**
 * @return the hOTEL_NAME
 */
public String getHOTEL_NAME() {
	return HOTEL_NAME;
}
/**
 * @param hOTEL_NAME the hOTEL_NAME to set
 */
public void setHOTEL_NAME(String hOTEL_NAME) {
	HOTEL_NAME = hOTEL_NAME;
}
/**
 * @return the hOTEL_PRICE
 */
public String getHOTEL_PRICE() {
	return HOTEL_PRICE;
}
/**
 * @param hOTEL_PRICE the hOTEL_PRICE to set
 */
public void setHOTEL_PRICE(String hOTEL_PRICE) {
	HOTEL_PRICE = hOTEL_PRICE;
}




}
