package com.service;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.dao.Accidentdao;
import com.vo.Accidentvo;
public class Accidentservice {
	
	private static final Logger logger=(Logger)Logger.getLogger(Accidentservice.class);
	ArrayList list=new ArrayList();
	Accidentdao ad=new Accidentdao();
	
	public ArrayList combobox()throws Exception
	{ 
		list=ad.combo();
		return list;
	}
	
	public ArrayList comboInsitute()throws Exception
	{ 			
	logger.debug("Accident Insitution inside combo service <---------------------");
	list=ad.comboInstitute();
	logger.debug("outside combo service --------------------->");
	return list;
	}
	
	public ArrayList comboInsitute1()throws Exception
	{ 			
	logger.debug("Accident Insitution inside combo service <---------------------");
	list=ad.comboInstitute1();
	logger.debug("outside combo service --------------------->");
	return list;
	}
	
	public ArrayList combodriverid()throws Exception
	{ 			
	logger.debug("Accident Insitution inside combo service <---------------------");
	list=ad.combodriverid();
	logger.debug("outside combo service --------------------->");
	return list;
	}
	
	public ArrayList combovehicleType()throws Exception
	{ 			
	logger.debug("Accident Insitution inside combo service <---------------------");
	list=ad.combovehicleType();
	logger.debug("outside combo service --------------------->");
	return list;
	}
	
	
	public void save(Accidentvo vo) {
		// TODO Auto-generated method stub
		ad.save(vo);
	}

	public ArrayList vehicletyperetrieve(int instid) {
		// TODO Auto-generated method stub
		list=ad.vehicletyperetrieve(instid);
		return list;
	}

	public ArrayList vehicleidretrieve(int vehicletype) {
		// TODO Auto-generated method stub
		list=ad.vehicleidretrieve(vehicletype);
		return list;
	}

	public ArrayList FIRcombo() {
		// TODO Auto-generated method stub
		list=ad.FIRcombo();
		return list;
	}

	public ArrayList casecombo() {
		// TODO Auto-generated method stub
		list=ad.casecombo();
		return list;
	}

	public ArrayList insurancecombo() {
		// TODO Auto-generated method stub
		list=ad.insurancecombo();
		return list;
	}

	public ArrayList drivernameretrieve(int id) {
		// TODO Auto-generated method stub
		list=ad.drivernameretrieve(id);
		return list;
	}

	public ArrayList driveridcombo() {
		// TODO Auto-generated method stub
		list=ad.driveridcombo();
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=ad.retrieveall();
		return list;
	}

	public ArrayList formvehicleid(int id) {
		// TODO Aut-generated method stub
		list=ad.formvehicleid(id);
		return list;
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		list=ad.retrieve(id);
		return list;
	}

	public ArrayList drivernamedesc(int did) {
		// TODO Auto-generated method stub
		list=ad.drivernamedesc(did);
		return list;
	}

	public ArrayList expensecombo() {
		// TODO Auto-generated method stub
		list=ad.expensecombo();
		return list;
	}

	public ArrayList expensedesc(int expense) {
		// TODO Auto-generated method stub
		list=ad.expensedesc(expense);
		return list;
	}
}
