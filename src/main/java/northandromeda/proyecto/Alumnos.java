package northandromeda.proyecto;

import java.util.*;

public class Alumnos {
    //Variables de instancia
    private String nombre;
    private String rut;
    private ArrayList<Materias> asignaturas;
    
    //Constructor que recibe los String necesarios para crear al alumno
    public Alumnos (String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
        asignaturas = new ArrayList();
    }
    
    //Constructor que crea un alumno con valores nulos
    public Alumnos (){
        this.nombre = null;
        this.rut = null;
        asignaturas = new ArrayList();
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
    
    //Añadir asignatura a un alumno
    public void agregarAsignatura(Materias oo) {
        asignaturas.add(oo);
    }
}
