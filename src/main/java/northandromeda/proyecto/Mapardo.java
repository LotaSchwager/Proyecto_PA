package northandromeda.proyecto;

import java.util.HashMap;

public class Mapardo {
    private HashMap mapa;
    
    public Mapardo(){
        this.mapa = new HashMap ();
    }
    
    public boolean adherir (Object pibardo, String rut){
        
        if (this.mapa.containsKey(rut)){
            this.mapa.put(rut, pibardo);
            return true;
        }
        
        return false;
    }
    
    public Object buscarPibe (String rut){
        
        if (this.mapa.containsKey(rut)){
            
            return this.mapa.get(rut);
        }
        
        return null;
    }
    
    public int largo (){
        
        return this.mapa.size();
    }
    
    public boolean claveUsada (String clave){
        
        return mapa.containsKey(clave);
    }
    
}
