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
 * Servlet implementation class findArticleServlet
 */
@WebServlet("/FindArticleServlet")
public class FindArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleService as = new ArticleServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/findArticleForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * String designation = request.getParameter("designation"); int idArticle = -1;
		 * try { idArticle = Integer.parseInt(request.getParameter("id")); } catch
		 * (Exception e) {
		 * 
		 * } String searchByDesignation = request.getParameter("searchByDesignation");
		 * 
		 * if (designation.isEmpty()) {
		 * 
		 * Article article = as.chercherArticleParId(idArticle);
		 * 
		 * if (null != article) { request.setAttribute("article", article);
		 * this.getServletContext().getRequestDispatcher("/findArticle.jsp").forward(
		 * request, response); } else { String msg =
		 * "L'article que vous venez de chercher n'existe pas. Id inconnu";
		 * request.setAttribute("msg", msg);
		 * this.getServletContext().getRequestDispatcher("/findArticleForm.jsp").forward
		 * (request, response); }
		 * 
		 * } else { try { Article article =
		 * as.chercherArticleParDesignation(designation);
		 * request.setAttribute("article", article);
		 * this.getServletContext().getRequestDispatcher("/findArticle.jsp").forward(
		 * request, response); } catch (Exception e) { String msg =
		 * "L'article que vous venez de chercher n'existe pas. Designation inconnue";
		 * request.setAttribute("msg", msg);
		 * this.getServletContext().getRequestDispatcher("/findArticleForm.jsp").forward
		 * (request, response); }
		 * 
		 * }
		 */

		String designation = request.getParameter("designation");
		int idArticle = -1;
		try {
			idArticle = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {

		}
		String searchByDesignation = request.getParameter("searchByDesignation");

		if (!(designation.isEmpty())) {
			try {
				Article article = as.chercherArticleParDesignation(designation);
				request.setAttribute("article", article);
				this.getServletContext().getRequestDispatcher("/findArticle.jsp").forward(request, response);
			} catch (Exception e) {
				String msg = "L'article que vous venez de chercher n'existe pas. Designation inconnue";
				request.setAttribute("msg", msg);
				this.getServletContext().getRequestDispatcher("/findArticleForm.jsp").forward(request, response);
			}

		} else if (idArticle != -1) {
			Article article = as.chercherArticleParId(idArticle);

			if (null != article) {
				request.setAttribute("article", article);
				this.getServletContext().getRequestDispatcher("/findArticle.jsp").forward(request, response);
			} else {
				String msg = "L'article que vous venez de chercher n'existe pas. Id inconnu";
				request.setAttribute("msg", msg);
				this.getServletContext().getRequestDispatcher("/findArticleForm.jsp").forward(request, response);
			}

		} else {

			try {
				Article article = as.searchByDesignation(searchByDesignation);
				request.setAttribute("article", article);
				this.getServletContext().getRequestDispatcher("/findArticle.jsp").forward(request, response);
			} catch (Exception e) {
				String msg = "L'article que vous venez de chercher n'existe pas. Mot clé inconnu";
				request.setAttribute("msg", msg);
				this.getServletContext().getRequestDispatcher("/findArticleForm.jsp").forward(request, response);
			}

		}

	}

}
