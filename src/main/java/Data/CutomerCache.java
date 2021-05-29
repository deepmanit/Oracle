package Data;

import Entity.Customer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class CutomerCache implements Serializable, Cloneable {
    private static CutomerCache instance = null;
    private HashMap<String, List<Customer>> cache = new HashMap<>();

    public List<Customer> getData(String key)
    {
       if(cache.containsKey(key))
       {
           return cache.get(key);
       }
       else
       {
           return null;
       }
    }

    public void setData(String key, List<Customer> customers)
    {
        if(customers != null)
            cache.put(key,customers);
    }

    private CutomerCache()
    {
        // private constructor
        if(instance != null)
        {
            throw new RuntimeException("Instance already exist");
        }

    }

    public static CutomerCache getInstance()
    {
        if (instance == null)
        {
            //synchronized block to remove overhead
            synchronized (CutomerCache.class)
            {
                if(instance==null)
                {
                    // if instance is null, initialize
                    instance = new CutomerCache();
                }

            }
        }
        return instance;
    }
    protected Object readResolve()
    {
        return instance;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return instance;
    }


}
