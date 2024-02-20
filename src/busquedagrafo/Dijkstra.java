package busquedagrafo;

import controlador.ControladorAntena;

public class Dijkstra {

    private static final double INF = Double.POSITIVE_INFINITY;

    public static String dijkstra(double[][] grafo, int origen, int destino) {
        int n = grafo.length;
        double[] distancias = new double[n];
        boolean[] visitados = new boolean[n];
        int[] aterior = new int[n];

        for (int i = 0; i < n; i++) {
            distancias[i] = INF;
            aterior[i] = -1;
        }

        distancias[origen] = 0;

        for (int contador = 0; contador < n - 1; contador++) {
            int u = distanciaMedia(distancias, visitados);
            visitados[u] = true;

            for (int i = 0; i < n; i++) {
                if (!visitados[i] && grafo[u][i] != 0 && distancias[u] != INF
                        && distancias[u] + grafo[u][i] < distancias[i]) {
                    distancias[i] = distancias[u] + grafo[u][i];
                    aterior[i] = u;
                }
            }
        }

        return camino(distancias, aterior, origen, destino);
    }

    private static int distanciaMedia(double[] distancias, boolean[] visitados) {
        double min = INF;
        int indice = -1;

        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] <= min) {
                min = distancias[i];
                indice = i;
            }
        }

        return indice;
    }

    private static String camino(double[] distancias, int[] anterior, int origen, int destino) {
        ControladorAntena tele = new ControladorAntena();
        var lista = tele.getDaoAntena().listAll().toArray();
        
        StringBuilder result = new StringBuilder();
        result.append("Camino mas corto desde").append(lista[origen].getNombre()).append(" hacia ")
                        .append(lista[destino].getNombre()).append(":\n");

        if (distancias[destino] == INF) {
            result.append("Camino inexistente desde ").append(lista[origen].getNombre())
                  .append(" hacia ").append(lista[destino].getNombre());
            return result.toString();
        }

        int[] camino = new int[distancias.length];
        int idxCamino = 0;
        for (int at = destino; at != -1; at = anterior[at]) {
            camino[idxCamino++] = at;
        }

        for (int i = idxCamino - 1; i >= 0; i--) {
            result.append(lista[camino[i]].getNombre());
            if (i != 0) {
                result.append(" -> ");
            }
        }
        
        return result.toString();
    }

}
