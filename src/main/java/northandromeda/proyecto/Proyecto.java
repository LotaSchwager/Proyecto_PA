package northandromeda.proyecto;

import java.io.*;
import java.util.*;
import static northandromeda.proyecto.Pobladordemapas.*;

public class Proyecto {
    
    public static void main(String[] args) throws IOException {
        int option;
        String decicion;
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
                    Menus.menuOpcion2(estudiantes, decicion);
                    break;
                    
                case 3:
                    System.out.println ("Opcion 3");
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