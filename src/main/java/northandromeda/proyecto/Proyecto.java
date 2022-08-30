package northandromeda.proyecto;

import java.io.*;
import java.util.*;
import static northandromeda.proyecto.CreatorconClase.*;

public class Proyecto {
    
    public static void main(String[] args) throws IOException {
        int option;
        BufferedReader lector = new BufferedReader (new InputStreamReader (System.in));
        Map estudiantes = CreatorAlumno();
        
        do{
            Menus.menuPrincipal();
            option = Integer.parseInt (lector.readLine());
            
            switch (option){
                
                case 1:
                    
                    for (int i=0;i < estudiantes.size();i++){
                        Alumnos aa = (Alumnos) estudiantes.get(i);
                        Menus.listaAlumnos(aa.getNombre(), aa.getRut(), i);
                    }
                                      
                    break;
                    
                case 2:
                    System.out.println ("Opcion 2");
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