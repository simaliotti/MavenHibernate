package com.humanbooster.hibernate.servlets.commande;

import java.io.IOException;
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
 * Servlet implementation class findArticleServlet
 */
@WebServlet("/FindCategorieServlet")
public class FindCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategorieService cs = new CategorieServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindCategorieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/findCategorieForm.jsp").forward(request,
				response);
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

		String nom = request.getParameter("nom");

		try {
			Categorie cat = cs.findByName(nom);
			request.setAttribute("categorie", cat);
			System.out.println("==============CA PASSE=================");
			this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/findCategorie.jsp").forward(request, response);
		} catch (Exception e) {
			String msg = "La catégorie que vous venez de chercher n'existe pas.";
			request.setAttribute("msg", msg);
			this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/findCategorieForm.jsp").forward(request, response);
		}

	}

}
