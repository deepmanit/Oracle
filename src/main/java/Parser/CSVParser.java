package Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements Parser{

    @Override
    public List<String[]> parseData(String path) throws IOException {

        List<String[]> dataSet = new ArrayList<>();
        FileReader fr = null;
        try{
            //Creating stream to read the object
            fr =new FileReader(path);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String row;
            String[] headers = null;
            while((row=br.readLine())!=null)
            {
                String[] column = row.split(","); //split the row data using comma seperator
                dataSet.add(column);
            }

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally {
            fr.close();
            return dataSet;
        }
    }
}
