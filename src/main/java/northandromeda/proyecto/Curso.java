package northandromeda.proyecto;

import java.util.HashMap;
import java.util.ArrayList;

public class Curso {
    //Variables de instancia
    private String curso;
    private HashMap <String,Alumno> listaAlumnos;
    
    //Constructor
    public Curso(String curso){
        this.curso = curso;
        this.listaAlumnos = new HashMap();
    }
    
    //añadir estudiantes al curso
    public void agregarAlumnos (Alumno estudiante, String rut){
        this.listaAlumnos.put(rut,estudiante);
    }
    
    //Getter y setter
    public String getCurso (){
        return curso;
    }
    
    public void setCurso (String curso){
        this.curso = curso;
    }
    
    //busca alumnos del curso
    public ArrayList<Alumno> buscar(){
        ArrayList<Alumno> alumni = new ArrayList<>();
        for(Alumno value : listaAlumnos.values()){
            alumni.add(value);
        }
        
        return alumni;
    } 
    
    //Buscar alumno dentro del curso con rut
    public Alumno buscar(String rut){
        for(Alumno value : listaAlumnos.values()){
            
            if (value.getRut().equals(rut) == true){

                return value;
            }
        }
        
        return null;
    }
    
}
