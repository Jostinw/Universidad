package vista.Escuela;

import controlador.ControladorAntena;
import busquedagrafo.Dijkstra;
import vista.Escuela.tabla.TablaAntena;
import controlador.util.Utilidades;
import java.io.File;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static busquedagrafo.Floyd.floyd;
import controlador.TDA.listas.exception.LlenoException;
import controlador.TDA.listas.exception.VacioException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelefoniaFrm extends javax.swing.JFrame {

    private File foto;
    private File foto2;
    private File foto3;

    private ControladorAntena controlador = new ControladorAntena();
    private TablaAntena modelo = new TablaAntena();

    public TelefoniaFrm() {
        initComponents();
        tabla();
    }

    public void tabla() {

        modelo.setDatos(controlador.getDaoAntena().listAll());
        tbTelefonia.setModel(modelo);
        tbTelefonia.updateUI();

        cbxOrigen1.removeAllItems();
        cbxDestino1.removeAllItems();

        var lista = controlador.getDaoAntena().listAll().toArray();

        for (int i = 0; i < lista.length; i++) {
            cbxOrigen1.addItem(lista[i].getNombre());
            cbxDestino1.addItem(lista[i].getNombre());
        }

    }

    public void limpiar() {
        txtNombre.setText("");
        txtLongitud.setText("");
        txtLatitud.setText("");
        txtFoto.setText("");
        txtFoto2.setText("");
        txtFoto3.setText("");

        foto = foto2 = foto3 = null;

    }

    public void guardarTelefonia() throws Exception {
        int count = 0;

        String uuidF1 = UUID.randomUUID().toString();
        String uuidF2 = UUID.randomUUID().toString();
        String uuidF3 = UUID.randomUUID().toString();

        String nombre = txtNombre.getText();
        Double latitud = Double.valueOf(txtLatitud.getText());
        Double longitud = Double.valueOf(txtLongitud.getText());
        String[] fotos = new String[3];

        if (!txtFoto.getText().isBlank()) {
            String foto1 = uuidF1 + Utilidades.extension(txtFoto.getText());
            count++;
            fotos[0] = foto1;

        }

        if (!txtFoto2.getText().isBlank()) {
            String foto2 = uuidF1 + Utilidades.extension(txtFoto2.getText());
            count++;
            fotos[1] = foto2;
        }

        if (!txtFoto3.getText().isBlank()) {
            String foto3 = uuidF1 + Utilidades.extension(txtFoto3.getText());
            count++;
            fotos[2] = foto3;
        }

        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Tienes que agregar minimo una imagen");
            return;
        }

        controlador.getDaoAntena().guardarTelefonia(nombre, latitud, longitud, fotos);
        JOptionPane.showMessageDialog(null, "Registrado");
        controlador.inciarGrafo();
        controlador.conectarNodo();
        limpiar();
        tabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLongitud = new javax.swing.JTextField();
        btnMostrarFoto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFoto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFoto2 = new javax.swing.JTextField();
        btnMostrarFoto1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtFoto3 = new javax.swing.JTextField();
        btnMostrarFoto2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTelefonia = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        cbxOrigen1 = new javax.swing.JComboBox<>();
        cbxDestino1 = new javax.swing.JComboBox<>();
        btnDijkstra1 = new javax.swing.JButton();
        btnFloyd1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Telefonia");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Latitud");

        jLabel4.setText("Longitud");

        btnMostrarFoto.setText("crear");
        btnMostrarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarFotoActionPerformed(evt);
            }
        });

        jLabel5.setText("Imagen");

        txtFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFotoMouseClicked(evt);
            }
        });

        jLabel6.setText("Imagen");

        txtFoto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFoto2MouseClicked(evt);
            }
        });

        btnMostrarFoto1.setText("crear");
        btnMostrarFoto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarFoto1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Imagen");

        txtFoto3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFoto3MouseClicked(evt);
            }
        });

        btnMostrarFoto2.setText("crear");
        btnMostrarFoto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarFoto2ActionPerformed(evt);
            }
        });

        tbTelefonia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbTelefonia);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Grafo"));

        jButton3.setText("Ver Grafo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbxOrigen1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxDestino1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDijkstra1.setText("Dijkstra");
        btnDijkstra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDijkstraActionPerformed(evt);
            }
        });

        btnFloyd1.setText("Floyd");
        btnFloyd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFloydActionPerformed(evt);
            }
        });

        jLabel11.setText("Origen");

        jLabel12.setText("Destino");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnDijkstra1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnFloyd1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxOrigen1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxDestino1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxOrigen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDestino1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDijkstra1)
                    .addComponent(btnFloyd1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jButton1)
                                .addGap(135, 135, 135))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtLongitud)
                                                        .addComponent(txtLatitud)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(jLabel2)
                                                            .addGap(15, 15, 15)
                                                            .addComponent(txtNombre))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(jLabel5)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnMostrarFoto)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtFoto3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnMostrarFoto1)
                                            .addComponent(btnMostrarFoto2))))
                                .addGap(27, 27, 27)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrarFoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrarFoto1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFoto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrarFoto2)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarFotoActionPerformed
        // TODO add your handling code here:

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Multimedia", "jpg", "png", "jpeg");
        fileChooser.addChoosableFileFilter(filter);

        int i = fileChooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            System.out.println("Si escogia");
            foto = fileChooser.getSelectedFile();
            txtFoto.setText(foto.getName());
        }

    }//GEN-LAST:event_btnMostrarFotoActionPerformed

    private void btnMostrarFoto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarFoto1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Multimedia", "jpg", "png", "jpeg");
        fileChooser.addChoosableFileFilter(filter);

        int i = fileChooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            System.out.println("Si escogia");
            foto2 = fileChooser.getSelectedFile();
            txtFoto2.setText(foto2.getName());
        }
    }//GEN-LAST:event_btnMostrarFoto1ActionPerformed

    private void btnMostrarFoto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarFoto2ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Multimedia", "jpg", "png", "jpeg");
        fileChooser.addChoosableFileFilter(filter);

        int i = fileChooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            System.out.println("Si escogia");
            foto3 = fileChooser.getSelectedFile();
            txtFoto3.setText(foto3.getName());
        }
    }//GEN-LAST:event_btnMostrarFoto2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            guardarTelefonia();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFotoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() >= 2) {
            new FrmFoto(null, true, foto).setVisible(true);
        }
    }//GEN-LAST:event_txtFotoMouseClicked

    private void txtFoto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFoto2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() >= 2) {
            new FrmFoto(null, true, foto2).setVisible(true);
        }
    }//GEN-LAST:event_txtFoto2MouseClicked

    private void txtFoto3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFoto3MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() >= 2) {
            new FrmFoto(null, true, foto3).setVisible(true);
        }
    }//GEN-LAST:event_txtFoto3MouseClicked

    private void btnFloydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFloydActionPerformed
        try {
            // TODO add your handling code here:
            int origen = cbxOrigen1.getSelectedIndex();
            int destino = cbxDestino1.getSelectedIndex();

            if (!controlador.getGrafoTelefonia().profundidad(controlador.getGrafoTelefonia().nro_vertices())) {
                JOptionPane.showMessageDialog(null, "El Grafo no esta Conectado");
            }

            if (!controlador.getGrafoTelefonia().anchura(controlador.getGrafoTelefonia().nro_vertices())) {
                JOptionPane.showMessageDialog(null, "El Grafo no esta Conectado");
            }

            double[][] grafo = controlador.getGrafoTelefonia().matrix();

            long inicio = System.nanoTime();
            String camino = floyd(grafo, origen, destino);
            long fin = System.nanoTime();
            long tiempoTotal = fin - inicio;

            JOptionPane.showMessageDialog(null, camino);
            JOptionPane.showMessageDialog(null, tiempoTotal / 1000000 + " milisegundos");
        } catch (LlenoException | VacioException ex) {
            Logger.getLogger(TelefoniaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFloydActionPerformed

    private void btnDijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDijkstraActionPerformed
        try {
            // TODO add your handling code here:
            int origen = cbxOrigen1.getSelectedIndex();
            int destino = cbxDestino1.getSelectedIndex();

            if (!controlador.getGrafoTelefonia().profundidad(controlador.getGrafoTelefonia().nro_vertices())) {
                JOptionPane.showMessageDialog(null, "El Grafo no esta Conectado");
            }

            if (!controlador.getGrafoTelefonia().anchura(controlador.getGrafoTelefonia().nro_vertices())) {
                JOptionPane.showMessageDialog(null, "El Grafo no esta Conectado");
            }

            double[][] grafo = controlador.getGrafoTelefonia().matriz();

            long inicio = System.nanoTime();
            String camino = Dijkstra.dijkstra(grafo, origen, destino);
            long fin = System.nanoTime();
            long tiempoTotal = fin - inicio;
            JOptionPane.showMessageDialog(null, camino);

            JOptionPane.showMessageDialog(null, tiempoTotal / 1000000 + " milisegundos");
        } catch (LlenoException | VacioException ex) {
            Logger.getLogger(TelefoniaFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDijkstraActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        controlador.mostrarGrafo();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelefoniaFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelefoniaFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelefoniaFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelefoniaFrm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelefoniaFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDijkstra;
    private javax.swing.JButton btnDijkstra1;
    private javax.swing.JButton btnFloyd;
    private javax.swing.JButton btnFloyd1;
    private javax.swing.JButton btnMostrarFoto;
    private javax.swing.JButton btnMostrarFoto1;
    private javax.swing.JButton btnMostrarFoto2;
    private javax.swing.JComboBox<String> cbxDestino;
    private javax.swing.JComboBox<String> cbxDestino1;
    private javax.swing.JComboBox<String> cbxOrigen;
    private javax.swing.JComboBox<String> cbxOrigen1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTelefonia;
    private javax.swing.JTextField txtFoto;
    private javax.swing.JTextField txtFoto2;
    private javax.swing.JTextField txtFoto3;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
