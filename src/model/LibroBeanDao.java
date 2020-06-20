package model;

import java.util.ArrayList;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import mongodb.ConnectToDB;

public class LibroBeanDao {

  public synchronized boolean aggiungiLibro(LibroBean libro) {
    ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");
     
     Document document= new Document("title",libro.getTitolo())
         .append("authors", libro.getAutore())
         .append("average_rating", libro.getValutazione_media())
         .append("isbn", libro.getIsbn())
         .append("isbn13", libro.getIsbn13())
         .append("language_code", libro.getLingua())
         .append("num_pages", libro.getNumero_pagine())
         .append("ratings_count", libro.getNumero_valutazioni())
         .append("text_reviews_count", libro.getNumero_revisioni())
         .append("publication_date", libro.getData_publicazione())
         .append("publisher;;;", libro.getCasa_editrice());
     collection.insertOne(document);
     return true;
    } 
    else
    {
      return false;
    }
  }
  
  public synchronized ArrayList<LibroBean> getAllBooks() {
    ConnectToDB mongo = new ConnectToDB();
    ArrayList<LibroBean> libri= new ArrayList<LibroBean>();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     
     MongoCollection<Document> collection= database.getCollection("Books");
     
     FindIterable<Document> iterDoc= collection.find();
     MongoCursor<Document> it = iterDoc.iterator();
    
     while(it.hasNext())
     {
       Document document = it.next();

       LibroBean libro= new LibroBean(document.get("_id"),document.getString("title"),document.getString("authors"),
           document.getDouble("average_rating"),document.getString("isbn"),document.getString("isbn13"),
           document.getString("language_code"),document.getInteger("num_pages"),document.getInteger("ratings_count"),
           document.getInteger("text_reviews_count"),document.getString("publication_date"),document.getString("publisher;;;"));
       libri.add(libro);
     }
     return libri;
    } 
    else
    {
      return null;
    }
  }
  
  public synchronized boolean modificaLibro(LibroBean libro) {
    ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");
     
     BasicDBObject newDocument = new BasicDBObject();
     newDocument.put("title", libro.getTitolo());
     newDocument.put("authors", libro.getAutore());
     newDocument.put("average_rating", libro.getValutazione_media());
     newDocument.put("isbn", libro.getIsbn());
     newDocument.put("isbn13", libro.getIsbn13());
     newDocument.put("language_code", libro.getLingua());
     newDocument.put("num_pages", libro.getNumero_pagine());
     newDocument.put("ratings_count", libro.getNumero_valutazioni());
     newDocument.put("text_reviews_count", libro.getNumero_revisioni());
     newDocument.put("publication_date", libro.getData_publicazione());
     newDocument.put("publisher;;;", libro.getCasa_editrice());
     
     BasicDBObject updateObject = new BasicDBObject();
     updateObject.put("$set", newDocument);
     
     collection.updateOne(Filters.eq("bookID", libro.getBookID()), updateObject);
     return true;
    } 
    else
    {
      return false;
    }
  }
  
  public synchronized boolean eliminaLibro(Object id) {
    ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");

     collection.deleteOne(Filters.eq("_id",id));
     
     return true;
    } 
    else
    {
      return false;
    }
  }
  
  
  public synchronized boolean modificaLibro2( ) {
    ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");

     BasicDBObject newDocument = new BasicDBObject();
     newDocument.put("title", "daddy"); 
     newDocument.put("authors", "daddy3"); 
     
     BasicDBObject updateObject = new BasicDBObject();
     updateObject.put("$set", newDocument);
     
     collection.updateOne(Filters.eq("title", "1"), updateObject);
     return true;
    } 
    else
    {
      return false;
    }
  }
}
