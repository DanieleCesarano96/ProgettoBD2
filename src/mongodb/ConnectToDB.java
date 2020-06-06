package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConnectToDB {

    private MongoClient mongo;
    private MongoDatabase database;
    
    public ConnectToDB() {
        mongo= null;
        database= null;
    }
    
    public Boolean Connessione () {
         mongo= new MongoClient("localhost", 27017);
         if(mongo==null) 
         {
             return false;
         }
         else 
         {
             database = mongo.getDatabase("BD2");
            if (database==null) 
            {
                return false;
            }
            else 
            {
                return true;
            }
        }
    }

    public MongoClient getMongo() {
        return mongo;
    }

    public void setMongo(MongoClient mongo) {
        this.mongo = mongo;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }
}

