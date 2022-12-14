/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.deu.intsuperior.vista;


import java.awt.Component;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import ec.edu.intsuperior.modelo.Clientes;


/**
 *
 * @author Usuario
 */
public class jifrmClientess extends javax.swing.JInternalFrame {

    String titulos[] = {"idCliente", "Apellidos", "Nombres", "Cedula", "Correo", "Telefono", "Direccion"};

    DefaultTableModel dtm = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    String criterio, busqueda, strCodigo;
    Integer busquedaInt;
    static ResultSet rs = null;
    Clientes cli = new Clientes();
    
    
    public jifrmClientess() {
        initComponents();
      rbtnIdCliente.setSelected(true);
      columnasAutoAjustable(tblCliente); 
      buscarCliente();
      
    }
 
    
    public Boolean validar(){
        Boolean b=true;
        return b;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CLIENTES = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        tbDatos = new javax.swing.JTabbedPane();
        pFormularioDatos = new javax.swing.JPanel();
        lblIdCliente = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        pBuscar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rbtnApellido = new javax.swing.JRadioButton();
        rbtnNombre = new javax.swing.JRadioButton();
        rbtnCedula = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        rbtnIdCliente = new javax.swing.JRadioButton();
        lblTotalRegistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        pFormularioDatos.setBackground(new java.awt.Color(102, 153, 255));

        lblIdCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Id Cliente"));

        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellidos"));

        txtNombres.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombres"));

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));

        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder("Correo"));

        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));

        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Direccion"));

        javax.swing.GroupLayout pFormularioDatosLayout = new javax.swing.GroupLayout(pFormularioDatos);
        pFormularioDatos.setLayout(pFormularioDatosLayout);
        pFormularioDatosLayout.setHorizontalGroup(
            pFormularioDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFormularioDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFormularioDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFormularioDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(txtNombres)
                        .addComponent(txtCedula)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        pFormularioDatosLayout.setVerticalGroup(
            pFormularioDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFormularioDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tbDatos.addTab("Datos Clientes", pFormularioDatos);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por:"));

        CLIENTES.add(rbtnApellido);
        rbtnApellido.setText("Apellido");

        CLIENTES.add(rbtnNombre);
        rbtnNombre.setText("Nombre");

        CLIENTES.add(rbtnCedula);
        rbtnCedula.setText("Cedula");

        txtBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese el texto de busqueda"));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        CLIENTES.add(rbtnIdCliente);
        rbtnIdCliente.setText("Id Cliente");

        lblTotalRegistros.setBackground(new java.awt.Color(204, 204, 255));
        lblTotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder("      Total de registros"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbtnIdCliente)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnApellido)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNombre))
                    .addComponent(txtBuscar))
                .addGap(18, 18, 18)
                .addComponent(rbtnCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnApellido)
                    .addComponent(rbtnNombre)
                    .addComponent(rbtnCedula)
                    .addComponent(rbtnIdCliente))
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblCliente.setBackground(new java.awt.Color(204, 153, 255));
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);
        tblCliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout pBuscarLayout = new javax.swing.GroupLayout(pBuscar);
        pBuscar.setLayout(pBuscarLayout);
        pBuscarLayout.setHorizontalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pBuscarLayout.setVerticalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbDatos.addTab("Buscar", pBuscar);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        jLabel1.setText("       ");
        jToolBar1.add(jLabel1);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        jLabel2.setText("      ");
        jToolBar1.add(jLabel2);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        jLabel3.setText("      ");
        jToolBar1.add(jLabel3);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiarmmmmmm.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setFocusable(false);
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimpiar);

        jLabel4.setText("      ");
        jToolBar1.add(jLabel4);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);

        jLabel5.setText("      ");
        jToolBar1.add(jLabel5);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        jLabel6.setText("      ");
        jToolBar1.add(jLabel6);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salirrrrr.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbDatos)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbDatos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(validar()){
            Clientes cli = new Clientes(txtApellidos.getText(),txtNombres.getText(),txtCedula.getText(), txtCorreo.getText(),txtTelefono.getText(), txtDireccion.getText());
            cli.guardar();
        }else{
            System.out.println("Error de validacion, no se creo el registro");
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
       buscarCliente();
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cargarDatosFormulario("limpiar");
       habilitarBotonesInicio();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
       
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       cli = new Clientes(Integer.parseInt(lblIdCliente.getText()),txtApellidos.getText(),txtNombres.getText(),txtCedula.getText(), txtCorreo.getText(),txtTelefono.getText(), txtDireccion.getText());
       cli.actualizar();
       buscarCliente();
       habilitarBotonesInicio();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        cli.eliminar();
       buscarCliente();
       habilitarBotonesInicio();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
         cargarDatosFormulario("cargarDatos");
        if(evt.getClickCount() == 2) {
            tbDatos.setSelectedComponent(pFormularioDatos);
        }
        habilitarBotonesProceso();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitarBotonesProcesoCargar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       habilitarBotonesInicio();
    }//GEN-LAST:event_btnCancelarActionPerformed
