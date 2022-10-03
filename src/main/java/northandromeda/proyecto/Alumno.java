package northandromeda.proyecto;

public class Alumno extends Persona {
    private String curso;
    private Double promedio;
    private Lust notas;
        
   //Constructor 
    public Alumno (String nombre, String rut, String curso){
        super(nombre,rut);
        this.curso = curso;
        this.promedio = 0.0;
        this.notas = new Lust();
    }
          
    //setter y getter de la clase    
    public String getCursodeAlumno() {
        return this.curso;
    }
    
    public Double getPromedio (){
        return this.promedio;
    }
    
    //Se actualiza el promedio
    public void setPromedio(){
        
        Double sumaNotas = 0.0;
        for (int i = 0; i < notas.lustSize(); i++){
            sumaNotas += Double.parseDouble((String)notas.getLust(i));
        }
        
        this.promedio = sumaNotas / notas.lustSize();
    }
        
    public void setCursodeAlumno(String curso) {
        this.curso = curso;
    }
    
    //Se agrega Notas
    public void agregarNotas (Object obj){
        
        notas.agregar(obj);
    }
    
    //Obtener la nota de una posicion
    public String getNota (int index){
        
        return (String)this.notas.getLust(index);
    }
  
}
