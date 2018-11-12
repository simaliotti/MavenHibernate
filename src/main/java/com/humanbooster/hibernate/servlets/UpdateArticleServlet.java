package com.humanbooster.hibernate.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.service.ArticleService;
import com.humanbooster.hibernate.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class UpdateArticleServlet
 */
@WebServlet("/UpdateArticleServlet")
public class UpdateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService as = new ArticleServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idArticle = Integer.parseInt(request.getParameter("update"));

		Article article = as.chercherArticleParId(idArticle);
		request.setAttribute("article", article);
		this.getServletContext().getRequestDispatcher("/updateArticleForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		String designation = request.getParameter("designation");
		int nbPoints = Integer.parseInt(request.getParameter("nbPoints"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		// String categorieName = request.getParameter("categorieName");

		Article article = new Article();
		article.setDesignation(designation);
		article.setNbPoints(nbPoints);
		article.setStock(stock);
		article.setIdArticle(idArticle);
		
		as.updateArticle(article);
		
		
		response.sendRedirect(request.getContextPath()+"/ArticlesServlet");
	}

}
