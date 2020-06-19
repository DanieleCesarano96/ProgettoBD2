import model.LibroBeanDao;

public class Main {

  public static void main(String[] args) {
    LibroBeanDao libro =new LibroBeanDao();
    
    boolean prova=libro.modificaLibro2();
    
    System.out.println(prova);
  }

}
