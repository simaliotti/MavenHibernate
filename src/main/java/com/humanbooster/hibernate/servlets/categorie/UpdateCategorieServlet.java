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
 * Servlet implementation class UpdateArticleServlet
 */
@WebServlet("/UpdateCategorieServlet")
public class UpdateCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService as = new ArticleServiceImpl();
	private CategorieService cs = new CategorieServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCategorieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCategorie = Integer.parseInt(request.getParameter("update"));

		Categorie categorie = cs.findById(idCategorie);
		request.setAttribute("categorie", categorie);

		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/updateCategorieForm.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		Categorie categorieToUpdate = cs.findById(idCategorie);

		String nom = request.getParameter("nom");

		String msg = "Veuillez remplir les champs obligatoires";
	
		System.out.println(nom);

		if (nom.isEmpty()) {
			request.setAttribute("msg", msg);
			request.setAttribute("categorie", categorieToUpdate);
			this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/updateCategorieForm.jsp").forward(request,response);
			return;
		}

		if (!(nom.equals(categorieToUpdate.getNom()))) {
			try {
				cs.findByName(nom);
				msg = nom + " est déja utilisé";
				request.setAttribute("msg", msg);
				request.setAttribute("categorie", categorieToUpdate);
				this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/updateCategorieForm.jsp")
						.forward(request, response);
			} catch (Exception e) {
				// nom pas trouvé donc bon
			}

		}

		Categorie categorie = new Categorie();
		categorie.setNom(nom);
		categorie.setIdCategorie(idCategorie);

		cs.update(categorie);

		response.sendRedirect(request.getContextPath() + "/index");
	}

}
