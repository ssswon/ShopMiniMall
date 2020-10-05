<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MemberDTO userLogin =(MemberDTO)session.getAttribute("login");
	if(userLogin !=null){
%>
<p>환영합니다. <%=userLogin.getUsername() %>님!</p>
<a href="LogoutServlet">로그아웃</a>
<a href="">mypage</a>
<a href="">장바구니</a>
<%} else{ %>
<a href="loginForm.jsp">로그인</a>
<a href="MemberUIServlet">회원가입</a>
<a href="">장바구니</a>
<a href="">mypage</a>
<%} %>



