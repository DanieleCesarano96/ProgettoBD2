package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LibroBean;
import model.LibroBeanDao;

@WebServlet("/ricercaAvanzata")
public class ricercaAvanzata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ricercaAvanzata() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	  String titolo= request.getParameter("titolo");
	  String autore= request.getParameter("autore");
	  String isbn= request.getParameter("isbn");
	  String lingua= request.getParameter("lingua");
	  String casa_editrice= request.getParameter("casaeditrice");
      
      LibroBeanDao libroDao= new LibroBeanDao();
      
      
      if((titolo==null || titolo.equals("")) && (autore==null || autore.equals("")) && (isbn==null || isbn.equals("")) 
          && (lingua==null || lingua.equals("")) && (casa_editrice==null || casa_editrice.equals("")))
      {
        ArrayList<LibroBean> libri = libroDao.getAllBooks();
        
        request.setAttribute("libri",libri);
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
      }
      else 
      {
        ArrayList<LibroBean> libri =libroDao.ricercaAvanzata(titolo,autore,isbn,lingua,casa_editrice);    
        
        request.setAttribute("libri",libri);
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
      }   
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
