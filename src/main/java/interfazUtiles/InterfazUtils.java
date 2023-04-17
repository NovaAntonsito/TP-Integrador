package interfazUtiles;

import clases.Equipo;

import javax.swing.*;
import java.util.ArrayList;

public class InterfazUtils {
    public static void cargarEquipoManualmente(ArrayList<Equipo> listaDeEquipos){
        String nombreEquipo=null;
        for (int i = 0; i < 8; i++) {
            do{
                nombreEquipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo",
                        "Carga de equipos", JOptionPane.INFORMATION_MESSAGE);
                if(nombreEquipo==null || nombreEquipo.equals("")){
                    JOptionPane.showMessageDialog(null,"Ingrese un valor en la casilla","Error",JOptionPane.ERROR_MESSAGE);
                }
            }while(nombreEquipo==null || nombreEquipo.equals(""));
            listaDeEquipos.add(new Equipo(nombreEquipo));
        }
    }
    public static String opciones(){
        return JOptionPane.showInputDialog(null,"Seleccione una opcion:\n" +
                "1. Crear lista de equipos\n" +
                "2. Cargar los equipos\n" +
                "3. Elegir equipo\n" +
                "4. Crear llave derecha\n" +
                "5. Crear llave izquierda\n" +
                "6. Crear rondas\n" +
                "7. Jugar torneo\n" +
                "8. Mostrar resultado del torneo\n" +
                "9. Guardar los datos del ganador en la DB\n" +
                "0. Salir","Opciones",JOptionPane.INFORMATION_MESSAGE);
    }
}
