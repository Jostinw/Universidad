package vista.Escuela.tabla;

import modelo.Antena;
import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;

public class TablaAntena extends AbstractTableModel {

    private LinkedList<Antena> datos;

    public LinkedList<Antena> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Antena> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Antena t = datos.toArray()[rowIndex];

        String a = t.getFotos()[1];

        switch (columnIndex) {
            case 0:
                return t.getNombre();
            case 1:
                return t.getLatitud();
            case 2:
                return t.getLongitud();
            case 3:
                return t.getFotos()[0];
            case 4:
                return t.getFotos()[1];
            case 5:
                return t.getFotos()[2];
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Latitud";
            case 2:
                return "Longitud";
            case 3:
                return "Foto";
            case 4:
                return "Foto";
            case 5:
                return "Foto";
            default:
                return null;
        }
    }

}
