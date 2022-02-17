package com.service;

import java.util.ArrayList;

import com.dao.WasteDAO;
import com.vo.WasteVO;

public class WasteService {
	ArrayList instlist;;
	WasteDAO wastedao=new WasteDAO();
	public ArrayList fetchWasteReason()
	{
		instlist=wastedao.fetchWasteReason();
		return instlist;
	}
	public void insertValues(WasteVO kvo,int jobid)
	{
		wastedao.insertValues(kvo,jobid);
	}
	
}
