package northandromeda.proyecto;

import java.util.ArrayList;

public class Lust {
    private ArrayList lista;
    
    public Lust(){
        this.lista = new ArrayList();
    }
    
    public boolean agregar (Object obj){
        
        if (lista.contains(obj)){
            this.lista.add(obj);
            return true;
        }
        return false;
    }
    
    public Object getLust(int index){
        
        return lista.get(index);
    }
    
    public void agregar(int index, Object obj){
        
        lista.add(index, obj);
    }
    
    public int lustSize(){
        
        return lista.size();
    }
    
}
