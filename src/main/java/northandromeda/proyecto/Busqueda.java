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
        
    //Opcion 2 buscar Alumno con notas de una materia en especifico
    static void buscarAlumno(HashMap<String,Curso> mapa, String decicion, String materia){
        int validar = 0;
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            Alumno aa = valor.getValue().buscar(decicion);
            
            if (null != aa){
                System.out.println("\nSe ha encontrado al alumno :");
                System.out.println("Nombre : "+aa.getNombre());
                System.out.println("Curso : "+aa.getCursodeAlumno());
                aa.mostrarNotas(materia);
                System.out.println("");
                validar ++;
            }
        }
        
        if (validar == 0){
            System.out.println("\nNo se ha encontrado al alumno");
        }
    }
    
    //Opcion 2 buscar Alumno con notas de una materia en especifico
    static void buscarAlumno(HashMap<String,Curso> mapa, String decicion){
        int validar = 0;
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            Alumno aa = valor.getValue().buscar(decicion);
            
            if (null != aa){
                System.out.println("\nSe ha encontrado al alumno :");
                System.out.println("Nombre : "+aa.getNombre());
                System.out.println("Curso : "+aa.getCursodeAlumno());
                aa.mostrarNotas();
                System.out.println("");
                validar ++;
            }
        }
        
        if (validar == 0){
            System.out.println("\nNo se ha encontrado al alumno");
        }
    }
    
    //buscar alumno sin mostrar nada
    static boolean buscarAlumno2(String decicion,HashMap<String,Curso> mapa){
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            Alumno aa = valor.getValue().buscar(decicion);
            
            if (null != aa){
                return true;
            }
        }
        return false;
    }
}