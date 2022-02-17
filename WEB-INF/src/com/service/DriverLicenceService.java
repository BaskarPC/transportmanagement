package com.service;

import java.util.ArrayList;
import com.dao.DriverLicenceDAO;
import com.vo.DriverLicenceVO;;

public class DriverLicenceService {
	DriverLicenceDAO dao =new DriverLicenceDAO();
	ArrayList list=new ArrayList();
	/**
	 * retrieve driver id from database
	 * @param vo
	 * @return list
	 * @throws Exception
	 */
public ArrayList driveridcombo(DriverLicenceVO vo)throws Exception{
	list=dao.driveridcombo(vo);
	return list;	
	}
/**
 * retrieve drivername from database by passing driverid
 * @param id
 * @return list
 */
public ArrayList retrievedrivername(int id) {
	// TODO Auto-generated method stub
	list=dao.retrievedrivername(id);
	return list;
}
/**
 * retrieve licence category
 * @param vo
 * @return list
 */
public ArrayList categorycombo(DriverLicenceVO vo) {
	// TODO Auto-generated method stub
	list=dao.categorycombo(vo);
	return list;
}
/**
 * retrieve endosrsement values 
 * @param vo 
 * @return list
 */
public ArrayList endorsementcombo(DriverLicenceVO vo) {
	// TODO Auto-generated method stub
	list=dao.endorsementcombo(vo);
	return list;
}
/**
 * insert values into database
 * @param vo
 * @throws Exception 
 */
public void insert(DriverLicenceVO vo) throws Exception {
	// TODO Auto-generated method stub
	dao.insert(vo);
	
}
/**
 * insert new values of category
 * @param vo
 */
public void insertothers(DriverLicenceVO vo) {
	// TODO Auto-generated method stub
	dao.insertothers(vo);
	
}
/**
 * retrieve values from database
 * @param id
 * @return
 */
public ArrayList retrieve(int id) {
	// TODO Auto-generated method stub
	list=dao.retrieve(id);
	return list;
}

/**
 * retrieve all values from database
 * @return list
 */
 
 
public ArrayList retrieveall() {
	// TODO Auto-generated method stub
	list=dao.retrieveall();
	return list;
}
/**
 * retrieve id value
 * @param driverId
 * @return list
 */
public ArrayList idretrieve(String driverId) {
	// TODO Auto-generated method stub
	list=dao.idretrieve(driverId);
	return list;
}

public ArrayList retrievecategoryvalues(String string) {
	// TODO Auto-generated method stub
	list=dao.retrievecategoryvalues(string);
	return list;
}
public ArrayList retrieveendorsementvalues(String string) {
	// TODO Auto-generated method stub
	list=dao.retrieveendorsementvalues(string);
	return list;
}
public void update(DriverLicenceVO vo, String driverId) {
	// TODO Auto-generated method stub
	dao.update(vo,driverId);
	
}

}
