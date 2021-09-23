
package objetos;

import java.util.ArrayList;


public class Nombres {

    ArrayList<String> nombres = new ArrayList<String>();
    
    public Nombres() {
        
    }
    
    public ArrayList<String> getNombres(){
        return nombres;
        
    }
    
    public void setNombre(String x){
        nombres.add(x);
    }
}
