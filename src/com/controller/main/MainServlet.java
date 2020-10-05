package com.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//service goodsList("top")으로 카테고리 전송 목록가져오기
		GoodsService service = new GoodsService();
		List<GoodsDTO> list = service.goodsList("top");
		System.out.println(list);
		//가져온 GoodsList를 request에 "goodsList"로 자정
		request.setAttribute("goodsList", list);//request에 설정했으므로 sendRedirect가 아닌 dispatcher사용
		
		//main.jsp로 포워드 
		RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		dis.forward(request, response);
		
		//main.jsp에서 gooodsList.jsp include 하도록 수정 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
