package controlador;

import modelo.Conexion;
import modelo.Antena;
import controlador.TDA.grafos.DibujarGrafo;
import controlador.TDA.grafos.GrafoEtiquetadoDirigido;
import controlador.TDA.listas.LinkedList;
import controlador.util.Utilidades;
import java.io.File;
import java.util.Random;
import javax.swing.JOptionPane;


public class ControladorAntena {

    private final AntenaDAO daoAntena;
    private final ConexionDAO daoConexion;
    private GrafoEtiquetadoDirigido<Antena> grafoTelefonia;
    private LinkedList<Antena> listaTelefonias;

    public ControladorAntena() {
        daoAntena = new AntenaDAO();
        daoConexion = new ConexionDAO();
    }

    public void mostrarGrafo() {
        try {
            
            inciarGrafo();
            
            DibujarGrafo dg = new DibujarGrafo();
            dg.crearArchivo(grafoTelefonia);

            String os = Utilidades.getOS();
            String dir = Utilidades.getDirProject();

            if (os.contains("Windows")) {
                Utilidades.abrirNavegadorPredeterminadoWindows(dir + File.separatorChar + "d3" + File.separatorChar + "grafo.html");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public void inciarGrafo() throws Exception {

        listaTelefonias = daoAntena.listAll();
        LinkedList<Conexion> conexiones = daoConexion.listAll();

        Integer size = daoAntena.listAll().getSize();

        grafoTelefonia = new GrafoEtiquetadoDirigido<>(size, Antena.class);

        if (size > 0) {
            grafoTelefonia = new GrafoEtiquetadoDirigido(size, Antena.class);
            for (int i = 0; i < size; i++) {
                grafoTelefonia.etiquetarVertice((i + 1), listaTelefonias.get(i));
            }

        }
        
        
        for(int i = 0; i < conexiones.getSize(); i++){
            
            Conexion conexion = conexiones.get(i);
            
            Double peso = Utilidades.distanciaDosPuntos(listaTelefonias.get(conexion.getOrigen()).getLatitud(),
                        listaTelefonias.get(conexion.getOrigen()).getLongitud(),
                        listaTelefonias.get(conexion.getDestino()).getLatitud(),
                        listaTelefonias.get(conexion.getDestino()).getLongitud());
            
            grafoTelefonia.insertarAristaE(listaTelefonias.get(conexion.getOrigen()),
                                           listaTelefonias.get(conexion.getDestino()), 
                                           peso);
            
        }
        
    }

    public void conectarNodo() throws Exception {
        
        int i = listaTelefonias.getSize() - 1;

        int conexiones = numeroAleatorio(2, 4);

        int aux = 0;

        while (aux < conexiones) {

            int destino = numeroAleatorio(0, listaTelefonias.getSize() - 1);

            if (destino != i && !grafoTelefonia.existe_arista(i + 1, destino + 1)) {
                double peso = Utilidades.distanciaDosPuntos(listaTelefonias.get(i).getLatitud(),
                        listaTelefonias.get(i).getLongitud(),
                        listaTelefonias.get(destino).getLatitud(),
                        listaTelefonias.get(destino).getLongitud());

                grafoTelefonia.insertarAristaE(listaTelefonias.get(i), listaTelefonias.get(destino), peso);
                
                daoConexion.guardarConexion(i, destino, peso);
                
                aux++;
            }

        }

    }

    public int numeroAleatorio(int min, int max) {

        Random rand = new Random();

        return rand.nextInt(max - min + 1) + min;
    }

    public AntenaDAO getDaoAntena() {
        return daoAntena;
    }

    public GrafoEtiquetadoDirigido<Antena> getGrafoTelefonia() {
        try {
            inciarGrafo();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return grafoTelefonia;
    }

    
}
