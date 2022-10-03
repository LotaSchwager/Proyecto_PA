package northandromeda.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static northandromeda.proyecto.CSV.*;
import static northandromeda.proyecto.Busqueda.buscarAlumno;

public class Pobladordemapas {
    //Se crea una lista de tipo alumno con los datos recibidos del csv
    public static Lust creatorAlumnos (String materia) throws IOException{
        
        ArrayList<String> nombres = parametroCSV ("nombre", "Alumnos.csv");
        ArrayList<String> rut  = parametroCSV ("rut", "Alumnos.csv");
        ArrayList<String> curso  = parametroCsvCurso ("curso", "Alumnos.csv");
        
        Lust all = new Lust();
        
        for(int i=0;i<nombres.size();i++){
            Alumno student = new Alumno (nombres.get(i),rut.get(i),curso.get(i));
            ArrayList<String> asignaturas  = notasAlumno (rut.get(i), materia + ".csv");
            student.agregarNotas(asignaturas.get(0));
            student.agregarNotas(asignaturas.get(1));
            student.agregarNotas(asignaturas.get(2));
            student.agregarNotas(asignaturas.get(3));
            student.agregarNotas(asignaturas.get(4));
            student.setPromedio();
            
            all.agregar(student);
        }

        return all;
    }
    
    //Se obtiene una lista de alumnos proveniente del csv alumnos
    public static ArrayList<Alumno> listaAlumnos () throws IOException{
        ArrayList alumnos = new ArrayList<>();
        
        ArrayList<String> nombres = parametroCSV ("nombre", "Alumnos.csv");
        ArrayList<String> rut  = parametroCSV ("rut", "Alumnos.csv");
        ArrayList<String> curso  = parametroCsvCurso ("curso", "Alumnos.csv");
        
        for(int i=0;i<nombres.size();i++){
            Alumno student = new Alumno (nombres.get(i),rut.get(i),curso.get(i));
            
            alumnos.add(student);
        }
        return alumnos;
    }
    
    //Se utiliza la lista de alumnos para insertalos en el mapa de cursos
    public static HashMap<String,Curso> pobladorMapaCursos(String materia)throws IOException{      
        HashMap<String,Curso> curse = new HashMap<>();
     
        Lust estudiante = creatorAlumnos(materia);
        for(int i=0;i<estudiante.lustSize();i++){
            Alumno aa = (Alumno) estudiante.getLust(i);
           
            if (curse.containsKey(aa.getCursodeAlumno()) != true){
                    Curso nuevoCurso = new Curso(aa.getCursodeAlumno());
                    nuevoCurso.agregarAlumnos(aa, aa.getRut());
                    curse.put(aa.getCursodeAlumno(), nuevoCurso); 
            }else{
                    Curso cursoExistente = curse.get(aa.getCursodeAlumno());
                    cursoExistente.agregarAlumnos(aa, aa.getRut());
            }
        }
        
        return curse;
    }
   
    //Se crea un hashmap de profesores del csv para los profe
    public static HashMap<String,Profesor> conjuntoDEprofes() throws IOException{
        HashMap<String,Profesor> conjunto = new HashMap<>();
        
        ArrayList<String> nombres = parametroCSV ("profesor", "Profesores.csv");
        ArrayList<String> rut  = parametroCSV ("rut", "Profesores.csv");
        ArrayList<String> curso  = parametroCsvCurso ("materia", "Profesores.csv");
        ArrayList<String> password  = parametroCsvCurso ("clave", "Profesores.csv");
        
        for(int i=0; i < nombres.size(); i++){
            Profesor nuevoProfe = new Profesor(nombres.get(i), rut.get(i), curso.get(i), password.get(i));
            
            conjunto.put(rut.get(i), nuevoProfe);
        }
        
        return conjunto;
    }
    
    //Se crea un arreglo solo para los nombres de los alumnos
    public static ArrayList<String> conjuntoCurso(){
        
        try {
            ArrayList<String> cursos = parametroCsvCurso ("curso", "Alumnos.csv");
            
            return cursos;
            
        } catch (IOException ex) {
            
            Logger.getLogger(Pobladordemapas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static String[] listadoCurso() throws IOException{
            
        ArrayList<Alumno> alumnos = listaAlumnos ();
        ArrayList<String> lista = new ArrayList();
        
        lista.add(alumnos.get(0).getCursodeAlumno());
        
        for(int i=1;i<alumnos.size();i++){
            if(!lista.contains(alumnos.get(i).getCursodeAlumno())){
                lista.add(alumnos.get(i).getCursodeAlumno());
            }
        }
        
        String[] r = new String[lista.size()];
        
        for(int i=0;i<lista.size();i++){
            r[i]=lista.get(i);
        }
        
        return r;
     
    }
}
