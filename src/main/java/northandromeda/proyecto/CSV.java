
package northandromeda.proyecto;

import java.util.ArrayList;
import java.io.*;

public class CSV {
    
    /*Lee el csv de manera vertical osea:
    
        nombre;rut
        nombre1;rut1
        nombre2;rut2
    
    parametroCSV ("nombre", nombre del csv) de como resultado una lista con los nombres.
    
    lista->[nombre1,nombre2]
    */
    public static ArrayList<String> parametroCSV(String parametro, String nombreArchivo) throws FileNotFoundException, IOException{
        ArrayList<String> parametrosList = new ArrayList<>();
        BufferedReader lector =  new BufferedReader (new FileReader (nombreArchivo));
        
        String linea = null;
        
        int columna = buscarColumna_CSV(lector.readLine(), parametro);
        
        while ((linea = lector.readLine()) != null){
            String [] puntoComa = linea.split(";");
            
            if (parametrosList.isEmpty())
                    parametrosList.add(puntoComa[columna]);
                else{
                    /*si la lista de parametros no está vacía, se pregunta si el parametro ya se encuentra en el
                      ArrayList, si no está, se añade al ArrayList el parametro ubicado en la columna correspondiete*/
                    if (parametrosList.contains(puntoComa[columna])!=true){
                        parametrosList.add(puntoComa[columna]);
                    }
                }
        }
        
        return parametrosList;
    }
    
    public static int buscarColumna_CSV(String linea,String columnaDeaseada) {
        int columna = 0;

        String[] partes = linea.split(";");
        for (int i = 0 ; i < partes.length ; i++){
            if (partes[i].toLowerCase().equals(columnaDeaseada.toLowerCase())){
                columna=i;
                break;
            }
        }
        return columna;
    }
    
}
