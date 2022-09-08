package northandromeda.proyecto;

import java.util.ArrayList;

public class Alumno extends Persona {
    private String curso;
    private ArrayList<Materia> asignaturas;
        
    public Alumno (String nombre, String rut, String curso){
        super(nombre,rut);
        this.curso = curso;
        this.asignaturas = new ArrayList<>();
    }
        
    //Añadir asignatura a un alumno
    public void agregarAsignatura(Materia materia) {
        this.asignaturas.add(materia);
    }
    
    //setter y getter de la clase    
    public String getCursodeAlumno() {
        return curso;
    }
        
    public void setCursodeAlumno(String curso) {
        this.curso = curso;
    }
    
    //Muestra 1 materia en especifico
    public void mostrarNotas(String materia){
        for(Materia cadena : asignaturas){
            if(cadena.getAsignatura().equals(materia)){
                System.out.println("Asignatura :"+cadena.getAsignatura());
                System.out.println("Evaluacion 1 : "+cadena.getEva01());
                System.out.println("Evaluacion 2 : "+cadena.getEva02());
                System.out.println("Evaluacion 3 : "+cadena.getEva03());
                return;
            }
        }
        System.out.println("No se encontro la materia especificada");
    }
    
    //Muestra todas las notas del alumno
    public void mostrarNotas(){
        for(Materia cadena : asignaturas){
                System.out.println("Asignatura :"+cadena.getAsignatura());
                System.out.println("Evaluacion 1 : "+cadena.getEva01());
                System.out.println("Evaluacion 2 : "+cadena.getEva02());
                System.out.println("Evaluacion 3 : "+cadena.getEva03());
        }
    }
}
