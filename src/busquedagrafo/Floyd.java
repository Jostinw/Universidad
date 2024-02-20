/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busquedagrafo;

import controlador.ControladorAntena;
import java.util.*;

/**
 *
 * @author JOSTIN
 */
public class Floyd {

    private static final double INF = Double.MAX_VALUE;

    public static String floyd(double[][] grafo, int origen, int destino) {
        int n = grafo.length;

        double[][] destinos = new double[n][n];
        int[][] siguiente = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                destinos[i][j] = grafo[i][j];
                if (i != j && grafo[i][j] != INF) {
                    siguiente[i][j] = j;
                } else {
                    siguiente[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (destinos[i][k] != INF && destinos[k][j] != INF
                            && destinos[i][k] + destinos[k][j] < destinos[i][j]) {
                        destinos[i][j] = destinos[i][k] + destinos[k][j];
                        siguiente[i][j] = siguiente[i][k];
                    }
                }
            }
        }

        List<Integer> caminoResultado = camino(origen, destino, siguiente);
        
        ControladorAntena tele = new ControladorAntena();
        var lista = tele.getDaoAntena().listAll().toArray();
        if (caminoResultado.isEmpty()) {
            return "No hay camino de " + lista[origen].getNombre() + " a " + lista[destino].getNombre();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Camino más corto de ").append(lista[origen].getNombre()).append(" a ").append(lista[destino].getNombre()).append(": ");
            for (int node : caminoResultado) {
                sb.append(lista[node].getNombre()).append(" -> ");
            }
            sb.delete(sb.length() - 4, sb.length());
            return sb.toString();
        }
    }

    private static List<Integer> camino(int origen, int destino, int[][] siguiente) {
        List<Integer> camino = new ArrayList<>();
        if (siguiente[origen][destino] == -1) {
            return camino;
        }
        camino.add(origen);
        while (origen != destino) {
            origen = siguiente[origen][destino];
            camino.add(origen);
        }
        return camino;
    }

}
