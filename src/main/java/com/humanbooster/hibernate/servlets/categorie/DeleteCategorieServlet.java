package com.humanbooster.hibernate.servlets.categorie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.service.ArticleService;
import com.humanbooster.hibernate.service.CategorieService;
import com.humanbooster.hibernate.service.impl.ArticleServiceImpl;
import com.humanbooster.hibernate.service.impl.CategorieServiceImpl;

/**
 * Servlet implementation class DeleteArticleServlet
 */
@WebServlet("/DeleteCategorieServlet")
public class DeleteCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategorieService cs = new CategorieServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCategorie = Integer.parseInt(request.getParameter("delete"));
		Categorie categorie = cs.findById(idCategorie);
		cs.delete(categorie);
		response.sendRedirect(request.getContextPath()+"/index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath()+"/index");
	}

}
