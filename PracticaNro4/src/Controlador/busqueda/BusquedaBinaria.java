package Controlador.busqueda;

import Controlador.ordenacion.MergeSort;
import Modelo.Censo;
import controlador.lista.Exception.VacioException;
import controlador.lista.LinkedList;

/**
 *
 * @author JOSTIN
 */
public class BusquedaBinaria {

    private String atributo;

    public LinkedList<Censo> busquedaBinaria(LinkedList<Censo> censos, String atributo, String elemento) {

        LinkedList<Censo> resultado = new LinkedList<>();
        
        this.atributo = atributo;

        new MergeSort().mergeSort(censos, true, atributo);

        Censo[] listaCensos = censos.toArray();
        
        Integer pos = binario(listaCensos, elemento, 0, listaCensos.length - 1);
        
        if(pos >= 0){
            
            try {
                resultado.add(censos.get(pos));
            } catch (VacioException ex) {
                System.out.println(ex.getMessage());
            }
            
        }

        return resultado;
    }

    private int binario(Censo[] censos, String elemento, Integer menor, Integer mayor) {

        if (mayor >= menor) {

            Integer mid = menor + (mayor - menor) / 2;

            if (comparar(censos[mid], elemento) == 0) {
                return mid;
            }

            if (comparar(censos[mid], elemento) > 0) {
                return binario(censos, elemento, menor, mid - 1);
            }

            return binario(censos, elemento, mid + 1, mayor);

        }

        return -1;
    }

    private Integer comparar(Censo c1, String c2) {

        // comparar por el atributo que selecciono
        switch (atributo) {
            case "nombre":
                return Integer.compare(c1.getNombre().compareToIgnoreCase(c2), 0);
            case "motivo":
                return Integer.compare(c1.getMotivo().compareToIgnoreCase(c2), 0);
            case "estado":
                return Integer.compare(c1.getEstadoEmocional().compareToIgnoreCase(c2), 0);
            case "fecha":
                return Integer.compare(c1.getFecha().compareToIgnoreCase(c2), 0);
            default:
                return -2;
        }

    }

}
