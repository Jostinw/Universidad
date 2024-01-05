/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Censador;
import controlador.interfazDAO.DataAccessObject;

/**
 *
 * @author JOSTIN
 */
public class CensadorController extends DataAccessObject<Censador> {

    private Censador censo = new Censador();
    // private LinkedList<Censador> censos = new LinkedList<>();

    public CensadorController() {
        super(Censador.class);
    }

    public Censador getCensador() {
        if (censo == null) {
            censo = new Censador();
        }
        return censo;
    }

    public void setCensador(Censador censo) {
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
        Integer length = listAll().getSize()+ 1;
        Integer pos = length.toString().length();
        for (int i = 0; i < (10 - pos); i++) {
            code.append("0");
        }
        code.append(length.toString());
        return code.toString();
    }
}

