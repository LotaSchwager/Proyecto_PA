package northandromeda.proyecto;

public class Materias {
    //Variables de instancia
    private String asignatura;
    private double evaluacion1;
    private double evaluacion2;
    private double evaluacion3;
    
    //Constructor que recibe los String y doubles necesarios para crear la materia
    public Materias(String asignatura, double eva01, double eva02, double eva03){
        this.asignatura = asignatura;
        this.evaluacion1 = eva01;
        this.evaluacion2 = eva02;
        this.evaluacion3 = eva03;
    }
    
    //Getter y setter de la clase
    public String getAsignatura() {
        return asignatura;
    }
    
    public double getEva01() {
        return evaluacion1;
    }
    
    public double getEva02() {
        return evaluacion2;
    }
    
    public double getEva03() {
        return evaluacion3;
    }
    
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    public void setEva01(int eva01) {
        this.evaluacion1 = eva01;
    }
    
    public void setEva02(int eva02) {
        this.evaluacion2 = eva02;
    }
    
    public void setEva03(int eva03) {
        this.evaluacion3 = eva03;
    }
}
