import Config.CSVReader;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        //Ubicacion del CSV
        CSVReader.read("C:\\Users\\Marcos Anton\\Desktop\\resultados.csv");

        List<String> palabras = new ArrayList<String>();
        List<Integer> numeros = new ArrayList<Integer>();

        for (String elemento : CSVReader.cant) {
            // Dividir la string en palabras
            String[] palabrasArray = elemento.split("\\s+");

            for (String palabra : palabrasArray) {
                // Verificar si la palabra es un número
                if (palabra.matches("\\d+")) {
                    numeros.add(Integer.parseInt(palabra));
                } else {
                    palabras.add(palabra);
                }
            }
        }

        System.out.println("Palabras: " + palabras);
        System.out.println("Números: " + numeros);
    }


}



