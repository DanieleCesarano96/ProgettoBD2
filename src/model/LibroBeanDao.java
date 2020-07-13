package model;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

import mongodb.ConnectToDB;

import java.util.ArrayList;
import java.util.Arrays;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class LibroBeanDao {

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
       
       double valutazione_media;
       
       if(document.getDouble("average_rating")==null)
       {
         valutazione_media=-1;
       }
       else
       {
         valutazione_media=  document.getDouble("average_rating");
       }
       
       int num_pag;
          
       if(document.getInteger("num_pages")==null)
       {
         num_pag=-1;
       }
       else
       {
         num_pag=  document.getInteger("num_pages");
       }
       
       int num_val;
       
       if(document.getInteger("ratings_count")==null)
       {
         num_val=-1;
       }
       else
       {
         num_val=  document.getInteger("ratings_count");
       }
       
       int num_rev;
       
       if(document.getInteger("text_reviews_count")==null)
       {
         num_rev=-1;
       }
       else
       {
         num_rev=  document.getInteger("text_reviews_count");
       }
       
       LibroBean libro= new LibroBean(document.getString("_id"),document.getString("title"),document.getString("authors"),
           valutazione_media,document.getString("isbn"),document.getString("isbn13"),document.getString("language_code"),
           num_pag,num_val,num_rev,document.getString("publication_date"),document.getString("publisher;;;"));
       libri.add(libro);
     }
     return libri;
    } 
    else
    {
      return null;
    }
  }
  
  
  public synchronized boolean aggiungiLibro(LibroBean libro) {
    ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");  
    
     Document document= new Document("title",libro.getTitolo());
     ObjectId id= new ObjectId();
     document.append("_id",id.toString());
     
     //non inseriamo i campi se sono vuoti
     if(!libro.getAutore().equals(""))
     {
       document.append("authors", libro.getAutore());
     }
     if(!libro.getIsbn().equals(""))
     {
       document.append("isbn", libro.getIsbn());
     }
     if(!libro.getIsbn13().equals(""))
     {
       document.append("isbn13", libro.getIsbn13());
     }
     if(!libro.getLingua().equals(""))
     {
       document.append("language_code", libro.getLingua());
     }
     if(!libro.getData_publicazione().equals(""))
     {
       document.append("publication_date", libro.getData_publicazione());
     }
     if(!libro.getCasa_editrice().equals(""))
     {
       document.append("publisher;;;", libro.getCasa_editrice());
     }
     
     //non inseriamo i campi se sono uguali a -1 perchè significa che sono vuoti 
     if(libro.getValutazione_media()!=-1)
     {
       document.append("average_rating", libro.getValutazione_media());
     }
     if(libro.getNumero_pagine()!=-1)
     {
       document.append("num_pages", libro.getNumero_pagine());
     }
     if(libro.getNumero_valutazioni()!=-1)
     {
       document.append("ratings_count", libro.getNumero_valutazioni());
     }
     if(libro.getNumero_revisioni()!=-1)
     {
       document.append("text_reviews_count", libro.getNumero_revisioni());
     }

     collection.insertOne(document);
 
     return true;
    } 
    else
    {
      return false;
    }
  }
  
  public synchronized LibroBean getLibro(Object id) {
    ConnectToDB mongo = new ConnectToDB();
    LibroBean libro = null;
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     
     MongoCollection<Document> collection= database.getCollection("Books");
     
     FindIterable<Document> iterDoc= collection.find(Filters.eq("_id", id));
     MongoCursor<Document> it = iterDoc.iterator();
     
     if(it.hasNext())
     {
       Document document = it.next();
       
       double valutazione_media;
       
       if(document.getDouble("average_rating")==null)
       {
         valutazione_media=-1;
       }
       else
       {
         valutazione_media=  document.getDouble("average_rating");
       }
       
       int num_pag;
          
       if(document.getInteger("num_pages")==null)
       {
         num_pag=-1;
       }
       else
       {
         num_pag=  document.getInteger("num_pages");
       }
       
       int num_val;
       
       if(document.getInteger("ratings_count")==null)
       {
         num_val=-1;
       }
       else
       {
         num_val=  document.getInteger("ratings_count");
       }
       
       int num_rev;
       
       if(document.getInteger("text_reviews_count")==null)
       {
         num_rev=-1;
       }
       else
       {
         num_rev=  document.getInteger("text_reviews_count");
       }
       
        libro= new LibroBean(document.getString("_id"),document.getString("title"),document.getString("authors"),
           valutazione_media,document.getString("isbn"),document.getString("isbn13"),document.getString("language_code"),
           num_pag,num_val,num_rev,document.getString("publication_date"),document.getString("publisher;;;"));
     }
    } 
    return libro;
  }
  
  public synchronized boolean modificaLibro(LibroBean libro) {
    ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");
     
     BasicDBObject newDocument = new BasicDBObject();
     newDocument.put("title", libro.getTitolo());
     
     if(!libro.getAutore().equals(""))
     {
       newDocument.put("authors", libro.getAutore());
     }
     if(libro.getValutazione_media()!=-1)
     {
       newDocument.put("average_rating", libro.getValutazione_media());
     }
     if(!libro.getIsbn().equals(""))
     {
       newDocument.put("isbn", libro.getIsbn());
     }
     if(!libro.getIsbn13().equals(""))
     {
       newDocument.put("isbn13", libro.getIsbn13());
     }
     if(!libro.getLingua().equals(""))
     {
       newDocument.put("language_code", libro.getLingua());
     }
     if(!libro.getData_publicazione().equals(""))
     {
       newDocument.put("publication_date", libro.getData_publicazione());
     }
     if(!libro.getCasa_editrice().equals(""))
     {
       newDocument.put("publisher;;;", libro.getCasa_editrice());
     }
    
     if(libro.getNumero_pagine()!=-1)
     {
       newDocument.put("num_pages", libro.getNumero_pagine());
     }
     if(libro.getNumero_valutazioni()!=-1)
     {
       newDocument.put("ratings_count", libro.getNumero_valutazioni());
     }
     if(libro.getNumero_revisioni()!=-1)
     {
       newDocument.put("text_reviews_count", libro.getNumero_revisioni());
     }
     
     BasicDBObject updateObject = new BasicDBObject();
     updateObject.put("$set", newDocument);
     
     collection.updateOne(Filters.eq("_id", libro.getBookID()), updateObject);
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

  public synchronized ArrayList<LibroBean> ricercaAvanzata(String titolo, String autore, String isbn, String lingua,
      String casa_editrice,double min_valutazione,double max_valutazione) {
    ConnectToDB mongo = new ConnectToDB();
    ArrayList<LibroBean> libri= new ArrayList<LibroBean>();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     
     MongoCollection<Document> collection= database.getCollection("Books");

     BasicDBObject newDocument = new BasicDBObject();
     
     if(titolo!=null && !titolo.equals(""))
     {
       newDocument.put("title", new BasicDBObject("$regex",".*"+titolo+".*")); 
     }
     if(autore!=null && !autore.equals(""))
     {
       newDocument.put("authors",  new BasicDBObject("$regex",".*"+autore+".*"));
     }
     if(isbn!=null && !isbn.equals(""))
     {
       newDocument.put("isbn", isbn);
     }
     if(lingua!=null && !lingua.equals(""))
     {
       newDocument.put("language_code", lingua);
     }
     if(casa_editrice!=null && !casa_editrice.equals(""))
     {
       newDocument.put("publisher;;;",  new BasicDBObject("$regex",".*"+casa_editrice+".*"));
     } 
     if(min_valutazione!=0 || max_valutazione!=5)
     {
       BasicDBObject media= new BasicDBObject("$lt",max_valutazione).append("$gt",min_valutazione);
       newDocument.put("average_rating",media);
     } 
     
     FindIterable<Document> iterDoc= collection.find(Filters.and(newDocument));
     MongoCursor<Document> it = iterDoc.iterator();
     
     while(it.hasNext())
     {
       Document document = it.next();
       
       double valutazione_media;
       
       if(document.getDouble("average_rating")==null)
       {
         valutazione_media=-1;
       }
       else
       {
         valutazione_media=  document.getDouble("average_rating");
       }
       
       int num_pag;
          
       if(document.getInteger("num_pages")==null)
       {
         num_pag=-1;
       }
       else
       {
         num_pag=  document.getInteger("num_pages");
       }
       
       int num_val;
       
       if(document.getInteger("ratings_count")==null)
       {
         num_val=-1;
       }
       else
       {
         num_val=  document.getInteger("ratings_count");
       }
       
       int num_rev;
       
       if(document.getInteger("text_reviews_count")==null)
       {
         num_rev=-1;
       }
       else
       {
         num_rev=  document.getInteger("text_reviews_count");
       }
       
       LibroBean libro= new LibroBean(document.getString("_id"),document.getString("title"),document.getString("authors"),
           valutazione_media,document.getString("isbn"),document.getString("isbn13"),document.getString("language_code"),
           num_pag,num_val,num_rev,document.getString("publication_date"),document.getString("publisher;;;"));
       libri.add(libro);
     }
     return libri;
    } 
    else
    {
      return null;
    }    
  }
  
  public synchronized ArrayList<String> groupByAuthors() {
    
    ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");
     
     AggregateIterable<Document> iterDoc= collection.aggregate(
         Arrays.asList(
             Aggregates.project(Projections.include("authors")),
             Aggregates.group("$authors"),
             Aggregates.sort(Sorts.ascending("_id"))
             )
         );
     
     MongoCursor<Document> it = iterDoc.iterator();
     ArrayList<String> autori= new ArrayList<String>();
     while(it.hasNext())
     {
       Document document = it.next();
       autori.add(document.getString("_id"));
       
     }
     return autori;
    }
    else 
    {
      return null;
    }
  }
  
  
  public synchronized ArrayList<String> groupByCasaEditrice() {
    
    ConnectToDB mongo = new ConnectToDB();
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");
     
     AggregateIterable<Document> iterDoc= collection.aggregate(
         Arrays.asList(
             Aggregates.project(Projections.include("publisher;;;")),
             Aggregates.group("$publisher;;;"),
             Aggregates.sort(Sorts.ascending("_id"))
             )
         );
     
     MongoCursor<Document> it = iterDoc.iterator();
     ArrayList<String> case_editrici= new ArrayList<String>();
     while(it.hasNext())
     {
       Document document = it.next();
       case_editrici.add(document.getString("_id"));
       
     }
     return case_editrici;
    }
    else 
    {
      return null;
    }
  }
  
