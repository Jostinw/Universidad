package controlador;

import modelo.Conexion;
import controlador.dao.DataAccessObject;

public class ConexionDAO extends DataAccessObject<Conexion> {
    
    private Conexion conexion;
    
    public ConexionDAO(){
        super(Conexion.class);
    }
    
    public void guardarConexion(Integer origen, Integer destino, Double peso){
        conexion = new Conexion(origen, destino, peso);
        
        save(conexion);
        
        conexion = null;
    }
    
}
