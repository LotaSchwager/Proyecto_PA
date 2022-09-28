package northandromeda.proyecto;

import java.io.IOException;
import java.util.HashMap;
import static northandromeda.proyecto.Pobladordemapas.conjuntoDEprofes;

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
    static boolean buscarAlumno2(String decicion,HashMap<String,Curso> mapa){
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            
            if (valor.getValue().buscarAlumno(decicion)){
                return true;
            }
            
        }
        return false;
    }
}