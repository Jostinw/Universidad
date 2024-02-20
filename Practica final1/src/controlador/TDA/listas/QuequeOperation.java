/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.listas;

import controlador.TDA.listas.exception.LlenoException;
import controlador.TDA.listas.exception.VacioException;

/**
 *
 * @author JOSTIN
 */
public class QuequeOperation<E> extends LinkedList<E> {

    public void queque(E dato) throws LlenoException {
        addLast(dato);
    }

    public E dequeque() throws VacioException {
        if (isEmpty()) {
            throw new VacioException("Cola vacia");
        } else {
            return deleteFirst();
        }
    }

}