public void buscarCliente() {
        String titulos[] = {"IdCliente", "Apellidos", "Nombres", "Cedula", "Correo", "Telefono","Direccion"};
        dtm.setColumnIdentifiers(titulos);

        Clientes cli = new Clientes();
        
        busqueda = txtBuscar.getText();
        if (rbtnIdCliente.isSelected()) {
            criterio = "IDCLIENTE";
        }else if (rbtnApellido.isSelected()) {
            criterio = "apellidos";
        } else if (rbtnNombre.isSelected()) {
            criterio = "nombres";
        } else if (rbtnCedula.isSelected()) {
            criterio = "cedula";
        }
        try {
            rs = cli.listarClientesPorParametro(criterio, busqueda);
            boolean encuentra = false;
            
            String datos[] = new String[7];
            //Borrar registros de dtm existes
            int f, i;
            f = dtm.getRowCount();
            if (f > 0) {
                for (i = 0; i < f; i++) {
                    dtm.removeRow(0);
                }
            }
            while (rs.next()) {
                datos[0] = (String) rs.getString(1);
                datos[1] = (String) rs.getString(2);
                datos[2] = (String) rs.getString(3);
                datos[3] = (String) rs.getString(4);
                datos[4] = (String) rs.getString(5);
                datos[5] = (String) rs.getString(6);
                datos[6] = (String) rs.getString(7);

                dtm.addRow(datos);
                encuentra = true;

            }
            if (encuentra = false) {
                JOptionPane.showMessageDialog(null, "??No se encuentra!");
            }

            f = dtm.getRowCount();
            lblTotalRegistros.setText(String.valueOf(f));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        tblCliente.setModel(dtm);
    }

public void cargarDatosFormulario(String msj) {

        if (msj.equals("limpiar")) {
            cli = new Clientes();
        } else if(msj.equals("cargarDatos")){
            Integer fila = tblCliente.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
            } else {
                dtm = (DefaultTableModel) tblCliente.getModel();
                cli = new Clientes(Integer.parseInt(dtm.getValueAt(fila, 0).toString()),
                        (String) dtm.getValueAt(fila, 1),
                        (String) dtm.getValueAt(fila, 2),
                        (String) dtm.getValueAt(fila, 3),
                        (String) dtm.getValueAt(fila, 4),
                        (String) dtm.getValueAt(fila, 5),
                        (String) dtm.getValueAt(fila, 6));
            }

        }
        System.out.println(cli.mostrarDatos());
        lblIdCliente.setText(cli.getIdCliente().toString());
        txtApellidos.setText(cli.getApellidos());
        txtNombres.setText(cli.getNombres());
        txtCedula.setText(cli.getCedula());
        txtCorreo.setText(cli.getCorreo());
        txtTelefono.setText(cli.getTelefono());
        txtDireccion.setText(cli.getDireccion());
        strCodigo = (cli.getIdCliente().toString());

    }


     public void habilitarBotonesProceso(){
        //habilita o desabilita los botones del menu
        btnNuevo.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnLimpiar.setEnabled(true);
        btnSalir.setEnabled(true);
        //habilita las cajas de texto del formulario 
        txtApellidos.setEnabled(true);
        txtNombres.setEnabled(true);
        txtCedula.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
    }
     public void habilitarBotonesInicio(){
        //habilita o desabilita los botones del menu
        btnNuevo.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnLimpiar.setEnabled(true);
        btnSalir.setEnabled(true);
        //bloquea las cajas de texto del formulario 
        txtApellidos.setEnabled(false);
        txtNombres.setEnabled(false);
        txtCedula.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
    }
     public void habilitarBotonesProcesoCargar(){
        //habilita o desabilita los botones del menu
        btnNuevo.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnLimpiar.setEnabled(true);
        btnSalir.setEnabled(true);
        //habilita las cajas de texto del formulario 
        txtApellidos.setEnabled(true);
        txtNombres.setEnabled(true);
        txtCedula.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
    }


public void columnasAutoAjustable(JTable tabla) {
        tabla.setAutoResizeMode(tblCliente.AUTO_RESIZE_OFF);

        for (int column = 0; column < tabla.getColumnCount(); column++) {
            TableColumn columnaTabla = tabla.getColumnModel().getColumn(column);
            int anchoMinimo = columnaTabla.getMinWidth();
            int anchoMaximo = columnaTabla.getMaxWidth();

            for (int fila = 0; fila < tabla.getRowCount(); fila++) {
                TableCellRenderer cambiarAnchoCelda = tabla.getCellRenderer(fila, column);
                Component c = tabla.prepareRenderer(cambiarAnchoCelda, fila, column);
                int ancho = c.getPreferredSize().width + tabla.getIntercellSpacing().width;
                anchoMinimo = Math.max(anchoMinimo, ancho);

                //  We've exceeded the maximum width, no need to check other rows
                if (anchoMinimo >= anchoMaximo) {
                    anchoMinimo = anchoMaximo;
                    break;
                }
            }

            columnaTabla.setPreferredWidth(anchoMinimo);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup CLIENTES;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JPanel pBuscar;
    private javax.swing.JPanel pFormularioDatos;
    private javax.swing.JRadioButton rbtnApellido;
    private javax.swing.JRadioButton rbtnCedula;
    private javax.swing.JRadioButton rbtnIdCliente;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JTabbedPane tbDatos;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
