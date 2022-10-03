package northandromeda.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static northandromeda.proyecto.Pobladordemapas.conjuntoDEprofes;
import static northandromeda.proyecto.Pobladordemapas.listaAlumnos;

public class Busqueda {
    
    static boolean correctPassword(Profesor profe, String password){
        
        return profe.getPassword().equals(password);
    }
   
    static Profesor buscarProfesor(String rut) throws IOException{
        HashMap<String,Profesor> profesores = conjuntoDEprofes();
        
        if (profesores.containsKey(rut)){
            return profesores.get(rut);
            
        }else{
            
            return null;
        }
    }
    
    //buscar alumno sin mostrar nada
    static boolean nombreRepetido (String nombre){
        try {
            ArrayList <Alumno> alumnos = listaAlumnos();
            
            for (int i = 0; i < alumnos.size(); i++){
                
                if (alumnos.get(i).getNombre().equals(nombre)){
                    
                    return false;
                }
            }
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    static boolean buscarCurso (String curso, ArrayList <String> list){
        
        for (int i = 0; i < list.size(); i++){
            
            if (list.get(i).equals(curso)){
                
                return true;
            }
        }
        
        return false;
    }
    static Lust buscarCurso(String curso){
        try {
            ArrayList <Alumno> studiantes = listaAlumnos();
            Lust list = new Lust();
            for (int i = 0; i < studiantes.size(); i++){
                
                if (studiantes.get(i).getCursodeAlumno().equals(curso)){
                    
                    list.agregar(studiantes.get(i));
                }
            }
            
            return list;
        } catch (IOException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    static Alumno buscarAlumno(String rut){
        try {
            ArrayList <Alumno> studiantes = listaAlumnos();
            
            for (int i = 0; i < studiantes.size(); i++){
                
                if (studiantes.get(i).getRut().equals(rut)){
                    
                    return studiantes.get(i);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static int reverseNumero(int numero){
        
      int rev = 0; // reversed number
      int rem;   // remainder
        
      while(numero > 0){
           
        rem = numero%10;
        rev = (rev*10) + rem;
        numero = numero/10;
      }
        
      return rev;
    }
    
    public static int obtenerVerificador (int numero){
        int reverso = reverseNumero(numero);
        int primer = (int)reverso / 10000000;
        int segundo = ((int)reverso / 1000000) % 10;
        int tercero = ((int)reverso / 100000) % 10;
        int cuarto = ((int)reverso / 10000) % 10;
        int quinto = ((int)reverso / 1000) % 10;
        int sexto = ((int)reverso / 100) % 10;
        int septimo = ((int)reverso / 10) % 10;
        int octavo = (int)(reverso % 10);
        
        int[] reversoVector = {primer,segundo,tercero,cuarto,quinto,sexto,septimo,octavo};
        int[] multiplicadores = {2,3,4,5,6,7};
        int[] sumas = new int[8];
        
        int j = 0;
        for(int i = 0; i < reversoVector.length; i++){
            
            if (j == 6){j = 0;}
            
            sumas[i] = reversoVector[i] * multiplicadores[j];
            j++;
        }
        
        int sumaTotal = 0;
        for (int i = 0; i < sumas.length; i++){
            
            sumaTotal += sumas[i];
        }
        
        int sumaInt = (int)sumaTotal / 11;
        
        sumaInt = sumaInt * 11;
        
        int definitivo = Math.abs(sumaTotal - sumaInt);
        
        definitivo = 11 - definitivo;
        
        if (definitivo == 11) return 0;
        
        if (definitivo == 10) return 99;
        
        return definitivo;
        
    }
    
    public static String toRut (int numero, int digito, int version){
        String primer = String.valueOf((int)numero / 10000000);
        String segundo =  String.valueOf(((int)numero / 1000000) % 10);
        String tercero = String.valueOf(((int)numero / 100000) % 10);
        String cuarto = String.valueOf(((int)numero / 10000) % 10);
        String quinto = String.valueOf(((int)numero / 1000) % 10);
        String sexto = String.valueOf( ((int)numero / 100) % 10);
        String septimo = String.valueOf(((int)numero / 10) % 10);
        String octavo = String.valueOf((int)(numero % 10));
        String digito2 = String.valueOf(digito);
        
        if (version == 8){
            
            String rut = primer+segundo+"."+tercero+cuarto+quinto+"."+sexto+septimo+octavo+"-"+"k";
            return rut;
        
        }else{
            
            String rut = primer+segundo+"."+tercero+cuarto+quinto+"."+sexto+septimo+octavo+"-"+digito2;
            return rut;
        }

    }
    static Lust BuscarALumnosCursos(String curso){
        try {
            ArrayList <Alumno> studiantes = listaAlumnos();
            Lust list = new Lust();
            for (int i = 0; i < studiantes.size(); i++){
                
                if (studiantes.get(i).getCursodeAlumno().equals(curso)){
                    
                    list.agregar(studiantes.get(i));
                }
            }
            
            return list;
        } catch (IOException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}