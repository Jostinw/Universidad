package Controlador.ordenacion;

import Modelo.Censo;
import controlador.lista.LinkedList;

/**
 *
 * @author jostin
 */
public class Quickshort {

    private String atributo;

    public void quickSort(LinkedList<Censo> censos, boolean ordenacion, String atributo) {

        this.atributo = atributo;

        Censo[] listaCensos = censos.toArray();

        quick(listaCensos, 0, listaCensos.length - 1, ordenacion);

        censos.toList(listaCensos);

    }

    private int particion(Censo[] censos, int menor, int mayor, boolean ordenacion) {

        var pivote = censos[mayor];

        int i = (menor - 1);

        for (int j = menor; j < mayor; j++) {

            if (ordenacion ? comparar(censos[j], pivote) <= 0 : comparar(censos[j], pivote) >= 0) {

                i++;
                Censo aux = censos[i];
                censos[i] = censos[j];
                censos[j] = aux;

            }

        }

        Censo aux = censos[i + 1];

        censos[i + 1] = censos[mayor];

        censos[mayor] = aux;

        return i + 1;

    }

    private void quick(Censo[] censos, int menor, int mayor, boolean ordenacion) {

        if (menor < mayor) {

            int p = particion(censos, menor, mayor, ordenacion);

            quick(censos, menor, p - 1, ordenacion);

            quick(censos, p + 1, mayor, ordenacion);

        }

    }

    private Integer comparar(Censo c1, Censo c2) {

        // comparar por el atributo que selecciono
        switch (atributo) {
            case "nombre":
                return Integer.compare(c1.getNombre().compareToIgnoreCase(c2.getNombre()), 0);
            case "motivo":
                return Integer.compare(c1.getMotivo().compareToIgnoreCase(c2.getMotivo()), 0);
            case "estado":
                return Integer.compare(c1.getEstadoEmocional().compareToIgnoreCase(c2.getEstadoEmocional()), 0);
            case "fecha":
                return Integer.compare(c1.getFecha().compareToIgnoreCase(c2.getFecha()), 0);
            default:
                return -2;
        }

    }
}
