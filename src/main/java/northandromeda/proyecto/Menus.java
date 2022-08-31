package northandromeda.proyecto;

import java.util.HashMap;
import java.util.ArrayList;

public class Menus {
    
    //Menu principal del programa
    static void menuPrincipal (){
        System.out.println ("--Menu Principal--");
        System.out.println ("1.Lista de Cursos");
        System.out.println ("2.Buscar Alumno");
        System.out.println ("3.Añadir alumno");
        System.out.println ("4.Salir");
        System.out.println ("\nElija la opcion : ");
    }
    
    //Convierte un char minuscula en una mayuscula
    public static char StringToChar (String s){
        return s.charAt(0);
    }
    
    //Opcion 1 MENU DE CURSOS
    static void menuOpcion1(HashMap<String,Curso> mapa){
        System.out.println("\nEscriba cual de los siguientes cursos desea ver :(porfavor tal y como se ve en la consola)\n");
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            System.out.println(valor.getKey());
        }
        System.out.println("Todos\n");
    }
    
    //Opcion 1 mostrar los cursos con sus alumnos
    static void mostrarCursos(HashMap<String,Curso> mapa, String decicion){
        
        if (mapa.containsKey(decicion) == true){
            ArrayList<Alumno> alumni  = mapa.get(decicion).mostrarAlumnos();
            System.out.println("Curso : "+decicion);
            for(Alumno aa : alumni){
                System.out.println("Alumno : "+aa.getNombre());
                System.out.println("Rut :"+aa.getRut());
                System.out.println("");
            }
            System.out.println("----------------------------------");
            
        }else{
            
            if (decicion.equals("Todos")){
                for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
                    ArrayList<Alumno> alumni = valor.getValue().mostrarAlumnos();
                    System.out.println("Curso : "+ valor.getKey());
                    for(Alumno aa : alumni){
                         System.out.println("Alumno : "+aa.getNombre());
                         System.out.println("Rut :"+aa.getRut());
                         System.out.println("");
                    }
                    System.out.println("----------------------------------");
                }
                
            }else{
                System.out.println("\nNo has ingresado bien la entrada, intentelo de nuevo");
            }
        }
    }
    
    //Opcion 2 buscar Alumno
    static void buscarAlumno(HashMap<String,Curso> mapa, String decicion){
        int validar = 0;
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            Alumno aa = valor.getValue().buscarAlumno(decicion);
            
            if (null != aa){
                System.out.println("\nSe ha encontrado al alumno :");
                System.out.println("Nombre :"+aa.getNombre());
                System.out.println("Curso :"+aa.getCursodeAlumno());
                System.out.println("");
                validar ++;
            }
        }
        
        if (validar == 0){
            System.out.println("No se ha encontrado al alumno");
        }
    }
    
    //buscar alumno sin mostrar nada
    static boolean buscarAlumno(String decicion,HashMap<String,Curso> mapa){
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            Alumno aa = valor.getValue().buscarAlumno(decicion);
            
            if (null != aa){
                return true;
            }
        }
        return false;
    }
}