public synchronized ArrayList<Double> MaxMinAvg(String autore, String casa_editrice) {
    
    ConnectToDB mongo = new ConnectToDB();
    ArrayList<Double> maxmin= new ArrayList<Double>();
    AggregateIterable<Document> iterDoc= null;
    AggregateIterable<Document> iterDoc2= null;
    
    if(mongo.Connessione())
    {
     MongoDatabase database = mongo.getDatabase();
     MongoCollection<Document> collection= database.getCollection("Books");  
     
     if(!autore.equals("") && autore!=null && !casa_editrice.equals("") && casa_editrice!=null)
     {
         return null;
     }
     else if(!autore.equals("") && autore!=null)
     {
       iterDoc= collection.aggregate(
           Arrays.asList(    
               Aggregates.match(Filters.eq("authors",autore)),
               Aggregates.group("$authors", Accumulators.max("max","$average_rating"))
               )
           );
       
       iterDoc2= collection.aggregate(
           Arrays.asList(    
               Aggregates.match(Filters.eq("authors",autore)),
               Aggregates.group("$authors", Accumulators.min("min","$average_rating"))
               )
           );
     }
     else 
     {
       iterDoc= collection.aggregate(
           Arrays.asList(    
               Aggregates.match(Filters.eq("publisher;;;",casa_editrice)),
               Aggregates.group("$publisher;;;", Accumulators.max("max","$average_rating"))
               )
           );
       
       iterDoc2= collection.aggregate(
           Arrays.asList(    
               Aggregates.match(Filters.eq("publisher;;;",casa_editrice)),
               Aggregates.group("$publisher;;;", Accumulators.min("min","$average_rating"))
               )
           );
     }
     
     MongoCursor<Document> it = iterDoc.iterator(); 
     MongoCursor<Document> it2 = iterDoc2.iterator(); 
     
     if(it.hasNext())
     {
     Document document = it.next();
     Document document2 = it2.next();
     maxmin.add(document.getDouble("max"));
     maxmin.add(document2.getDouble("min"));
     
     
     return maxmin;
     }
     else
     {
       return null;
     }
    
    }
    else 
    {
      return null;
    }
  }

