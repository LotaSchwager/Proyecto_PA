package northandromeda.proyecto;

public class Profesor extends Persona {
    private String materia;
    private String password;
    
    public Profesor (String nombre, String rut, String materia, String password){
        super(nombre,rut);
        this.materia = materia;
        this.password = password;
    }
    
    //getter y setter
    public String getMateria(){
        return this.materia;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setMateria(String materia){
        this.materia = materia;
    }
    
    public void setPassword (String password){
        this.password = password;
    }
}
