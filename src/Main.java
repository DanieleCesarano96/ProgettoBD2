
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import mongodb.ConnectToDB;

public class Main {

  public static void main(String[] args) {
      ConnectToDB mongo = new ConnectToDB();
      if(mongo.Connessione())
      {
        MongoDatabase database = mongo.getDatabase();
      
        database.getCollection("Books").createIndex(Filters.eq("isbn", 1));
      }
      else {
        System.out.println("non entra");
      }
  }

}
