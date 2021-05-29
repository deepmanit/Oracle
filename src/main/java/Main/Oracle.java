package Main;

import Dao.CustomerDao;
import Dao.CustomerDaoImpl;
import Entity.Customer;
import Service.CustomerService;

public class Oracle {
    public static void main(String[] args)
    {
        System.out.println("Hi");
        CustomerDao dao = new CustomerDaoImpl();
        CustomerService service = new CustomerService(dao);
        service.printUniqueCustomerIdForEachContractId();
        service.printUniqueCustomerIdForEachGeoZone();
        service.printAverageBuildDurationForEachGeoZone();
        service.printListofUniqueCustIdForEachGeoZone();
    }
}
