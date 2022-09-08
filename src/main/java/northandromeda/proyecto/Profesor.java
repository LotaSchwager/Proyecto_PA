package northandromeda.proyecto;

public class Profesor extends Persona {
    private String materia;
    
    public Profesor (String nombre, String rut, String materia){
        super(nombre,rut);
        this.materia = materia;
    }
    
    //getter y setter
    public String getMateria(){
        return this.materia;
    }
    
    public void setMateria(String materia){
        this.materia = materia;
    }
}
