
package northandromeda.proyecto;
// añadir persona, mostrar persona, ordenar por rut, salir

import java.io.*;
import java.util.*;
import static northandromeda.proyecto.CSV.*;

public class Proyecto {
    
    public static void main(String[] args) throws IOException {
        int option;
        BufferedReader lector = new BufferedReader (new InputStreamReader (System.in));
        
        do{
            Menus.menuPrincipal();
            option = Integer.parseInt (lector.readLine());
            
            switch (option){
                
                case 1:
                    /*Materias cc = new Materias ("Matematica",4,5,4);
                    Materias cv = new Materias ("Lenguaje",2,3,5);
                    Materias ce = new Materias ("Biologia",2,3,5);
                    
                    Alumnos aa1 = new Alumnos ("papyrus",12345678, 0.0);
                    Alumnos aa2 = new Alumnos ("sans",87654321, 0.0);
                    
                    Map<Integer,Alumnos> mm = new HashMap();
                    mm.put(10,aa1);
                    mm.put(20,aa2);
                    
                    Alumnos aa = mm.get(10);
                    aa.agregarAsignatura(cc);
                    aa.agregarAsignatura(cv);
                    
                    aa.agregarAsignatura(ce);
                    
                    System.out.println(aa1.getNombre());
                    System.out.println(aa1.getRut());
                    
                    aa1.getAsigList();
                    System.out.println("");*/
                    
                    ArrayList<String> gg = new ArrayList<>();
                    gg = parametroCSV ("nombre", "Alumnos.csv");
                    
                    for (int i = 0; i < 20; i++){
                        System.out.println(gg.get(i));
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

