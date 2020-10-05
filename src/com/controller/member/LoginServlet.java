package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");//form에서 userid와 passwd 데이터 파싱
		String passwd = request.getParameter("passwd");
		HashMap<String,String> map = new HashMap();	//map에 저장
		map.put("userid",userid);
		map.put("passwd",passwd);
		
		MemberService service = new MemberService();
		MemberDTO dto = service.login(map);
		String nextPage = "main";
		if(dto!=null) {
			HttpSession session = request.getSession();//session연동
			session.setAttribute("login",dto);//session에 login이라는 이름으로 dto wjwkd
		}else {
			nextPage="LoginUIServlet";//dto가 없으면 LoginUIServlet 으로 이동
		}
		response.sendRedirect(nextPage);//request에 저장한 것이 없으므로 sendRedirect로 화면 위임한다. 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
