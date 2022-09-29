
package northandromeda.prueba;

import java.util.ArrayList;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
     public static ArrayList<String>  parametroCsvCurso(String parametroALeer,String nombreArchivo) throws FileNotFoundException, IOException{
            ArrayList<String> listaParametros = new ArrayList<>();
            BufferedReader br = null;
            // se crea un BufferedReader(br) que leera el FileReader(fr) del archivo ubicado en la rutaArchivo
            br = new BufferedReader(new FileReader (nombreArchivo));
            
            String linea = null;
            
            //se busca la columna que contiene los parametros a guardar en el ArrayList
            int columna = buscarColumna_CSV(br.readLine(),parametroALeer); 
            
                //se leerá hasta la ultima linea del archivo
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(";");
                
                listaParametros.add(partes[columna]);
                
            }
        return listaParametros;
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
    
    public static  void agregarAlumno(String[] alumno, String archivo){
        BufferedWriter bufferEscritura= null;
        try{
            bufferEscritura = new BufferedWriter(new FileWriter(archivo, true));
            
            bufferEscritura.newLine();
            for (int i = 0; i < alumno.length; i++){
                if (i != alumno.length - 1){
                    bufferEscritura.write(alumno[i] + ";");
                }else{
                    bufferEscritura.write(alumno[i]);
                }
            }
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }finally{{
            if (bufferEscritura != null){
                try{
                    bufferEscritura.close();
                } catch (IOException ex) {
                    Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }        
    }
    
    public static  ArrayList<String> notasAlumno(String rut, String archivo){
        String separador = ";";
        String line = null;
        ArrayList<String> notas = new ArrayList<>();
        BufferedReader bufferLectura = null;
        try{
            bufferLectura = new BufferedReader(new FileReader(archivo));
            
            while ((line = bufferLectura.readLine()) != null){
                String[] datos = line.split(separador);
                
                if (datos[0].equals(rut)){
                    for(int i=1; i < datos.length; i++){
                        notas.add(datos[i]);
                    }
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{{
            if (bufferLectura != null){
                try{
                    bufferLectura.close();
                } catch (IOException ex) {
                    Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
        }
        }        
        return notas;
    }
    
    public static  void nuevoAlumno(String[] alumno){
        BufferedWriter bufferEscritura= null;
        try{
            bufferEscritura = new BufferedWriter(new FileWriter("Alumnos.csv", true));
            
            bufferEscritura.newLine();
            for (int i = 0; i < alumno.length; i++){
                if (i != alumno.length - 1){
                    bufferEscritura.write(alumno[i] + ";");
                }else{
                    bufferEscritura.write(alumno[i]);
                }
            }
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }finally{{
            if (bufferEscritura != null){
                try{
                    bufferEscritura.close();
                } catch (IOException ex) {
                    Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }        
    }
}
