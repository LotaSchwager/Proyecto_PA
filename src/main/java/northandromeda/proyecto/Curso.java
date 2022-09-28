package northandromeda.proyecto;

public class Curso {
    //Variables de instancia
    private String curso;
    private Mapardo mapaAlumnos;
    
    //Constructor
    public Curso(String curso){
        this.curso = curso;
        this.mapaAlumnos = new Mapardo();
    }
    
    //añadir estudiantes al curso
    public boolean agregarAlumnos (Alumno estudiante, String rut){
        
        return this.mapaAlumnos.adherir(estudiante, rut);
    }
    
    public boolean buscarAlumno (String clave){
        
        return (this.mapaAlumnos.buscarPibe(clave)) != null;
    }
    
    //Getter y setter
    public String getCurso (){
        return curso;
    }
    
    public void setCurso (String curso){
        this.curso = curso;
    }
      
}
