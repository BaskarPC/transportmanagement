package com.service;
import com.vo.UserVO;
import com.dao.LoginDAO;
import java.util.ArrayList;

public class LoginService {

	public ArrayList fetchUser(UserVO userVO)throws Exception
	{
		LoginDAO loginDAO=new LoginDAO();
		ArrayList userList=loginDAO.fetchUser(userVO);
		return userList;
	}
}
