/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.deu.intsuperior.vista;

import bd.conectar;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ec.edu.intsuperior.modelo.usuarios;

import static ec.deu.intsuperior.vista.jifrmClientess.rs;

/**
 *
 * @author Usuario
 */
public class jifrmClave extends javax.swing.JInternalFrame {
//  DefaultTableModel dtm = new DefaultTableModel(null, titulos) {
//        @Override
//        public boolean isCellEditable(int row, int column) {
//            return false;
//        }
//    };

     String contrasenia;
    usuarios u = new usuarios();
    conectar cn=new conectar();
    
    
     public jifrmClave(usuarios usu) {
        initComponents();
        u = usu;
         lblUsuario.setText(usu.getUsuUsuario());
        desabilitarBotonesFin();
        habilitar();
         
    }
    
  public jifrmClave() {
        initComponents();
desabilitarBotonesFin();
 habilitar();
    }
    
   
      public Boolean confirmarClave() throws SQLException {
        Boolean contra = false;
       
        if (!psfClave.getText().equals(u.getUsuClave())) {
            JOptionPane.showMessageDialog(this, "Usuario no permitido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            contra = true;
        }
        return contra;

    }

    public void cambiarClave() throws SQLException {

        if (confirmarClave()) {
            u.setUsuClave(psfClaveNueva.getText());
            u.actualizarClave();

        }
    }
      

//       
//        public Boolean confirmarClave() throws SQLException {
//        Boolean ban = false;
//        if (!txtClave.getText().equals(u.getUsuClave())) {
//            JOptionPane.showMessageDialog(this, "Usuario no autorizado", "Error", JOptionPane.ERROR_MESSAGE);
//        } else {
//            
//            txtClaveNueva.setVisible(true);
//            btnCambiarContrasenia.setVisible(true);
//            btnConfirmar.setVisible(false);
//            txtClave.setVisible(false);
//            ban = true;
//        }
//        return ban;
//
//    }

//    public void cambiarClave() throws SQLException {
//
//        if (confirmarClave()) {
//            usu.setUsuClave(txtClaveNueva.getText());
//            usu.actualizarClave(clave);
//            txtClaveNueva.setText("");
//        }
//    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        psfClave = new javax.swing.JPasswordField();
        btnCambiarContrasenia = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        psfClaveNueva = new javax.swing.JPasswordField();
        lblUsuario = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        psfClave.setBorder(javax.swing.BorderFactory.createTitledBorder("           Ingrese su Contraseña"));

        btnCambiarContrasenia.setBackground(new java.awt.Color(255, 153, 255));
        btnCambiarContrasenia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCambiarContrasenia.setText("Confirmar");
        btnCambiarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseniaActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login2.png"))); // NOI18N

        btnConfirmar.setBackground(new java.awt.Color(255, 153, 255));
        btnConfirmar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConfirmar.setText("Cambiar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        psfClaveNueva.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese Nueva Contraseña"));

