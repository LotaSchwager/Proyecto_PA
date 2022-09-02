package northandromeda.proyecto;

import java.io.*;
import java.util.*;
import static northandromeda.proyecto.Pobladordemapas.*;

public class Proyecto {
    
    public static void main(String[] args) throws IOException {
        int option;
        String decicion,nombre,rut,curso;
        BufferedReader lector = new BufferedReader (new InputStreamReader (System.in));
        HashMap <String,Curso> estudiantes = pobladorMapaCursos ();//Mapa con los cursos
        
        do{
            Menus.menuPrincipal();
            option = Integer.parseInt (lector.readLine());
            
            switch (option){
                
                case 1:
                    //Se muestran la lista de los cursos   
                    Menus.menuOpcion1(estudiantes);
                    decicion = lector.readLine();
                    Menus.mostrarCursos(estudiantes, decicion);
               
                    break;
                    
                case 2:
                    //Se pide al usuario que escriba el rut del alumno que desea buscar
                    System.out.println("Escriba el rut del alumno (El rut debe venir con punto y el guion):");
                    decicion = lector.readLine();
                    Menus.buscarAlumno(estudiantes, decicion);
                    break;
                    
                case 3:
                    //Se pedira al usuario que escriba el nombre,rut y curso a la cual pertenece el nuevo alumno
                    System.out.println("Tenga en cuenta que si coloca un alumno con el mismo rut no se añadira el alumno");
                    System.out.println("Escriba el nombre del nuevo alumno");
                    nombre = lector.readLine();
                    System.out.println("Escriba el rut del nuevo alumno");
                    rut = lector.readLine();
                    System.out.println("Especifique el curso perteneciente del nuevo alumno");
                    curso = lector.readLine();
                    estudiantes = agregarAlumnoalMapa(nombre,rut,curso,estudiantes);
                    System.out.println("Listo se ha agregado exitosamente el nuevo alumno");
                    break;
                    
                case 4:
                    System.out.println ("Desea realmente salir? (Y/N)");
                    char yesNO = Menus.StringToChar(lector.readLine());
                    if (yesNO == 'Y' | yesNO == 'y'){
                        break;
                    }else{
                        option = 5;
                        break;
                    }
                    
                default:
                    System.out.println ("\nElijio una opcion no disponible\n");
                    break;
            }
            
            
        } while (option != 4);
    }

}