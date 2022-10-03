package northandromeda.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static northandromeda.proyecto.Pobladordemapas.conjuntoDEprofes;
import static northandromeda.proyecto.Pobladordemapas.listaAlumnos;

public class Busqueda {
    
    //Comprueba si es la contraseña correcta para el profe en cuestion
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
    
    //Comprueba si el curso existe
    static boolean buscarCurso (String curso, ArrayList <String> list){
        
        for (int i = 0; i < list.size(); i++){
            
            if (list.get(i).equals(curso)){
                
                return true;
            }
        }
        
        return false;
    }
    
    //Devuelve una lista con los  cursos existentes
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
    
    //Busca un alumno con respecto a un rut
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
    
    //Toma un numero int y lo da vuelta
    public static int reverseNumero(int numero){
        
      int rev = 0; 
      int rem;
        
      while(numero > 0){
           
        rem = numero%10;
        rev = (rev*10) + rem;
        numero = numero/10;
      }
        
      return rev;
    }
    
    //Calcula el digito verificador de un rut (sin el propio digito)
    public static int obtenerVerificador (int numero){
        int reverso = reverseNumero(numero);//Se da vuelta el numero
        
        //Se obtiene cada digito del numero
        int primer = (int)reverso / 10000000;
        int segundo = ((int)reverso / 1000000) % 10;
        int tercero = ((int)reverso / 100000) % 10;
        int cuarto = ((int)reverso / 10000) % 10;
        int quinto = ((int)reverso / 1000) % 10;
        int sexto = ((int)reverso / 100) % 10;
        int septimo = ((int)reverso / 10) % 10;
        int octavo = (int)(reverso % 10);
        
        //Se añaden a un arreglo, ademas de inicializar 2 arreglos mas 
        int[] reversoVector = {primer,segundo,tercero,cuarto,quinto,sexto,septimo,octavo};
        int[] multiplicadores = {2,3,4,5,6,7};
        int[] sumas = new int[8];
        
        //Se calcula multiplicando el arreglo reversoVecotr con multiplicadores
        int j = 0;
        for(int i = 0; i < reversoVector.length; i++){
            
            if (j == 6){j = 0;}
            
            sumas[i] = reversoVector[i] * multiplicadores[j];
            j++;
        }
        
        //los resultados se suman
        int sumaTotal = 0;
        for (int i = 0; i < sumas.length; i++){
            
            sumaTotal += sumas[i];
        }
        
        //Se divide con 11
        int sumaInt = (int)sumaTotal / 11;
        
        //Se multiplica con 11
        sumaInt = sumaInt * 11;
        
        //Se resta la sumatotal dada con las multiplicaciones con la variable que se multiplico con 11 y se dividio en 11
        int definitivo = Math.abs(sumaTotal - sumaInt);
        
        //A ese numero se le resta 11 y listo tenemos nuestro digito verificador
        definitivo = 11 - definitivo;
        
        if (definitivo == 11) return 0;
        
        if (definitivo == 10) return 99;
        
        return definitivo;
        
    }
    
    //Tomo el rut (sin digito) + el digito + si era un rut con termino k o no
    //A todo eso lo convierto en un String
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
    
    //Busca a los alumnos pertenecientes a un curso
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