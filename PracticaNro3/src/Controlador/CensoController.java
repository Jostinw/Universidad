/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ordenacion.MergeSort;
import Controlador.ordenacion.Quickshort;
import Modelo.Censo;
import controlador.interfazDAO.DataAccessObject;
import controlador.lista.Exception.VacioException;
import controlador.lista.LinkedList;

/**
 *
 * @author JOSTIN
 */
public class CensoController extends DataAccessObject<Censo> {

    private Censo censo = new Censo();
    // private LinkedList<Censo> css = new LinkedList<>();

    public CensoController() {
        super(Censo.class);
    }

    public Censo getCenso() {
        if (censo == null) {
            censo = new Censo();
        }
        return censo;
    }

    public void setCenso(Censo censo) {
        this.censo = censo;
    }

    public Boolean save() {
        censo.setId(generated_id());
        return save(censo);
    }

    public Boolean update(Integer pos) {
        return this.update(censo, pos);
    }

    public String generatedCode() {
        StringBuilder code = new StringBuilder();
        Integer length = listAll().getSize() + 1;
        Integer pos = length.toString().length();
        for (int i = 0; i < (10 - pos); i++) {
            code.append("0");
        }
        code.append(length.toString());
        return code.toString();
    }

    public int contarPorEstado_Civil(String Estado_Civil) throws VacioException {
        int c = 0;
        LinkedList<Censo> css = listAll();

        for (int i = 0; i < css.getSize(); i++) {
            Censo cs = css.get(i);
            if (Estado_Civil.equals(cs.getEstado_civil())) {
                c++;
            }
        }

        return c;
    }

    public LinkedList<Censo> ordenar(Boolean ordeancion, String metodo, String atributo) {

        LinkedList<Censo> censos = listAll();

        if (metodo.equalsIgnoreCase("mergesort")) {

            new MergeSort().mergeSort(censos, ordeancion, atributo);

            return censos;

        } else {

            new Quickshort().quickSort(censos, ordeancion, atributo);

            return censos;
        }

    }

    public static void main(String[] args) {
        CensoController c = new CensoController();
        c.getCenso().setNombre("X");
        c.save();
    }

}
