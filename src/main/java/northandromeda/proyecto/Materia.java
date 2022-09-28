    package northandromeda.proyecto;

public class Materia {
    //Variables de instancia
    private String asignatura;
    private Lust notas;
    
    //Constructor que recibe los String y doubles necesarios para crear la materia
    public Materia(String asignatura){
        this.asignatura = asignatura;
        this.notas = new Lust();
    }
      
    //Getter y setter de la clase
    public String getAsignatura() {
        return asignatura;
    }
    
    public void agregarNotas (double nota){
        this.notas.agregar(nota);
    }
    

}
