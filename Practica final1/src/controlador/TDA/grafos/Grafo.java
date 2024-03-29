/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos;

import controlador.TDA.listas.LinkedList;
import controlador.TDA.listas.Queque;
import controlador.TDA.listas.exception.LlenoException;
import controlador.TDA.listas.exception.VacioException;
import java.util.HashMap;

/**
 *
 * @author JOSTIN
 */
public abstract class Grafo {

    public abstract Integer nro_vertices();

    public abstract Integer nro_aristas();

    public abstract Boolean existe_arista(Integer a, Integer b) throws Exception;

    public abstract Double peso_arista(Integer a, Integer b) throws Exception;

    public abstract void insertar(Integer a, Integer b) throws Exception;

    public abstract void insertar(Integer a, Integer b, Double peso) throws Exception;

    public abstract LinkedList<Adycencia> adycentes(Integer a);
    //nroVertice = 20
    //20X20
    //1 ------ 2
    //|
    //------- 3

    @Override
    public String toString() {
        StringBuilder grafo = new StringBuilder("GRAFOS \n");
        try {
            for (int i = 1; i <= nro_vertices(); i++) {
                grafo.append("Vertice ").append(String.valueOf(i)).append("\n");
                if (!adycentes(i).isEmpty()) {
                    Adycencia[] lista = adycentes(i).toArray();
                    for (Adycencia a : lista) {
                        grafo.append("Adycente ").append(a.getD().toString()).append("\n");
                    }
                }

            }
        } catch (Exception e) {
        }
        return grafo.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public double[][] matriz() {

        double[][] matriz = new double[nro_vertices()][nro_vertices()];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = 0;
            }
        }

        for (int i = 1; i <= nro_vertices(); i++) {

            Adycencia[] adyacencias = adycentes(i).toArray();

            if (adyacencias.length == 0) {
                continue;
            }

            for (Adycencia ad : adyacencias) {

                matriz[i - 1][ad.getD() - 1] = ad.getPeso();

            }

        }

        return matriz;
    }

    public double[][] matrix() {

        double INF = Double.MAX_VALUE;

        double[][] matriz = new double[nro_vertices()][nro_vertices()];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = INF;
                }

            }
        }

        for (int i = 1; i <= nro_vertices(); i++) {

            Adycencia[] adyacencias = adycentes(i).toArray();

            if (adyacencias.length == 0) {
                continue;
            }

            for (Adycencia ad : adyacencias) {

                matriz[i - 1][ad.getD() - 1] = ad.getPeso();

            }

        }

        return matriz;
    }

    private Boolean esta_conectado() {
        Boolean band = true;
        try {
            for (int i = 1; i <= nro_vertices(); i++) {
                if (!adycentes(i).isEmpty()) {
                    band = false;
                    break;
                }

            }
        } catch (Exception e) {
        }
        return band;
    }

    public HashMap camino(Integer o, Integer d) throws Exception {
        HashMap sendero = new HashMap();
        if (esta_conectado()) {
            LinkedList<Integer> vertices = new LinkedList<>();
            LinkedList<Double> pesos = new LinkedList<>();
            Boolean finalizar = false;
            Integer inicial = o;
            vertices.add(inicial);
            while (!finalizar) {
                LinkedList<Adycencia> adycencias = adycentes(inicial);
                Double peso = Double.MAX_VALUE;
                Integer T = -1;
                for (int i = 0; i < adycencias.getSize(); i++) {
                    Adycencia ad = adycencias.get(i);
                    if (!estaEnCamino(vertices, ad.getD())) {
                        Double pesoArista = ad.getPeso();

                        if (d.intValue() == ad.getD().intValue()) {
                            T = ad.getD();
                            peso = pesoArista;
                            break;
                        } else if (pesoArista < peso) {
                            T = ad.getD();
                            peso = pesoArista;
                        }
                    }

                }
                vertices.add(T);
                pesos.add(peso);
                inicial = T;
                if (d.intValue() == inicial.intValue()) {
                    break;
                }

            }

            sendero.put("camino", vertices);
            sendero.put("peso", pesos);
        } else {

        }
        return sendero;

    }

    private Boolean estaEnCamino(LinkedList<Integer> lista, Integer vertices) throws Exception {

        Boolean band = false;
        for (int i = 0; i < lista.getSize(); i++) {
            if (lista.get(i).intValue() == vertices.intValue()) {
                band = true;
                break;
            }
        }
        return band;
    }

    public boolean anchura(Integer v) throws LlenoException, VacioException {

        boolean[] visitados = new boolean[nro_vertices()];

        Queque<Integer> queue = new Queque<>();

        Integer n = 0;

        visitados[v - 1] = true;

        queue.queue(v);

        while (queue.getSize() != 0) {

            v = queue.dequeue(n);

            System.out.print(v + " ");

            for (int i = 0; i < adycentes(v).getSize(); i++) {

                n = adycentes(v).get(i).getD();

                if (!visitados[n - 1]) {
                    visitados[n - 1] = true;
                    queue.queue(n);
                }

            }

        }

        return estanConectados(visitados);

    }

    private void porProfundidad(int vertice, boolean[] visitados) {

        visitados[vertice - 1] = true;

        Adycencia[] aux = adycentes(vertice).toArray();

        if (aux == null) {
            return;
        }

        for (var a : aux) {

            Integer n = a.getD();

            if (!visitados[n - 1]) {
                porProfundidad(n, visitados);
            }

        }

    }

    public boolean profundidad(int v) {

        boolean[] visited = new boolean[nro_vertices()];

        porProfundidad(v, visited);

        return estanConectados(visited);

    }

    private boolean estanConectados(boolean[] visitados) {

        for (boolean vertice : visitados) {
            if (!vertice) {
                return false;
            }
        }
        return true;
    }

}
