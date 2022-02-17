package com.util;
import java.util.ArrayList;

import com.dbcom.dbcom;
//import com.vo.Accidentvo;
import com.vo.VehicleVo;
import org.apache.log4j.Logger;
public class commonquery {
	private static final Logger logger=(Logger)Logger.getLogger(commonquery.class);
	VehicleVo vo=new VehicleVo();
	
	public void lookupinsertins(String ins) {
		// TODO Auto-generated method stub		
		//inserting institution into lookup
		ArrayList list=new ArrayList();
		dbcom db=new dbcom();
		VehicleVo vo1=new VehicleVo();
		String seqidquery="select max(CODE) as SEQID from lookup";						
		list=db.selectQuery("com.vo.VehicleVo", seqidquery);		
		vo1=(VehicleVo)list.get(0);
		//vo1=(VehicleVo)list.get(0);
	
		int seq=Integer.parseInt(vo1.getSeqid())+1;				   
		db.otherQuery("insert into lookup values("+seq+",'institution','"+ins+"')");
		logger.debug("institution"+"insert into lookup values("+seq+",'institution','"+ins+"')");		
		
	}
	public void lookupinsertvType(String vtype) {
		// TODO Auto-generated method stub		
		//inserting vehicletype into lookup
		logger.debug("insert vehicle type into lookup");
		ArrayList list1=new ArrayList();
		dbcom db1=new dbcom();
		VehicleVo vo2=new VehicleVo();
		String seqidquery="select max(CODE) as SEQID from lookup";						
		list1=db1.selectQuery("com.vo.VehicleVo", seqidquery);		
		vo2=(VehicleVo)list1.get(0);		
		int seq=Integer.parseInt(vo2.getSeqid())+1;				   
		db1.otherQuery("insert into lookup values("+seq+",'vehicletype','"+vtype+"')");
		logger.debug("institution"+"insert into lookup values("+seq+",'vehicletype','"+vtype+"')");		
		
	}
	
	
}
