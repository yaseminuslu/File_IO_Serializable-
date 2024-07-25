package simpleDatabase;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FileDataStore implements DataStore {
    Map<String,String> fileDatas= new HashMap<>();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private String filePath ="C:\\Users";
    private void writeFile(Map<String,String> data, String filePath) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(data);
            objectOutputStream.flush();
        }
    }

    private void readFile(String filePath,String key) throws IOException, ClassNotFoundException {
        try(FileInputStream fileInputStream=new FileInputStream(filePath);
            ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream)){

            Map<String,String> fileData=(Map<String,String>)objectInputStream.readObject();
            System.out.println(fileData.get(key));
        }
    }

    @Override
    public void put(String key, String value) {
        fileDatas.put(key, value);
        try{
            writeFile(fileDatas,filePath);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void put(String key, String value, int ttl) {
        fileDatas.put(key, value);
        try{
            writeFile(fileDatas,filePath);
            scheduler.schedule(() -> {fileDatas.remove(key);
                        try {
                            writeFile(fileDatas,filePath);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    },ttl, TimeUnit.SECONDS);
        }catch (IOException e){
            System.out.println(e);}
}

    @Override
    public void get(String key) {
        try {
            readFile(filePath,key);
        }catch(IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