        lblUsuario.setBackground(new java.awt.Color(255, 204, 204));
        lblUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));
        lblUsuario.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(psfClave, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCambiarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(psfClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psfClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psfClave, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        jToolBar1.setBackground(new java.awt.Color(102, 153, 255));
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

        jLabel3.setText("               ");
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

        jLabel1.setText("                    ");
        jToolBar1.add(jLabel1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salirrrrr.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseniaActionPerformed
   try {
            confirmarClave();
            JOptionPane.showMessageDialog(this, "Acceso permitido");
        } catch (SQLException ex) {
            Logger.getLogger(jifrmClave.class.getName()).log(Level.SEVERE, null, ex);
           
        }        
         desabilitarBotonesInicio();                         
    }//GEN-LAST:event_btnCambiarContraseniaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
         
            
          try {
            cambiarClave();
        } catch (SQLException ex) {
            Logger.getLogger(jifrmClave.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          habilitar();
         this.psfClave.setText("");
         this.psfClaveNueva.setText("");
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       this.psfClave.setText("");
    this.psfClaveNueva.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
 botnNuevo();        
        
        
    }//GEN-LAST:event_btnNuevoActionPerformed
//public void buscarUsuario() {
//        String titulos[] = {"IdCliente", "Apellidos", "Nombres", "Cedula", "Correo", "Telefono","Direccion"};
//        dtm.setColumnIdentifiers(titulos);
//
//        usuarios cli = new usuarios();
//        
//        busqueda = txtBuscar.getText();
//        if (rbtnIdCliente.isSelected()) {
//            criterio = "IDCLIENTE";
//        }else if (rbtnApellido.isSelected()) {
//            criterio = "apellidos";
//        } else if (rbtnNombre.isSelected()) {
//            criterio = "nombres";
//        } else if (rbtnCedula.isSelected()) {
//            criterio = "cedula";
//        }
//        try {
//            rs = cli.listarClientesPorParametro(criterio, busqueda);
//            boolean encuentra = false;
//            
//            String datos[] = new String[7];
//            //Borrar registros de dtm existes
//            int f, i;
//            f = dtm.getRowCount();
//            if (f > 0) {
//                for (i = 0; i < f; i++) {
//                    dtm.removeRow(0);
//                }
//            }
//            while (rs.next()) {
//                datos[0] = (String) rs.getString(1);
//                datos[1] = (String) rs.getString(2);
//                datos[2] = (String) rs.getString(3);
//                datos[3] = (String) rs.getString(4);
//                datos[4] = (String) rs.getString(5);
//                datos[5] = (String) rs.getString(6);
//                datos[6] = (String) rs.getString(7);
//
//                dtm.addRow(datos);
//                encuentra = true;
//
//            }
//            if (encuentra = false) {
//                JOptionPane.showMessageDialog(null, "¡No se encuentra!");
//            }
//
//            f = dtm.getRowCount();
//            lblTotalRegistros.setText(String.valueOf(f));
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        
//        tblCliente.setModel(dtm);
//    }

//     private void ValidarUsuarioBase() {
//     
//     contrasenia = new String(txtClave.getPassword());
//     String lblUsuario = null;
//     usuarios usu=new usuarios();
//     Boolean cc = false;
//    
//     cc =usu.consultarContrasena(lblUsuario,txtClave .getText());
//     if(lblUsuario == null){
//     JOptionPane.showMessageDialog(null, "Usuario No Encontrado ");
//     }else {
//         if( !cc){
//         JOptionPane.showMessageDialog(null, "La contraseña no es valida");
//         }else{
//          
//           
//
//                usu.setUsuClave(txtClave.getText());
//    
//
//              
//    
//     
//     }
//    }
// }
    public void desabilitarBotonesFin(){
        psfClave.setEnabled(true);
        btnCambiarContrasenia.setEnabled(true);
      psfClaveNueva.setEnabled(false);
        btnConfirmar.setEnabled(false);
    }
     public void desabilitarBotonesInicio(){
      psfClave.setEnabled(false);
        btnCambiarContrasenia.setEnabled(false);
         psfClaveNueva.setEnabled(true);
        btnConfirmar.setEnabled(true);
    }
     public void habilitar(){
         btnNuevo.setEnabled(true);
         btnLimpiar.setEnabled(false);
      psfClave.setEnabled(false);
        btnCambiarContrasenia.setEnabled(false);
         psfClaveNueva.setEnabled(false);
        btnConfirmar.setEnabled(false);
    }
     public void botnNuevo(){
         btnNuevo.setEnabled(true);
         btnLimpiar.setEnabled(true);
      psfClave.setEnabled(true);
        btnCambiarContrasenia.setEnabled(true);
         psfClaveNueva.setEnabled(false);
        btnConfirmar.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarContrasenia;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField psfClave;
    private javax.swing.JPasswordField psfClaveNueva;
    // End of variables declaration//GEN-END:variables
}
