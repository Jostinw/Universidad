package controlador;

import modelo.Antena;
import controlador.dao.DataAccessObject;

public class AntenaDAO extends DataAccessObject<Antena>{
    private Antena antena;
    
    public AntenaDAO(){
        super(Antena.class);
    }
    
    
    public void guardarTelefonia(String nombre, Double latitud, Double longitud, String[]fotos){
        
        antena = new Antena(nombre, latitud, longitud);
        
        for(int i = 0; i < antena.getFotos().length; i++){
            antena.getFotos()[i] = fotos[i];
        }
        
        save(antena);
        
        antena = null;
    }
    
    
}