public synchronized int CountLibri(String autore, String casa_editrice) {
  
  ConnectToDB mongo = new ConnectToDB();
  
  if(mongo.Connessione())
  {
   MongoDatabase database = mongo.getDatabase();
   MongoCollection<Document> collection= database.getCollection("Books");
   AggregateIterable<Document> iterDoc;
   
   if((!autore.equals("") && autore!=null)  && (casa_editrice!=null && !casa_editrice.equals("")))
   {
      iterDoc= collection.aggregate(
         Arrays.asList(    
             Aggregates.match(Filters.and(Filters.eq("authors",autore),Filters.eq("publisher;;;",casa_editrice))),
             Aggregates.group("$authors", Accumulators.sum("count",1))    
             )
         );
   }
   else if(!autore.equals("") && autore!=null)
   {
      iterDoc= collection.aggregate(
         Arrays.asList(    
             Aggregates.match(Filters.eq("authors",autore)),
             Aggregates.group("$authors", Accumulators.sum("count",1))
             )
         );
   }
   else
   {
      iterDoc= collection.aggregate(
         Arrays.asList(    
             Aggregates.match(Filters.eq("publisher;;;",casa_editrice)),
             Aggregates.group("$publisher;;;", Accumulators.sum("count",1))
             )
         );
   }
  
   MongoCursor<Document> it = iterDoc.iterator();
   
   if(it.hasNext())
   {
   Document document = it.next();

   return document.getInteger("count");
   }
   else
   {
     return 0;
   }
  }
  else 
  {
    return 0;
  }
}

