package com.octest.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.octest.beans.Auteur;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//pour juste charger la page.
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		
//		PrintWriter out = response.getWriter(); //represente la sortie.
//		out.println("Bonjour !");
		//si on veux faire ca mettre l'ensemble des balises qui compose normalement une page html.
		
		String message = "Bye !";
		request.setAttribute("variable", message);
		request.setAttribute("heure", "jour");
		//maintenant dans la jsp nous aurons acces a une variable qui contiendra message.
		
		//ici je vois comment je peux recuperer un nom avec ma servlet.
		String name = request.getParameter("name"); 
		//permet de recup un param dans l'url ?name=...&age=...
		request.setAttribute("name", name);
		
		//parcourir un tableau avec eljsp
		String[] noms = {"Lulu", "Robert", "Muriel"}; 
		request.setAttribute("noms", noms);
		
		//apl du bean avant la jsp
		Auteur auteur = new Auteur();
		auteur.setPrenom("Lucie");
		auteur.setNom("ADE");
		auteur.setActif(true);
		request.setAttribute("auteur", auteur);
		
		//apl de la jsp.
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response); 
		//webapp est fictif dans eclipse c'est pour ça qu'on ne le met pas dans le chemin.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//quand le visiteur veux poster des infos.
		doGet(request, response);
	}

}
