/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.modelotabla;

import Modelo.Censador;
import Modelo.Censo;
import controlador.lista.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JOSTIN
 */
public class ModeloTablaCenso extends AbstractTableModel {

    private LinkedList<Censo> censo = new LinkedList<>();
    private LinkedList<Censador> censador = new LinkedList<>();

    public LinkedList<Censo> getCensos() {
        return censo;
    }

    public void setCensos(LinkedList<Censo> censo) {
        this.censo = censo;
    }

    public LinkedList<Censador> getCensador() {
        return censador;
    }

    public void setCensador(LinkedList<Censador> censador) {
        this.censador = censador;
    }

    @Override
    public int getRowCount() {
        return censo.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Censo c = null;

        try {
            c = censo.get(row);
        } catch (Exception e) {
        }

        switch (col) {
            case 0:
                return (c != null) ? c.getNombre() : " ";
            case 1:
                return (c != null) ? c.getMotivo() : " ";
            case 2:
                return (c != null) ? c.getEstadoEmocional() : " ";
            case 3:
                return (c != null) ? c.getEstado_civil() : " ";
            case 4:
                return (c != null) ? c.getFecha() : " ";

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Nombre";
            case 1:
                return "Motivo";
            case 2:
                return "Estado Emocional";
            case 3:
                return "Relación Marital";
            case 4:
                return "Fecha";
            default:
                return null;
        }
    }
}
