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
 * Servlet implementation class FindArticlesByCategorieServlet
 */
@WebServlet("/FindArticlesByCategorieServlet")
public class FindArticlesByCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService as = new ArticleServiceImpl();
	private CategorieService cs = new CategorieServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindArticlesByCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> listcategorie= cs.findAll();
		request.setAttribute("categories", listcategorie);
		request.getRequestDispatcher("/WEB-INF/categorie/findAByCForm.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		Categorie cat = cs.findByName(nom);
		System.out.println("===========================cat");
		System.out.println(cat);
		List<Article> listArticle = as.findArticleByCategorie(cat);
		request.setAttribute("articles", listArticle);
		System.out.println("===========================list");
		System.out.println(listArticle);
		request.getRequestDispatcher("/listArticle.jsp").include(request, response);
		
	}

}
