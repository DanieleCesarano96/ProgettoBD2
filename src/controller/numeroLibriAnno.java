package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LibroBeanDao;

@WebServlet("/numeroLibriAnno")
public class numeroLibriAnno extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public numeroLibriAnno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      LibroBeanDao libroDao= new LibroBeanDao();
      ArrayList<String> autori=libroDao.groupByAuthors();
      ArrayList<String> case_editrici=libroDao.groupByCasaEditrice();
      
      String casa_editrice= request.getParameter("case_editrici3");
      String anno= request.getParameter("anno");
      
      String num_libri_anno=libroDao.CountLibriRangeData(casa_editrice, anno)+"";
      
      request.setAttribute("autori",autori);
      request.setAttribute("case_editrici",case_editrici);
      request.setAttribute("num_libri_anno",num_libri_anno);
      request.setAttribute("casa_editrice",casa_editrice);
      
      System.out.println(anno);
      
      request.getRequestDispatcher("queryAnalitiche.jsp").forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
