package northandromeda.proyecto;

public class Menus {
    
    //Menu principal del programa
    static void menuPrincipal (){
        System.out.println ("--Menu Principal--");
        System.out.println ("1.Lista de Alumnos");
        System.out.println ("2.Opcion B");
        System.out.println ("3.Opcion C");
        System.out.println ("4.Salir");
        System.out.println ("\nElija la opcion : ");
    }
    
    //Convierte un char minuscula en una mayuscula
    public static char StringToChar (String s){
        return s.charAt(0);
    }
    
    //Muestra la lista de alumnos
    static void listaAlumnos (String nombre, String rut, int posicion){
        System.out.println(posicion +1+". "+nombre);
        System.out.println("rut : "+rut);
        System.out.println("");
    }
    
}
