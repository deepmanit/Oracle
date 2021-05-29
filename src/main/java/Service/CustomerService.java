package Service;

import Dao.CustomerDao;
import Entity.Customer;

import java.util.*;

public class CustomerService {

    CustomerDao dao;
    public CustomerService(CustomerDao dao) {
        this.dao = dao;
    }

    public void printUniqueCustomerIdForEachContractId()
    {
        List<Customer> custLsit = dao.fetchCustomers();
        HashMap<Long, HashSet<Long>> map = new HashMap<>();
        for (Customer cust: custLsit ) {
           if(map.containsKey(cust.getContractId()))
            {
               HashSet<Long> set = map.get(cust.getContractId());
               set.add(cust.getCustomerId());
                map.put(cust.getContractId(),set);
            }
           else
           {
               HashSet<Long> set = new HashSet<>();
               set.add(cust.getCustomerId());
               map.put(cust.getContractId(),set);
           }

        }
        for (Map.Entry<Long, HashSet<Long>> entry : map.entrySet()) {
            System.out.println("[Customer ContractId] : " + entry.getKey() + " [Unique Customer ID] : " + entry.getValue() + " [Count] : " + entry.getValue().size());
        }
    }
    public void printUniqueCustomerIdForEachGeoZone()
    {
        List<Customer> custLsit = dao.fetchCustomers();
        HashMap<String, HashSet<Long>> map = new HashMap<>();
        for (Customer cust: custLsit ) {
            if(map.containsKey(cust.getGeoZone()))
            {
                HashSet<Long> set = map.get(cust.getGeoZone());
                set.add(cust.getCustomerId());
                map.put(cust.getGeoZone(),set);
            }
            else
            {
                HashSet<Long> set = new HashSet<>();
                set.add(cust.getCustomerId());
                map.put(cust.getGeoZone(),set);
            }

        }
        for (Map.Entry<String, HashSet<Long>> entry : map.entrySet()) {
            System.out.println("[Customer GeoZone] : " + entry.getKey() + " [Unique Customer ID] : " + entry.getValue() + " [Count] : " + entry.getValue().size());
        }

    }

    public void printAverageBuildDurationForEachGeoZone()
    {
        List<Customer> custLsit = dao.fetchCustomers();
        HashMap<String, ArrayList<Long>> map = new HashMap<>();
        for (Customer cust: custLsit ) {
            if(map.containsKey(cust.getGeoZone()))
            {
                ArrayList<Long> list = map.get(cust.getGeoZone());
                list.add(cust.getBuildDuration());
                map.put(cust.getGeoZone(),list);
            }
            else
            {
                ArrayList<Long> list = new ArrayList<>();
                list.add(cust.getBuildDuration());
                map.put(cust.getGeoZone(),list);
            }

        }
        for (Map.Entry<String, ArrayList<Long>> entry : map.entrySet()) {
            ArrayList<Long> durations = entry.getValue();
           int size = durations.size();
           long totalDuration = 0;
            for(Long dur : durations){
               totalDuration+=dur;
            }
            System.out.println("[Customer GeoZone] : " + entry.getKey() + " [Build Duration] : " + entry.getValue() + " [ avg build] : " + totalDuration / size);
        }
    }

    public void printListofUniqueCustIdForEachGeoZone()
    {
        List<Customer> custLsit = dao.fetchCustomers();
        HashMap<String, HashSet<Long>> map = new HashMap<>();
        for (Customer cust: custLsit ) {
            if(map.containsKey(cust.getGeoZone()))
            {
                HashSet<Long> set = map.get(cust.getGeoZone());
                set.add(cust.getCustomerId());
                map.put(cust.getGeoZone(),set);
            }
            else
            {
                HashSet<Long> set = new HashSet<>();
                set.add(cust.getCustomerId());
                map.put(cust.getGeoZone(),set);
            }

        }
        for (Map.Entry<String, HashSet<Long>> entry : map.entrySet()) {
            System.out.println("[Customer GeoZone] : " + entry.getKey() + " [Unique Customer ID] : " + entry.getValue());
        }
    }
}
