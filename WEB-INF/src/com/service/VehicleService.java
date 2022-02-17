package com.service;
import java.util.ArrayList;
import org.apache.log4j.Logger;


import com.dao.VehicleDao;
import com.util.*;


import com.vo.VehicleVo;



public class VehicleService {
	private static final Logger logger=(Logger)Logger.getLogger(VehicleService.class);
	ArrayList list=new ArrayList();
	VehicleDao dao=new VehicleDao();
	commonquery co=new commonquery();
	
	public ArrayList combobox(VehicleVo vo)throws Exception
	{
		list=dao.combo(vo);
	    return list;
	}
	
	public ArrayList combvstatus(VehicleVo vo)throws Exception
	{
		list=dao.combovstatus(vo);
	    return list;
	}
	public ArrayList comboroadtax(VehicleVo vo)throws Exception
	{
		list=dao.comboroadtax(vo);
	    return list;
	}
	
	public ArrayList comboInstitution()throws Exception
	{
		list=dao.comboInstitution();
	    return list;
	}
	public ArrayList retrieve(int id) {
		// TODO Auto-generated method stub
		list=dao.retrieve(id);
		return list;
	}
	
	
	public void lookupinsertins(String ins) {
		// TODO Auto-generated method stub		
		co.lookupinsertins(ins);
		
	}
	public void lookupinsertvType(String vtype) {
		// TODO Auto-generated method stub
		co.lookupinsertvType(vtype);
		
		
	}
	public void save(VehicleVo vo) {
		// TODO Auto-generated method stub		
		dao.save(vo);
		
	}

	public ArrayList insurancecombo() {
		// TODO Auto-generated method stub
		list=dao.insurancecombo();
		return list;
	}

	public ArrayList vehicletypecombo() {
		// TODO Auto-generated method stub
		list=dao.vehicletypecombo();
		return list;
	}

	public ArrayList retrieveall() {
		// TODO Auto-generated method stub
		list=dao.retrieveall();
		return list;
	}

	public ArrayList vehicledesc(int vehicleid) {
		// TODO Auto-generated method stub
		list=dao.vehicledesc(vehicleid);
		return list;
	}

	public ArrayList convert(String vehicleid) {
		// TODO Aut-generated method stub
		list=dao.convert(vehicleid);
		return list;
	}

	public ArrayList vehicledel(String str) {
		// TODO Auto-generated method stub
		list=dao.vehicledel(str);
		return list;
	}

	public void update(VehicleVo vo,String vehicleId) {
		// TODO Auto-generated method stub
		dao.update(vo,vehicleId);
		
	}
}

