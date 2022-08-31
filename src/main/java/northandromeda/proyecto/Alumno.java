package northandromeda.proyecto;

import java.util.ArrayList;

public class Alumno {
    //Variables de instancia
    private String nombre;
    private String rut;
    private String curso;
    private ArrayList<Materia> asignaturas;
    
    //Constructor que recibe los String necesarios para crear al alumno
    public Alumno (String nombre, String rut, String curso){
        this.nombre = nombre;
        this.rut = rut;
        this.curso = curso;
        this.asignaturas = new ArrayList();
    }
    
    //Constructor que crea un alumno con valores nulos
    public Alumno (){
        this.nombre = null;
        this.rut = null;
        this.curso = null;
        this.asignaturas = new ArrayList();
    }
    
    //Getter y setter de la clase
    public String getRut() {
        return rut;
    }
    
    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public String getNombre() {
        return nombre;
    }
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCursodeAlumno() {
        return curso;
    }
        
    public void setCursodeAlumno(String curso) {
        this.curso = curso;
    }
    
    //Añadir asignatura a un alumno
    public void agregarAsignatura(Materia materia) {
        this.asignaturas.add(materia);
    }
}
