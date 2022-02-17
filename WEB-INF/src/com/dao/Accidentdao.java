package com.dao;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.util.OperationsGeneralLookupUtil;
import com.util.AccidentDetailsUtil;
import com.dbcom.dbcom;
import com.vo.Accidentvo;

public class Accidentdao {
	private static final Logger logger=(Logger)Logger.getLogger(Accidentdao.class);
	dbcom o=new dbcom();
	ArrayList list=new ArrayList();
	OperationsGeneralLookupUtil util=new OperationsGeneralLookupUtil();
	String vofile="com.vo.Accidentvo";
	AccidentDetailsUtil accidentutil =new AccidentDetailsUtil();
	Accidentvo vo=new Accidentvo();
	
	public ArrayList combo()throws Exception
	{  
		  String query=util.vehicleNumberQuery();
		  list=o.selectQuery(vofile, query);
		  return list;	
	}
	
	public ArrayList comboInstitute()throws Exception
	{  
		String query=util.institution1Query();
		list=o.selectQuery(vofile, query);
		return list;	
	}
	
	public ArrayList comboInstitute1()throws Exception
	{  
		String query=util.institutionQuery();
		list=o.selectQuery(vofile, query);
	    return list;	
	}
	
	public ArrayList combodriverid()throws Exception
	{  
	   String query=util.driveridQuery();
	   list=o.selectQuery(vofile, query);
	   return list;	
	}
	
	public ArrayList combovehicleType()throws Exception
	{  
		String query=util.vehicleTypeQuery();
		list=o.selectQuery(vofile, query);
		return list;	
	}

	public ArrayList driveridcombo() {
		// TODO Auto-generated method stub
		String query=util.driveridQuery();
		list=o.selectQuery(vofile, query);
		return list;
	}
	
	public ArrayList expensecombo() {
		// TODO Auto-generated method stub
		String query=util.expensecombo();
		list=o.selectQuery(vofile, query);
		return list;
	}

	public void save(Accidentvo vo) {
		// TODO Auto-generated method stub
		accidentutil.save(vo);
	}

	public ArrayList vehicletyperetrieve(int instid) {
		// TODO Auto-generated method stub
		list=accidentutil.vehicletyperetrieve(instid);
		return list;
	}

	public ArrayList vehicleidretrieve(int vehicletype) {
		// TODO Auto-generated method stub
		list=accidentutil.vehicleidretrieve(vehicletype);
		return list;
	}

	public ArrayList FIRcombo() {
		// TODO Auto-generated method stub
		String query=util.optionQuery();
		list=o.selectQuery(vofile, query);
		return list;
	}

	public ArrayList casecombo() {
		// TODO Auto-generated method stub
		String query=util.caseOptionQuery();
		list=o.selectQuery(vofile, query);
		return list;
	}

	public ArrayList insurancecombo() {
		// TODO Auto-generated method stub
		String query=util.insuranceOptionQuery();
		list=o.selectQuery(vofile, query);
		return list;
	}

	public ArrayList drivernameretrieve(int id) {
		// TODO Auto-generated method stub
		list=accidentutil.drivernameretrieve(id);
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=accidentutil.retrieveall();
		return list;
	}

	public ArrayList formvehicleid(int id) {
		// TODO Auto-generated method stub
		list=accidentutil.formvehicleid(id);
		return list;
	}

	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		list=accidentutil.retrieve(id);
		return list;
	}

	public ArrayList drivernamedesc(int did) {
		// TODO Auto-generated method stub
		list=accidentutil.drivernamedesc(did);
		return list;
	}

	public ArrayList expensedesc(int expense) {
		// TODO Auto-generated method stub
		list=accidentutil.expensedesc(expense);
		return list;
	}
}
