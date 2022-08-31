package northandromeda.proyecto;

import java.util.HashMap;

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
    
    //mostrar alumnos del curso
    public void mostrarAlumnos(){
        System.out.println("Curso : " + curso);
        for(Alumno value : listaAlumnos.values()){
            System.out.println("Alumno : " + value.getNombre());
            System.out.println("rut : " + value.getRut());
            System.out.println("");
        }
        System.out.println("--------------------------------");
    }
    
    //Buscar alumno dentro del curso
    public boolean buscarAlumno(String rut){
        for(Alumno value : listaAlumnos.values()){
            
            if (value.getRut().equals(rut) == true){
                System.out.println("\nSe ha encontrado al alumno :");
                System.out.println("Nombre : "+value.getNombre());
                System.out.println("Curso : "+value.getCursodeAlumno());
                System.out.println("");
                return true;
            }
        }
        
        return false;
    }
}
