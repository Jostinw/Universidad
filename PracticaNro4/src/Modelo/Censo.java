/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JOSTIN
 */
public class Censo {

    private Integer id;
    private String nombre;
    private String motivo;
    private String fecha;
    private String estadoEmocional;
    private String estado_civil;

    public Censo(Integer id, String nombre, String motivo, String fecha, String estadoEmocional, String estado_civil) {
        this.id = id;
        this.nombre = nombre;
        this.motivo = motivo;
        this.fecha = fecha;
        this.estadoEmocional = estadoEmocional;
        this.estado_civil = estado_civil;
    }

    public Censo() {

    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadoEmocional() {
        return estadoEmocional;
    }

    public void setEstadoEmocional(String estadoEmocional) {
        this.estadoEmocional = estadoEmocional;
    }

}
