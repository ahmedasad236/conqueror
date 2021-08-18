package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadingCSVFile {
    public static ArrayList<String[]> readFile(String path) throws IOException{
        String line="";
        FileReader fileReader=new FileReader(path);
        BufferedReader br=new BufferedReader(fileReader);
        ArrayList<String[]> Csv=new ArrayList<String[]>();

        while ((line=br.readLine())!=null){
            String[] row = line.split(",");
            Csv.add(row);
        }
        return csv;
    }
    
}
