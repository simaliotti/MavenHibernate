package com.humanbooster.hibernate.servlets.categorie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.hibernate.service.CategorieService;
import com.humanbooster.hibernate.service.impl.CategorieServiceImpl;

/**
 * Servlet implementation class DeleteAllServlet
 */
@WebServlet("/DeleteAllCategoriesServlet")
public class DeleteAllCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CategorieService cs = new CategorieServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAllCategoriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===========CA RENTRE ?==============");
		cs.deleteAll2();
		response.sendRedirect(request.getContextPath()+"/index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
