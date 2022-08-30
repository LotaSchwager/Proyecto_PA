package northandromeda.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static northandromeda.proyecto.CSV.*;

public class CreatorconClase {
    //Se crea un mapa de tipo alumno con los datos recibidos del csv
    public static Map CreatorAlumno () throws IOException{
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> rut = new ArrayList<>();
        
        Materias mat = new Materias ("Matematica",0.0,0.0,0.0);
        Materias len = new Materias ("Lenguaje",0.0,0.0,0.0);
        Materias bio = new Materias ("Biologia",0.0,0.0,0.0);
        Materias fis = new Materias ("Fisica",0.0,0.0,0.0);
        Materias quim = new Materias ("Quimica",0.0,0.0,0.0);
        
        nombres = parametroCSV ("nombre", "Alumnos.csv");
        rut = parametroCSV ("rut", "Alumnos.csv");
        
        Map<Integer,Alumnos> all = new HashMap();
        
        for(int i=0;i<nombres.size();i++){
            Alumnos student = new Alumnos (nombres.get(i),rut.get(i));
            student.agregarAsignatura(mat);
            student.agregarAsignatura(len);
            student.agregarAsignatura(bio);
            student.agregarAsignatura(fis);
            student.agregarAsignatura(quim);
            all.put(i,student);
        }

        return all;
    }
}
