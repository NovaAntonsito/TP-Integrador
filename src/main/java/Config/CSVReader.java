package Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVReader {
    public static final String delimiter = ",";

    public static List<String> cant = new ArrayList<>();
    public static final String regex = "\\b(?:Argentina|Bélgica|Brasil|Croacia|Dinamarca|Inglaterra|Francia|Alemania|Italia|Japón|México|Países Bajos|Noruega|Polonia|Portugal|Rusia|Senegal|España|Suecia|Suiza|Arabia Saudita)\\b";
   //Funcion para detectar equipos por nombres
   public static void detect(String csvFile) {
       Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
       Matcher matcher = pattern.matcher(csvFile);
       if (matcher.find()) {
           String str = csvFile;
           if (!cant.contains(str)) {
               cant.add(str);
           }
       }
   }

    //Funcion para leer linea por linea
    public static void read(String csvFile) {
        try {
            cant.clear(); // Limpiamos la lista cant antes de empezar a leer el archivo
            File file = new File(csvFile); //Va a leer el csv en el path que se le asigne
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] tempArr;
            while ((line = br.readLine()) != null) {  //Recorro el archivo y lo divido en lineas y las asigno en una array
                tempArr = line.split(delimiter);
                for (String tempStr : tempArr) {
                    detect(tempStr);  //Las paso en un regex que las guarda en un array
                }
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
