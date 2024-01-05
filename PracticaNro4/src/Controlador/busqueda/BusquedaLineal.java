package Controlador.busqueda;

import Modelo.Censo;
import controlador.lista.LinkedList;

/**
 *
 * @author JOSTIN
 */
public class BusquedaLineal {

    private String atributo;

    public LinkedList<Censo> busquedaBinaria(LinkedList<Censo> censos, String atributo, String elemento) {

        LinkedList<Censo> resultado = new LinkedList<>();
        
        this.atributo = atributo;

        Censo[] listaCensos = censos.toArray();

        for (Censo censo : listaCensos) {
            
            if (comparar(censo, elemento)) {
                resultado.add(censo);
            }
            
        }

        return resultado;
    }

    private Boolean comparar(Censo c1, String c2) {
        
        // comparar por el atributo que selecciono
        switch (atributo) {
            case "nombre":
                return c1.getNombre().startsWith(c2);
            case "motivo":
                return c1.getMotivo().startsWith(c2);
            case "estado":
                return c1.getEstadoEmocional().startsWith(c2);
            case "fecha":
                return c1.getFecha().startsWith(c2);
        }
        
        return false;
        
    }

}
