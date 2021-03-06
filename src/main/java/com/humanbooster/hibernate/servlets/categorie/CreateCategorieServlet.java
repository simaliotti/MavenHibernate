package com.humanbooster.hibernate.servlets.categorie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.service.CategorieService;
import com.humanbooster.hibernate.service.impl.CategorieServiceImpl;

/**
 * Servlet implementation class CreateCategorieServlet
 */
@WebServlet("/CreateCategorieServlet")
public class CreateCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CategorieService cs = new CategorieServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/createCategorieForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("name");
		String msg = "Veuillez remplir les champs obligatoires";
		
		Categorie categorie = new Categorie();
		
		if (nom.isEmpty()) {
			request.setAttribute("msg", msg);
			this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/updateCategorieForm.jsp").forward(request,response);
			return;
		}
		try {
			cs.findByName(nom);
			msg = nom + " est déja utilisé";
			request.setAttribute("msg", msg);
			this.getServletContext().getRequestDispatcher("/WEB-INF/categorie/updateCategorieForm.jsp").forward(request,response);
			return;
		} catch (Exception e) {

		}
		
		
		
		
		categorie.setNom(nom);
		cs.createCategorie(categorie);
		
		response.sendRedirect(request.getContextPath()+"/index");
	}

}
