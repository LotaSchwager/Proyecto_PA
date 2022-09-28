package northandromeda.proyecto;

public class Alumno extends Persona {
    private String curso;
    private Lust asignaturas;
        
    public Alumno (String nombre, String rut, String curso){
        super(nombre,rut);
        this.curso = curso;
        this.asignaturas = new Lust();
    }
          
    //setter y getter de la clase    
    public String getCursodeAlumno() {
        return curso;
    }
        
    public void setCursodeAlumno(String curso) {
        this.curso = curso;
    }
    
    public void agregarAsignaturas (Object obj){
        
        asignaturas.agregar(obj);
    }
  
}
