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

/**
 *
 * @author Usuario
 */
public class Facturacion {
    private Integer idfacturacion;
       private Integer idEncabezado;
    private Integer idClientes;
    private Integer idUsuario;
    private String numFactura;
    private String fecha; 
     private Integer idDetalle;
    private Integer idInventario;
    private Integer stock;
    private Double subtotal;
    private Double iva;
    private Double total;
    
    conectar cn=new conectar();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     int r;
    public Facturacion(Integer idfacturacion, Integer idEncabezado, Integer idClientes, Integer idUsuario, String numFactura, String fecha, Integer idDetalle, Integer idInventario, Integer stock, Double subtotal, Double iva, Double total) {
        this.idfacturacion = idfacturacion;
        this.idEncabezado = idEncabezado;
        this.idClientes = idClientes;
        this.idUsuario = idUsuario;
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.idDetalle = idDetalle;
        this.idInventario = idInventario;
        this.stock = stock;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        
    }

    public Facturacion(Integer idEncabezado, Integer idClientes, Integer idUsuario, String numFactura, String fecha, Integer idDetalle, Integer idInventario, Integer stock, Double subtotal, Double iva, Double total) {
        this.idEncabezado = idEncabezado;
        this.idClientes = idClientes;
        this.idUsuario = idUsuario;
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.idDetalle = idDetalle;
        this.idInventario = idInventario;
        this.stock = stock;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        
    }

    public Facturacion() {
    }

    public Integer getIdfacturacion() {
        return idfacturacion;
    }

    public void setIdfacturacion(Integer idfacturacion) {
        this.idfacturacion = idfacturacion;
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

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

   

  

   
    
    
     
//    
//       public String mostrarDatosFacturacion() {
//        String msj;
//        msj = ("\n\nIdCliente: " + getIdClientes()
//                + "\nIdUsuario: " + getIdUsuario()
//                + "\nNumero de Factura: " + getNumFactura()
//                + "\nFecha: " + getFecha()
//                + "\nSubtotal: " + getSubtotal()
//                + "\nIva: " + getIva()
//                + "\nTotal: "       + getTotal()
//                );
//        return msj;
//    }
//       
//       
// public Integer pregunta(String msj1, String msj2) {
//        Object[] options = {"Aceptar", "Cancelar"};
//        Integer n = JOptionPane.showOptionDialog(null,
//                msj1 + mostrarDatosFacturacion(),
//                msj2,
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                options[0]);
//        return n;
//    }
    
        public ResultSet listarFACTURAPorParametro(String criterio, String busqueda) {
        System.out.println(criterio + " " + busqueda);
        Connection cnn = conectar.getConexion();

        ResultSet rs = null;
        try {
            CallableStatement st = cnn.prepareCall("{call SP_S_FacturacionParametro(?,?)}");
            st.setString("pcriterio", criterio);
            st.setString("pbusqueda", busqueda);
            System.out.println(""+st);

            rs = st.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            System.out.println("No se logro grabar el Registro.." + SQLex);
            return null;
        }
    }
    
    
//         public void VenderFactura() {
//
//        if (pregunta("Esta seguro en vender este producto?", "Vender producto") == JOptionPane.YES_OPTION) {
//            Connection cnn = conectar.getConexion();
//           PreparedStatement ps = null;
//
////            String sql = "DELETE FROM detalle WHERE idDetalle = " + getIdDetalle();
////            try {
////                ps = cnn.prepareStatement(sql);
////
////                int n = ps.executeUpdate();
//////                if (n > 0) {
//////                    JOptionPane.showMessageDialog(null, "Eliminado con exito", "Eliminar Registro", JOptionPane.INFORMATION_MESSAGE);
//////                }
////
////                cnn.close();
////                ps.close();
////            } catch (SQLException ex) {
////                JOptionPane.showMessageDialog(null, "No se logro Eliminar el Registro..." + ex, "Eliminar Registro", JOptionPane.ERROR_MESSAGE);
////                System.out.println("No se logro Eliminar el Registro..." + ex);
//
////            }
//
//        } else {
//            System.out.println("Venta Cancelada");
//        }
//
//    } 
        
        
        
        
//        public String idVentas(){
//            String idv="";
//            String SQL="SELECT max(idEncabezado) from encabezados";
//            try{
//                con=cne.
//            }
//        }
//        
//        
        
//        public boolean actualizarStock(int cantidad,int idInventario){
//        String sql="UPDATE inventario set invStok=? WHERE idInventario=?";
//        Connection cnn = conectar.getConexion();
////        ResultSet rs=null;
////        PreparedStatement ps=null;
//        
//        try {
//           con = cn.getConexion();
//           ps.setInt(1, idInventario);
//           ps.setInt(2, idInventario);
//           ps.execute();
//           return true;
//        }catch (Exception e){
//            System.out.println(e.toString());
//            return false;
//        }
//        
//    }
    
    
        
        
        
        
        
}
