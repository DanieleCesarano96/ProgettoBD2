package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LibroBeanDao;

@WebServlet("/mediaRate")
public class mediaRate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public mediaRate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      LibroBeanDao libroDao= new LibroBeanDao();
      ArrayList<String> autori=libroDao.groupByAuthors();
      ArrayList<String> case_editrici=libroDao.groupByCasaEditrice();
      
      String autore= request.getParameter("autori2");
      String casa_editrice= request.getParameter("case_editrici2");
    
      String media_rate=libroDao.CountMedioLibri(autore, casa_editrice)+"";
      
      request.setAttribute("autori",autori);
      request.setAttribute("case_editrici",case_editrici);
      request.setAttribute("media_rate",media_rate);
      request.setAttribute("autore",autore);
      request.setAttribute("casa_editrice",casa_editrice);
      
      
      request.getRequestDispatcher("queryAnalitiche.jsp").forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
