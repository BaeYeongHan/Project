package com.pr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet("*.pr")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		String site = "";
		String uri2 = uri.substring(request.getContextPath().length() + 1);
		if (uri2.equals("main.pr")) {
			site = "MainServlet";
		} else if (uri2.equals("view.pr")) {
			site = "ViewServlet";
		} else if (uri2.equals("member.bay")) {
			site = "MemberServlet";
		}
		
		else {
			site = "잘못된요청";
			
			
		}
		System.out.println(site);
		RequestDispatcher dis = request.getRequestDispatcher(site);
		dis.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
