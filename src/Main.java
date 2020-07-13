
import java.util.ArrayList;

import model.LibroBeanDao;
import mongodb.ConnectToDB;



public class Main {

  public static void main(String[] args) {
  ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
    
     LibroBeanDao librodao =new LibroBeanDao();
     ArrayList<String> autori=librodao.MaxMinAvg("J.K. Rowling", null);
     for(String autore: autori)
     {
       //System.out.println(autore);
     }
    }
  }
}
