/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos;

/**
 *
 * @author JOSTIN
 */
public class GrafoEtiquetadoNoDirigido<E> extends GrafoEtiquetadoDirigido<E> {

    public GrafoEtiquetadoNoDirigido(Integer nro_vertice, Class<E> clazz) {
        super(nro_vertice, clazz);
    }

    @Override
    public void insertar(Integer a, Integer b, Double peso) throws Exception {
        if (a.intValue() <= nro_vertices() && b.intValue() <= nro_vertices()) {
            if (!existe_arista(a, b)) {
                Adycencia auxO = new Adycencia();
                auxO.setPeso(peso);
                auxO.setD(b);
                Adycencia auxD = new Adycencia();
                auxD.setPeso(peso);
                auxD.setD(a);
                getListaAdycente()[a].add(auxO);
                getListaAdycente()[b].add(auxD);
                //nro_aristas++;
                setNro_aristas(nro_aristas() + 1);
            }
        } else {
            throw new Exception();
        }
    }

//    @Override
//    public void insertar(Integer a, Integer b, Double peso) throws Exception {
//        if (a.intValue() <= nro_vertices() && b.intValue() <= nro_vertices()) {
//            Integer codigoA = obtenerCodigoE(etiqueta[a]);
//            Integer codigoB = obtenerCodigoE(etiqueta[b]);
//
//            if (!existe_arista(codigoA, codigoB) && !existe_arista(codigoB, codigoA)) {
//                Adycencia auxO = new Adycencia();
//                auxO.setPeso(peso);
//                auxO.setD(b);
//                Adycencia auxD = new Adycencia();
//                auxD.setPeso(peso);
//                auxD.setD(a);
//                getListaAdycente()[codigoA].add(auxO);
//                getListaAdycente()[codigoB].add(auxD);
//                setNro_aristas(nro_aristas() + 1);
//            }
//        } else {
//            throw new VerticeOfSizeExecption();
//        }
//    }

}
