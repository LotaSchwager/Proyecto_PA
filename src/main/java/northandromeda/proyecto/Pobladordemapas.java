package northandromeda.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

    //nuevo alumno
    public static HashMap<String,Curso> agregarAlumnoalMapa(String nombre, String rut, String curso, HashMap<String,Curso> mapa){
            
           if (buscarAlumno(rut,mapa)){
                return mapa;
               
           }else{
               Alumno alumni = new Alumno(nombre,rut,curso);           
               
               if (mapa.containsKey(curso)){
                  Curso cursoExistente = mapa.get(curso);
                  cursoExistente.agregarAlumnos(alumni, rut);
            
               }else{
                  Curso nuevoCurso = new Curso (curso);
                  nuevoCurso.agregarAlumnos(alumni, rut);
                  mapa.put(curso, nuevoCurso);
               }
            
               return mapa;
           }
     
    }

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
}
