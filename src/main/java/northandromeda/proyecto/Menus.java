package northandromeda.proyecto;

import java.util.HashMap;

public class Menus {
    
    //Menu principal del programa
    static void menuPrincipal (){
        System.out.println ("--Menu Principal--");
        System.out.println ("1.Lista de Cursos");
        System.out.println ("2.Buscar Alumno");
        System.out.println ("3.Opcion C");
        System.out.println ("4.Salir");
        System.out.println ("\nElija la opcion : ");
    }
    
    //Convierte un char minuscula en una mayuscula
    public static char StringToChar (String s){
        return s.charAt(0);
    }
    
    //Opcion 1 lista de cursos
    static void menuOpcion1(HashMap<String,Curso> mapa){
        System.out.println("\nEscriba cual de los siguientes cursos desea ver :(porfavor tal y como se ve en la consola)\n");
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            System.out.println(valor.getKey());
        }
        System.out.println("Todos\n");
    }
    
    static void mostrarCursos(HashMap<String,Curso> mapa, String decicion){
        
        if (mapa.containsKey(decicion) == true){
            mapa.get(decicion).mostrarAlumnos();
            
        }else{
            
            if (decicion.equals("Todos")){
                for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
                    valor.getValue().mostrarAlumnos();
                }
                
            }else{
                System.out.println("\nNo has ingresado bien la entrada, intentelo de nuevo");
            }
        }
    }
    
    //Opcion 2 buscar Alumno
    static void menuOpcion2(HashMap<String,Curso> mapa, String decicion){
        int valides = 0;
        for(HashMap.Entry<String,Curso> valor : mapa.entrySet()){
            if (valor.getValue().buscarAlumno(decicion)){
                valides = 1;
            }
        }
        
        if (valides == 0){
            System.out.println("\nNo se ha encontrado al alumno");
        }
    }
}