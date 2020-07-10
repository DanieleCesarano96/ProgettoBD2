import java.util.ArrayList;
import model.LibroBean;
import model.LibroBeanDao;

public class Main {

  public static void main(String[] args) {
   LibroBeanDao librodao = new LibroBeanDao();
   ArrayList<LibroBean> libri=librodao.ricercaAvanzata2("J.K. Rowling", "d");
   
   for(LibroBean libro : libri)
   {
     System.out.println(libro.getAutore());
   }
  }

}
