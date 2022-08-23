package northandromeda.proyecto;

public class Menus {
    
    static void menuPrincipal (){
        System.out.println ("--Menu Principal--");
        System.out.println ("1.Opcion A");
        System.out.println ("2.Opcion B");
        System.out.println ("3.Opcion C");
        System.out.println ("4.Salir");
        System.out.println ("\nElija la opcion : ");
    }
    
    public static char StringToChar (String s){
        return s.charAt(0);
    }
    
}
