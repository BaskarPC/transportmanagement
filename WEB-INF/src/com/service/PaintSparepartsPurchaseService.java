package com.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.PaintSparepartsPurchaseDAO;
import com.dao.PaintSparepartsPurchaseDAO;

public class PaintSparepartsPurchaseService {
	ArrayList instlist;
	PaintSparepartsPurchaseDAO sparepartdao=new PaintSparepartsPurchaseDAO();
	private static final Logger logger=(Logger)Logger.getLogger(PaintSparepartsPurchaseService.class);
	/**
	 * to fetch values from db to display in form
	 * @param job
	 * @return
	 */

	public ArrayList fetchValues(int job )
	{
		instlist=sparepartdao.fetchValues(job);
		return instlist;
	}
	public void insertCommon(String pid,int brandtype,int qty,float price)
	{
		sparepartdao.insertCommon(pid,brandtype,qty,price);
	}
	public void updateValues(String pid,int oldavail,int newavail,float oldrate,float newrate)
	{
		sparepartdao.updateValues(pid,oldavail,newavail,oldrate,newrate);
	}
	public ArrayList fetchBillNumber()
	{
		instlist=sparepartdao.fetchBillNumber();
		return instlist;
	}
	public void insertSupplierValues(int jobid,String billdt,int billno,String deldt,int compname,int place,int goodstype)
	{
		sparepartdao.insertSupplierValues(jobid,billdt,billno,deldt,compname,place,goodstype);
	}
	public void insertCommonValues(int jobid,int brandtype,int pid,int qty)
	{
		sparepartdao.insertCommonValues(jobid,brandtype,pid,qty);
	}
	public void insertAmountValues(int jobid,int qty,int rate,int vatpercent,int vatamt,int addamt,int amt,int tot)
	{
		sparepartdao.insertAmountValues(jobid,qty,rate,vatpercent,vatamt,addamt,amt,tot);
	}
}
