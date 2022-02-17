package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.DieselRequisitionDAO;
import com.dao.PaintRequisitionDAO;
import com.vo.DieselRequisitionVO;
import com.vo.PaintRequisitionVO;

public class PaintRequisitionService {
	private static final Logger logger=(Logger)Logger.getLogger(PaintRequisitionService.class);
	ArrayList list=null;
	PaintRequisitionDAO dao=new PaintRequisitionDAO();
	public ArrayList fetchbrandlist()
	{
		list=dao.fetchbrandlist();
		return list;
	}
	public ArrayList fetchbrandtype(String code)
	{
		list=dao.fetchtypelist(code);
		return list;
	}
	public ArrayList fetchAvailableQty(int brandname,int brandtype)
	{ 
		
		ArrayList instlist=dao.fetchAvailbaleQty(brandname,brandtype);
		return instlist;
	}
}
