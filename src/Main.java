import java.util.Arrays;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

import mongodb.ConnectToDB;

public class Main {

  public static void main(String[] args) {
    ConnectToDB mongo = new ConnectToDB();
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");  
     
     AggregateIterable<Document> iterDoc= collection.aggregate(
         Arrays.asList(    
             Aggregates.match(Filters.and(Filters.eq("authors","J.K. Rowling"),Filters.eq("average_rating","max"))),
             Aggregates.group("$authors", Accumulators.max("max","$average_rating"))
             )
         );
     
     MongoCursor<Document> it = iterDoc.iterator(); 
     Document document = it.next();
     
    
     System.out.println(document);
    }
  }
}
