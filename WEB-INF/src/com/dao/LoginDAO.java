package com.dao;

import java.sql.*;
import java.util.ArrayList;
import sun.jdbc.odbc.JdbcOdbcDriver;

import org.apache.log4j.Logger;

import com.dbcom.dbcom;
import com.vo.UserVO;

public class LoginDAO {
	private static final Logger logger=(Logger)Logger.getLogger(LoginDAO.class);
	public ArrayList fetchUser(UserVO userVO)throws Exception
	{
		ArrayList userArrayList=new ArrayList();
		dbcom ob=new dbcom();
		String query="select USER_NAME,PASSWORD from LOGIN";
		userArrayList=ob.selectQuery("com.vo.UserVO", query);
		for(int i=0 ;i<userArrayList.size();i++)
		{
			UserVO vo=new UserVO();
		vo=(UserVO)userArrayList.get(i);
	    
		}
		return userArrayList;
	}

}
