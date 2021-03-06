package com.humanbooster.hibernate.servlets.article;

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
 * Servlet implementation class OneArticleServlet
 */
@WebServlet("/OneArticleServlet")
public class OneArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService as = new ArticleServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		System.out.println(idArticle);
		Article art = as.chercherArticleParId(idArticle);
		request.setAttribute("article", art);
		this.getServletContext().getRequestDispatcher("/displayArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
