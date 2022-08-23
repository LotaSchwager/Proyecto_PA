package northandromeda.proyecto;

import java.util.*;

public class Alumnos {
    private String nombre;
    private int rut;
    private double promedio;
    private ArrayList<Materias> asignaturas;
    
    public Alumnos (String nombre, int rut, double promedio){
        this.nombre = nombre;
        this.rut = rut;
        this.promedio = promedio;
        asignaturas = new ArrayList();
    }
    
    public int getRut() {
        return rut;
    }
    
    public void setRut(int rut) {
        this.rut = rut;
    }
    
    public String getNombre() {
        return nombre;
    }
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getProm() {
        return promedio;
    }
    
    public void setProm(double promedio) {
        this.promedio = promedio;
    }
    
    public void agregarAsignatura(Materias oo) {
        asignaturas.add(oo);
    }
    
    public void getAsigList() {
        
        for (int i = 0;i < 2;i++){
            Materias bb = asignaturas.get(i);
            System.out.println(bb.getAsignatura());
        }
    }
}
