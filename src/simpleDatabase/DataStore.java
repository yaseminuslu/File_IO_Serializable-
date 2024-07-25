package simpleDatabase;

public interface DataStore {
    void put(String key, String value);
    void put(String key,String value, int ttl);
    void get(String key);
}
