package com.service;

import java.util.ArrayList;

import com.dao.KeroseneIssueDAO;
import com.vo.KeroseneIssueVO;

public class KeroseneIssueService {
	ArrayList instlist;;
	KeroseneIssueDAO kerosenedao=new KeroseneIssueDAO();
	public ArrayList fetchKeroseneReason()
	{
		instlist=kerosenedao.fetchKeroseneReason();
		return instlist;
	}
	public void insertValues(KeroseneIssueVO kvo,int jobid)
	{
		kerosenedao.insertValues(kvo,jobid);
	}
	public ArrayList fetchValues(int jobid)
	{
		instlist=kerosenedao.fetchValues(jobid);
		return instlist;
	}
	public ArrayList fetchRates(String pid)
	{
		instlist=kerosenedao.fetchRates(pid);
		return instlist;
	}
}
