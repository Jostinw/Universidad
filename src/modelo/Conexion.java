package modelo;

public class Conexion {
    private Integer origen;
    private Integer destino;
    private Double peso;

    public Conexion(Integer origen, Integer destino, Double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
    
    
    public Integer getOrigen() {
        return origen;
    }

    public void setOrigen(Integer origen) {
        this.origen = origen;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
    
}
