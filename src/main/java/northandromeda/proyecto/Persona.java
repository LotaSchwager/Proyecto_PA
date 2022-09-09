package northandromeda.proyecto;

public abstract class Persona {
    //Variables de instancia
    private String nombre;
    private String rut;
    
    //Constructor que recibe los String necesarios para crear al alumno
    public Persona (String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;

    }
    
    //Constructor que crea un alumno con valores nulos
    public Persona (){
        this.nombre = null;
        this.rut = null;

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
    
}
