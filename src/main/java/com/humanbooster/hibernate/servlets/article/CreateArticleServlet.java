package com.humanbooster.hibernate.servlets.article;

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
 * Servlet implementation class CreateArticle
 */
@WebServlet("/CreateArticleServlet")
public class CreateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleService as = new ArticleServiceImpl();
	private CategorieService cs = new CategorieServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Categorie> listCategorie = cs.findAll();
		request.setAttribute("categories", listCategorie);
		this.getServletContext().getRequestDispatcher("/createArticleForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categorie> listCategorie = cs.findAll();
	
		String designation = null;
		int nbPoints = 0;
		int stock = 0;

		String msg = "Veuillez remplir les champs obligatoires";

		try {
			designation = request.getParameter("designation");
		} catch (Exception e) {
			request.setAttribute("categories", listCategorie);
			request.setAttribute("msg", msg);
			this.getServletContext().getRequestDispatcher("/createArticleForm.jsp").forward(request, response);
		}

		try {
			as.chercherArticleParDesignation(designation);
			msg = designation + " est déja utilisé";
			request.setAttribute("msg", msg);
			request.setAttribute("categories", listCategorie);
			this.getServletContext().getRequestDispatcher("/createArticleForm.jsp").forward(request, response);
			return;
		} catch (Exception e) {

		}

		try {
			nbPoints = Integer.parseInt(request.getParameter("nbPoints"));
			stock = Integer.parseInt(request.getParameter("stock"));
		} catch (Exception e) {
			request.setAttribute("categories", listCategorie);
			request.setAttribute("msg", msg);
			this.getServletContext().getRequestDispatcher("/createArticleForm.jsp").forward(request, response);
		}
		

		if (nbPoints == 0 || stock == 0) {
			request.setAttribute("categories", listCategorie);
			request.setAttribute("msg", msg);
			this.getServletContext().getRequestDispatcher("/createArticleForm.jsp").forward(request, response);
		}

		String categorieName = request.getParameter("categorieName");
		Categorie categorie = null;
		try {
			categorie = cs.findByName(categorieName);
		} catch (Exception e) {
			// on ne créé par la catégorie
		}

		Article article = new Article();

		article.setDesignation(designation);
		article.setNbPoints(nbPoints);
		article.setStock(stock);
		article.setCategorie(categorie);

		as.creerArticle(article);

		response.sendRedirect(request.getContextPath() + "/index");

	}

}
