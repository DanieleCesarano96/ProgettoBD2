package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LibroBean;
import model.LibroBeanDao;

@WebServlet("/modificaLibro")
public class modificaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public modificaLibro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      double valutazione_media;
         
      if(request.getParameter("valutazioneMedia").equals(""))
      {
        valutazione_media=-1;
      }
      else
      {
        valutazione_media= Double.parseDouble(request.getParameter("valutazioneMedia"));
      }
      
      int num_pag;
         
      if(request.getParameter("numeropagine").equals(""))
      {
        num_pag=-1;
      }
      else
      {
        num_pag= Integer.parseInt(request.getParameter("numeropagine"));
      }
      
      int num_val;
      
      if(request.getParameter("numerovalutazioni").equals(""))
      {
        num_val=-1;
      }
      else
      {
        num_val= Integer.parseInt(request.getParameter("numerovalutazioni"));
      }
      
      int num_rev;
      
      if(request.getParameter("numerorevisioni").equals(""))
      {
        num_rev=-1;
      }
      else
      {
        num_rev= Integer.parseInt(request.getParameter("numerorevisioni"));
      }

	  LibroBean libro = new LibroBean(request.getParameter("bookID"),request.getParameter("titolo"),
	      request.getParameter("autore"),valutazione_media,request.getParameter("isbn"),
	      request.getParameter("isbn13"),request.getParameter("lingua"),num_pag,num_val,num_rev,
	      request.getParameter("dataPublicazione"),request.getParameter("casaEditrice")); 
	  
	  LibroBeanDao libroDao= new LibroBeanDao();
	  libroDao.modificaLibro(libro);
	  
	  request.getRequestDispatcher("index.jsp").forward(request, response);   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
