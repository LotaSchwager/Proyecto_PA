package northandromeda.prueba;

import java.util.ArrayList;

public class Lust {
    private ArrayList lista;
    
    public Lust(){
        this.lista = new ArrayList();
    }
    
    public void agregar (Object obj){
        
        this.lista.add(obj);
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
