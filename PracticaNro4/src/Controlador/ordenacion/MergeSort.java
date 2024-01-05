package Controlador.ordenacion;

import Modelo.Censo;
import controlador.lista.LinkedList;

/**
 *
 * @author JOSTIN
 */
public class MergeSort {

    private String atributo;

    public void mergeSort(LinkedList<Censo> censos, boolean ordenacion, String atributo) {
        this.atributo = atributo;

        Censo[] listaCensos = censos.toArray();

        mergeS(listaCensos, 0, listaCensos.length - 1, ordenacion);

        censos.toList(listaCensos);
    }

    private void mergeS(Censo[] censos, int izq, int der, boolean ordenacion) {

        if (izq < der) {

            int m = izq + (der - izq) / 2;

            mergeS(censos, izq, m, ordenacion);

            mergeS(censos, m + 1, der, ordenacion);

            merge(censos, izq, m, der, ordenacion);

        }

    }

    private void merge(Censo[] censos, int izq, int mitd, int der, boolean ordenacion) {

        int n1 = mitd - izq + 1;
        int n2 = der - mitd;

        Censo[] I = new Censo[n1];
        Censo[] D = new Censo[n2];

        for (int i = 0; i < n1; ++i) {
            I[i] = censos[izq + i];
        }

        for (int j = 0; j < n2; ++j) {
            D[j] = censos[mitd + 1 + j];
        }

        int i = 0, j = 0;

        int k = izq;

        while (i < n1 && j < n2) {

            if (ordenacion ? comparar(I[i], D[j]) <= 0 : comparar(I[i], D[j]) >= 0) {

                censos[k] = I[i];
                i++;

            } else {

                censos[k] = D[j];
                j++;

            }

            k++;
        }

        while (i < n1) {
            censos[k] = I[i];
            i++;
            k++;
        }

        while (j < n2) {
            censos[k] = D[j];
            j++;
            k++;
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
