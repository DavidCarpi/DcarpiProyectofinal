/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo;

import bd.conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Encabezado {
    
    private Integer idEncabezado;
    private Integer idClientes;
    private Integer idUsuario;
    private String numFactura;
    private String fecha;

      conectar cn=new conectar();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     
    public Encabezado(Integer idEncabezado, Integer idClientes, Integer idUsuario, String numFactura, String fecha) {
        this.idEncabezado = idEncabezado;
        this.idClientes = idClientes;
        this.idUsuario = idUsuario;
        this.numFactura = numFactura;
        this.fecha = fecha;
    }

    public Encabezado(Integer idClientes, Integer idUsuario, String numFactura, String fecha) {
        this.idClientes = idClientes;
        this.idUsuario = idUsuario;
        this.numFactura = numFactura;
        this.fecha = fecha;
    }

    public Encabezado() {
        
    }

    public Integer getIdEncabezado() {
        return idEncabezado;
    }

    public void setIdEncabezado(Integer idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    public void buscar() {

    }
    
//     public ResultSet listarClientesPorParametro(String criterio, String busqueda) {
//        System.out.println(criterio + " " + busqueda);
//        Connection cnn = conectar.getConexion();
//
//        ResultSet rs = null;
//        try {
//            CallableStatement st = cnn.prepareCall("{call SP_S_ClienteParametro(?,?)}");
//            st.setString("pcriterio", criterio);
//            st.setString("pbusqueda", busqueda);
//            System.out.println(""+st);
//
//            rs = st.executeQuery();
//            return rs;
//        } catch (SQLException SQLex) {
//            System.out.println("No se logro grabar el Registro.." + SQLex);
//            return null;
//        }
//    }
//    
    
    
      public void guardarEcabezado() {
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;

        String sql;

        sql = "INSERT INTO encabezados(idClientes,idUsuario,encNumeroFactura,encFecha) VALUES (?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, getIdClientes());
            ps.setInt(2, getIdUsuario());
            ps.setString(3, getNumFactura());
            ps.setString(4, getFecha());
            
            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("Encabezado Creado con exito");
//                JOptionPane.showMessageDialog(null, "Encabezado de Factura Creado con exito", "Crear Registro", JOptionPane.INFORMATION_MESSAGE);
            }

            cnn.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el Encabezado");
            System.out.println("No se logro grabar el Registro.." + e);
        }
    }
    
    public String NmeroEnvabezado(){
        Connection cnn = conectar.getConexion();
        String serie="";
        String sql="SELECT max(idEncabezado) from encabezados";
        try {
            
           ps=cnn.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               serie=rs.getString(1);
           }
        } catch (Exception e) {
        }
        return serie;
    }
     
       public String NmeroFactura(){
        Connection cnn = conectar.getConexion();
        String serie="";
        String sql="SELECT max(encNumeroFactura) from encabezados";
        try {
            
           ps=cnn.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               serie=rs.getString(1);
           }
        } catch (Exception e) {
        }
        return serie;
    }
    
}
