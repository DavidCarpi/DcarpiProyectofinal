
package ec.edu.intsuperior.modelo;

import bd.conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Productos {
    
    private Integer idProducto;
    private String  descripcion;
    private String codigo;
    private String unidadMedida;
    private String infoNutricion;
    private String observacion;

    public Productos(Integer idProducto, String descripcion, String codigo, String unidadMedida, String infoNutricion, String observacion) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.unidadMedida = unidadMedida;
        this.infoNutricion = infoNutricion;
        this.observacion = observacion;
    }

    public Productos(String descripcion, String codigo, String unidadMedida, String infoNutricion, String observacion) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.unidadMedida = unidadMedida;
        this.infoNutricion = infoNutricion;
        this.observacion = observacion;
    }

    public Productos() {
         this.idProducto = 0;
    }
    
    

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getInfoNutricion() {
        return infoNutricion;
    }

    public void setInfoNutricion(String infoNutricion) {
        this.infoNutricion = infoNutricion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
     public void guardar() {
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;

        String sql;

        sql = "INSERT INTO productos (proDescripcion,proCodigo,proUnidadMedida,proInformacionNutricional,proObservacion)VALUES (?,?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setString(1, getDescripcion());
            ps.setString(2, getCodigo());
            ps.setString(3, getUnidadMedida());
            ps.setString(4, getInfoNutricion());
            ps.setString(5, getObservacion());
            

            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("Grabación Exitosa"+ps);
                JOptionPane.showMessageDialog(null, "Registrado con exito", "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
            }

            cnn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se logro grabar el Registro.." + e);
        }
    }
    
    
      public  ResultSet listarProductosPorParametro(String criterio, String busqueda) throws Exception {
        Connection cnn = conectar.getConexion();
        
        ResultSet rs = null;
        try {
            CallableStatement st = cnn.prepareCall("{call SP_S_ProductoParametro(?,?)}");
            st.setString("pcriterio", criterio);
            st.setString("pbusqueda", busqueda);
            
            rs = st.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
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
    
       public void buscar() {

    }
       
     
     public void actualizar() {

        if (pregunta("¿Esta seguro de Actualizar el registro?", "Actualizar Datos") == JOptionPane.YES_OPTION) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "UPDATE productos SET proDescripcion=?, proCodigo=?,proUnidadMedida=?, proInformacionNutricional=?, proObservacion=? WHERE idProducto=" + getIdProducto();

            try {
                ps = cnn.prepareStatement(sql);
                ps.setString(1, getDescripcion());
                ps.setString(2, getCodigo());
                ps.setString(3, getUnidadMedida());
                ps.setString(4, getInfoNutricion());
                ps.setString(5, getObservacion());
                
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


     
     
       public void eliminar() {

        if (pregunta("Esta seguro de Eliminar el registro?", "Eliminar Datos") == JOptionPane.YES_OPTION) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "DELETE FROM productos WHERE idProducto = " + getIdProducto();
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

    
    public String mostrarDatos() {
        String msj;
        msj = ("\n\nIdProducto "      + getIdProducto()
                + "\nDescripcion: "   + getDescripcion()
                + "\nCodigo: "        + getCodigo()
                + "\nUnidadMedida: "  + getUnidadMedida()
                + "\nInfoNutricion: " + getInfoNutricion()
                + "\nObservacion: "   + getObservacion());
                
        return msj;
    }
    

}
