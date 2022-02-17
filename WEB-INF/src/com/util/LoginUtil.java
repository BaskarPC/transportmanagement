package com.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dao.LoginDAO;
import com.dbcom.dbcom;
import com.vo.UserVO;

public class LoginUtil {
	dbcom db=new dbcom();
	private static final Logger logger=(Logger)Logger.getLogger(LoginUtil.class);
	public ArrayList fetchUser(UserVO userVO)throws Exception
	{
	ArrayList userArrayList=new ArrayList();
	String query="select USER_NAME as USER_NAME,PASSWORD as PASSWORD from LOGIN";
	userArrayList=db.selectQuery("com.vo.UserVO", query);
	
	for(int i=0 ;i<userArrayList.size();i++)
	{
		UserVO vo=new UserVO();
	vo=(UserVO)userArrayList.get(i);
    
	}
	return userArrayList;
	}
}
