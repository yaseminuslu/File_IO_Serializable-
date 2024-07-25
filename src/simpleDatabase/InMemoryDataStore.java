package simpleDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InMemoryDataStore implements DataStore {
    private  Map<String,String> datas=new HashMap<>();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void put(String key, String value) {
        datas.put(key, value);
    }

    @Override
    public void put(String key, String value, int ttl) {
        datas.put(key, value);
        scheduler.schedule(() -> datas.remove(key), ttl, TimeUnit.SECONDS);
    }

    @Override
    public void get(String key) {
        System.out.println(datas.get(key));
    }
}
