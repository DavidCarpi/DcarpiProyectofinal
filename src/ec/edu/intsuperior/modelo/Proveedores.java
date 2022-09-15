
package ec.edu.intsuperior.modelo;

import bd.conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Proveedores {
    private Integer idProveedor;
    private String nombre;
    private String nomContacto;
    private String ruc;
    private String correo;
    private String telefono;
    private String direccion;
    private String paginaWeb;

    public Proveedores(Integer idProveedor, String nombre, String nomContacto, String ruc, String correo, String telefono, String direccion, String paginaWeb) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.nomContacto = nomContacto;
        this.ruc = ruc;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.paginaWeb = paginaWeb;
    }

    public Proveedores(String nombre, String nomContacto, String ruc, String correo, String telefono, String direccion, String paginaWeb) {
        this.nombre = nombre;
        this.nomContacto = nomContacto;
        this.ruc = ruc;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.paginaWeb = paginaWeb;
    }

    public Proveedores() {
         this.idProveedor = 0;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomContacto() {
        return nomContacto;
    }

    public void setNomContacto(String nomContacto) {
        this.nomContacto = nomContacto;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
    
    
    
     public void guardar() {
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;

        

        String sql = "INSERT INTO proveedores (proNombre,proNombreContacto,proRuc,proCorreo,proTelefono,proDireccion,proPaginaWeb)VALUES (?,?,?,?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setString(1, getNombre());
            ps.setString(2, getNomContacto());
            ps.setString(3, getRuc());
            ps.setString(4, getCorreo());
            ps.setString(5, getTelefono());
            ps.setString(6, getDireccion());
            ps.setString(7, getPaginaWeb());

            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("Grabación Exitosa" +ps);
                JOptionPane.showMessageDialog(null, "Registrado con exito", "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
            }

            cnn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se logro grabar el Registro.." + e);
        }
    }
    
    
      public  ResultSet listarProveedoresPorParametro(String criterio, String busqueda) throws Exception {
        Connection cnn = conectar.getConexion();
        
        ResultSet rs = null;
        try {
            CallableStatement st = cnn.prepareCall("{call SP_S_ProveedorParametro(?,?)}");
            st.setString("pcriterio", criterio);
            st.setString("pbusqueda", busqueda);
            
            rs = st.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    

       public void actualizar() {

        if (pregunta("¿Esta seguro de Actualizar el registro?", "Actualizar Datos") == JOptionPane.YES_OPTION) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "UPDATE proveedores SET proNombre=?, proNombreContacto=?,proRuc=?, proCorreo=?, empTelefono=?, empDireccion=?, proPaginaWeb=? WHERE idProveedor=" + getIdProveedor();

            try {
                ps = cnn.prepareStatement(sql);
                ps.setString(1, getNombre());
                ps.setString(2, getNomContacto());
                ps.setString(3, getRuc());
                ps.setString(4, getCorreo());
                ps.setString(5, getTelefono());
                ps.setString(6, getDireccion());
                ps.setString(7, getPaginaWeb());
                System.out.println(sql);

                int r = ps.executeUpdate();
                cnn.close();
                ps.close();
                if (r > 0) {
                    JOptionPane.showMessageDialog(null, "Actualización Exitosa", "Actualizar Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Registro", "Actualizar Registro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("No se logro actualizar el Registro.." + e);
            }
        } else {
            System.out.println("Actualizacion Cancelada");
        }

    }
         public void validar() {

    }
           public void buscar() {

    }

    public String mostrarDatos() {
        String msj;
        msj = ("\n\nIdProveedor: " + getIdProveedor()
                + "\nNombre: " + getNombre()
                + "\nNombreContacto: " + getNomContacto()
                + "\nRuc: "     + getRuc()
                + "\nCorreo: " + getCorreo()
                + "\nTelefono: " + getTelefono()
                + "\nDireccion: " + getDireccion()
                + "\nPaginaWeb: " + getPaginaWeb());
        return msj;
    }

      public Integer pregunta(String msj1, String msj2) {
        Object[] options = {"Aceptar", "Cancelar"};
        Integer n = JOptionPane.showOptionDialog(null,
                msj1 + mostrarDatos(),
                msj2,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        return n;
    }
     
     
     
       public void eliminar() {

        if (pregunta("Esta seguro de Eliminar el registro?", "Eliminar Datos") == JOptionPane.YES_OPTION) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "DELETE FROM proveedores WHERE idProveedor = " + getIdProveedor();
            try {
                ps = cnn.prepareStatement(sql);

                int n = ps.executeUpdate();
//                if (n > 0) {
//                    JOptionPane.showMessageDialog(null, "Eliminado con exito", "Eliminar Registro", JOptionPane.INFORMATION_MESSAGE);
//                }

                cnn.close();
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se logro Eliminar el Registro..." + ex, "Eliminar Registro", JOptionPane.ERROR_MESSAGE);
                System.out.println("No se logro Eliminar el Registro..." + ex);

            }

        } else {
            System.out.println("Eliminacion Cancelada");
        }

    }

     
      
      
    
}
