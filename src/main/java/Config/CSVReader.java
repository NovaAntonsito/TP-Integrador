package Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVReader {
    public static final String delimiter = ",";
    public static final String regex = "\\b(?:Argentina|Bélgica|Brasil|Croacia|Dinamarca|Inglaterra|Francia|Alemania|Italia|Japón|México|Países Bajos|Noruega|Polonia|Portugal|Rusia|Senegal|España|Suecia|Suiza|Arabia Saudita)\\b";
    public static void detect(String csvFile){
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(csvFile);
        if(matcher.find()){
            System.out.println("Entro");
        }else{
            System.out.println("No entro");
        }
    }
    public static void read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr : tempArr) {
                    System.out.print(tempStr + " ");
                    detect(tempStr);
                }
                System.out.println();
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
