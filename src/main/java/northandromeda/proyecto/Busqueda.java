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
    static boolean buscarAlumno(String decicion,HashMap<String,Curso> mapa){
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            
            if (valor.getValue().booleanAlumno(decicion)){
                return true;
            }
            
        }
        return false;
    }
    
    static Alumno buscarAlumno2 (String rut, HashMap<String,Curso> mapa){
        
        for (Curso value : mapa.values()){
            
            if (value.booleanAlumno(rut)){
                
                return value.buscarAlumno(rut);
            }
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
}