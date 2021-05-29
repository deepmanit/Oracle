package Dao;

import Data.CutomerCache;
import Entity.Customer;
import Parser.Parser;
import Parser.CSVParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> fetchCustomers() {
        String fileName = "C:\\Users\\Deepm\\Downloads\\Oracle\\src\\main\\resources\\customer.txt";
        //file name is hardcoded need to configure from property file
        CutomerCache custCache = CutomerCache.getInstance();
        if(custCache.getData(fileName) != null)
        {
            return custCache.getData(fileName);
        }
        else {
            List<Customer> custList = fetchCustomerDetails(fileName);
            custCache.setData(fileName, custList);
            return custList;
        }
    }
    private  List<Customer> fetchCustomerDetails(String filename)
    {
        List<Customer> custList = new ArrayList<>() ;
        Parser p = new CSVParser();
        try {

            List<String[]> resultset = p.parseData(filename);
            for (String[] resCust : resultset) {
                pasreCustResultSet(resCust,custList);
            }
        } catch (IOException ex) {
            System.out.println("File no found");
            ex.printStackTrace();
        }

        finally {
            return custList;
        }

    }
   private void pasreCustResultSet(String[] rowData,List<Customer> custList)
   {
       final String[] headers = "customerId,contractId,geozone,teamcode,projectcode,buildduration".split(",");
       Customer cust = new Customer();
       for(int i = 0; i < rowData.length; i++) {

           switch (headers[i]) {
               case "customerId" :
                   cust.setCustomerId(Long.parseLong(rowData[i]));
                   break;
               case "contractId" :
                   cust.setContractId(Long.parseLong(rowData[i]));
                   break;
               case "geozone" :
                   cust.setGeoZone(rowData[i]);
                   break;
               case "teamcode" :
                   cust.setTeamCode(rowData[i]);
                   break;
               case "projectcode" :
                   cust.setProjectCode(rowData[i]);
                   break;
               case "buildduration" :
                   cust.setBuildDuration(Long.parseLong(rowData[i].substring(0,rowData[i].length()-1)));
                   break;
           }

       }
       custList.add(cust);
   }
}
