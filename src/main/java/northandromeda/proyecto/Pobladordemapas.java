package northandromeda.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import static northandromeda.proyecto.CSV.*;

public class Pobladordemapas {
    //Se crea una lista de tipo alumno con los datos recibidos del csv
    public static ArrayList<Alumno> creatorAlumnos () throws IOException{
        Materia mat = new Materia ("Matematica");
        Materia len = new Materia ("Lenguaje");
        Materia bio = new Materia ("Biologia");
        Materia fis = new Materia ("Fisica");
        Materia quim = new Materia ("Quimica");
        
        ArrayList<String> nombres = parametroCSV ("nombre", "Alumnos.csv");
        ArrayList<String> rut  = parametroCSV ("rut", "Alumnos.csv");
        ArrayList<String> curso  = parametroCsvCurso ("curso", "Alumnos.csv");
        
        ArrayList<Alumno> all = new ArrayList<>();
        
        for(int i=0;i<nombres.size();i++){
            Alumno student = new Alumno (nombres.get(i),rut.get(i),curso.get(i));
            student.agregarAsignatura(mat);
            student.agregarAsignatura(len);
            student.agregarAsignatura(bio);
            student.agregarAsignatura(fis);
            student.agregarAsignatura(quim);
            all.add(student);
        }

        return all;
    }
    
    //Se utiliza la lista de alumnos para insertalos en el mapa de cursos
    public static HashMap<String,Curso> pobladorMapaCursos()throws IOException{      
        HashMap<String,Curso> curse = new HashMap();
     
        ArrayList<Alumno> estudiante = creatorAlumnos();
        for(int i=0;i<estudiante.size();i++){
            Alumno aa = estudiante.get(i);
           
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
}
