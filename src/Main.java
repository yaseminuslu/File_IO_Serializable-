import simpleDatabase.DataStore;
import simpleDatabase.FileDataStore;
import simpleDatabase.InMemoryDataStore;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataStore inMemory= new InMemoryDataStore();
        DataStore fileData= new FileDataStore();

//        inMemory.put("name","muhammet");
//        inMemory.put("name","yasemin");
//        inMemory.put("surname","uslu");
//        inMemory.get("name");

//        fileData.put("name","yasemin");
//        fileData.put("surname","uslu");
//        fileData.put("name","muhammet");
//        fileData.get("surname");


//        inMemory.put("name","yasemin",5);
//        TimeUnit.SECONDS.sleep(2);
//        inMemory.get("name");
//        TimeUnit.SECONDS.sleep(2);
//        inMemory.get("name");
//        TimeUnit.SECONDS.sleep(2);
//        inMemory.get("name");
//        System.exit(0);

        fileData.put("name","yasemin",5);
        TimeUnit.SECONDS.sleep(2);
        fileData.get("name");
        TimeUnit.SECONDS.sleep(2);
        fileData.get("name");
        TimeUnit.SECONDS.sleep(2);
        fileData.get("name");
        System.exit(0);



    }
}