public synchronized double CountMedioLibri(String autore, String casa_editrice) {
  
  ConnectToDB mongo = new ConnectToDB();
  
  if(mongo.Connessione())
  {
   MongoDatabase database = mongo.getDatabase();
   MongoCollection<Document> collection= database.getCollection("Books");
   AggregateIterable<Document> iterDoc;
   
   if((!autore.equals("") && autore!=null)  && (casa_editrice!=null && !casa_editrice.equals("")))
   {
     iterDoc= collection.aggregate(
         Arrays.asList( 
             Aggregates.match(Filters.and(Filters.eq("authors",autore),Filters.eq("publisher;;;",casa_editrice))),
             Aggregates.group("$authors",  Accumulators.avg("avg","$average_rating"))    
             )
         );
  
   }
   else if(!autore.equals("") && autore!=null)
   {
     iterDoc= collection.aggregate(
         Arrays.asList(  
             Aggregates.match(Filters.eq("authors",autore)),
             Aggregates.group("$authors",  Accumulators.avg("avg","$average_rating"))    
             )
         );
   }
   else
   {
     iterDoc= collection.aggregate(
         Arrays.asList(  
             Aggregates.match(Filters.eq("publisher;;;",casa_editrice)),
             Aggregates.group("$authors",  Accumulators.avg("avg","$average_rating"))    
             )
         );
   }
  
   MongoCursor<Document> it = iterDoc.iterator();
   
   if(it.hasNext())
   {
     Document document = it.next();
  
  
     return document.getDouble("avg");
   }
   else
   {
     return 0;
   }

  }
  else 
  {
    return 0;
  }
}


public synchronized int CountLibriRangeData(String casa_editrice,String anno) {
  
  ConnectToDB mongo = new ConnectToDB();
  
  if(mongo.Connessione())
  {
   MongoDatabase database = mongo.getDatabase();
   MongoCollection<Document> collection= database.getCollection("Books");

   BasicDBObject newDocument = new BasicDBObject();

   newDocument.put("publication_date", new BasicDBObject("$regex",".*/.*/"+anno));

   AggregateIterable<Document> iterDoc= collection.aggregate(
         Arrays.asList(    
             Aggregates.match(Filters.and(newDocument,Filters.eq("publisher;;;",casa_editrice))),
             Aggregates.group("$publisher;;;", Accumulators.sum("count",1))    
             )
         );

  
   MongoCursor<Document> it = iterDoc.iterator();
   if(it.hasNext())
   {
   Document document = it.next();

   return document.getInteger("count");
   }
   else
   {
     return 0;
   }
  
  }
  else 
  {
    return 0;
  }
}

}
