package northandromeda.proyecto;

import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static northandromeda.proyecto.Busqueda.buscarAlumno;

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
    
    public static void agregarNotasnueva(String archivo, String rut, String eva1, String eva2, String eva3, String eva4, String eva5){
        String tempFile = "temp.csv";
        File oldFile = new File (archivo);
        File newFile = new File (tempFile);
        String ruut = "";String eva01 = "";String eva02 = "";String eva03 = "";String eva04 = "";String eva05 = "";         
        try{
            FileWriter fw = new FileWriter (tempFile,true);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter pw = new PrintWriter (bw);
            Scanner x = new Scanner (new File(archivo));
            x.useDelimiter("[;\n]");
            
            while (x.hasNext()){
                
                ruut = x.next();
                eva01 = x.next();
                eva02 = x.next();
                eva03 = x.next();
                eva04 = x.next();
                eva05 = x.next();
                
                if (ruut.equals(rut)){
                    
                    pw.println(rut + ";" + eva1 + ";" + eva2 + ";" + eva3 + ";" + eva4 + ";" + eva5);
                
                }else{
                    
                    pw.println(ruut + ";" + eva01 + ";" + eva02 + ";" + eva03 + ";" + eva04 + ";" + eva05);
                }
            }
            
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File (archivo);
            newFile.renameTo(dump);
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
        public static void archivoTXT(HashMap<String, Curso> cursos, ArrayList<Alumno> alumnos){
        File oldFile = new File ("Archivo.txt");
        oldFile.delete();
        
        File newFile = new File("Archivo.txt");
        BufferedWriter bw= null;
        try{
            bw = new BufferedWriter(new FileWriter(newFile));
            
            bw.write("Clase Curso :");
            bw.newLine();
            for (Curso value : cursos.values()){
                bw.newLine();
                bw.write("Curso : " + value.getCurso());
                bw.newLine();
                bw.newLine();
                bw.write("Alumnos de este curso :");
                bw.newLine();
                bw.newLine();
                
                for (int i = 0; i < alumnos.size(); i++){
                    
                    Alumno estudainte = buscarAlumno(alumnos.get(i).getRut());
                    
                    if (estudainte != null){
                        
                        bw.write(estudainte.getNombre());
                        bw.newLine();
                    }
                }
                
                bw.write("-------------------------------------------");
                bw.newLine();
                bw.newLine();
            }
            
            bw.newLine();
            bw.write("Clase Alumno :");
            bw.newLine();
            for (int i = 0; i < alumnos.size(); i++){
                
                bw.newLine();
                bw.write("Nombre :" + alumnos.get(i).getNombre());
                bw.newLine();
                bw.write("Rut :" + alumnos.get(i).getRut());
                bw.newLine();
                bw.write("Curso :" + alumnos.get(i).getCursodeAlumno());
                bw.newLine();
                bw.write("-----------------------------------------");
                
            }

                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }finally{{
            if (bw != null){
                try{
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }
    }
   
}
