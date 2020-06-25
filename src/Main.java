import java.util.ArrayList;

import model.LibroBean;
import model.LibroBeanDao;

public class Main {

  public static void main(String[] args) {
    LibroBeanDao libroda =new LibroBeanDao();
    
    ArrayList<LibroBean> libri= libroda.getAllBooks();
    int count=0;
    for(LibroBean libro : libri)
    {
      if(count==8121)
      {
        return;
      }
      libroda.eliminaLibro(libro.getBookID());
      count++;
    }

  }

}
