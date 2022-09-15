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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Inventario {
    int r;
     private Integer idInventario;
    private Integer idProducto;
    private Integer idProveedor;
    private String fechaCompra;
    private String fechaElaboracion;
    private String fechaExpiracion;
    private Integer stock;
    private Double precio;
    
     conectar cn=new conectar();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     

    public Inventario(Integer idInventario, Integer idProducto, Integer idProveedor, String fechaCompra, String fechaElaboracion, String fechaExpiracion, Integer stock, Double precio) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.fechaCompra = fechaCompra;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaExpiracion = fechaExpiracion;
        this.stock = stock;
        this.precio = precio;
    }

    public Inventario(Integer idProducto, Integer idProveedor, String fechaCompra, String fechaElaboracion, String fechaExpiracion, Integer stock, Double precio) {
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.fechaCompra = fechaCompra;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaExpiracion = fechaExpiracion;
        this.stock = stock;
        this.precio = precio;
    }

    public Inventario() {
        this.idInventario = 0;
        this.idProducto = 0;
        this.idProveedor = 0;
         
        
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(String fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
       public ResultSet listarInventarioPorParametro(String criterio, String busqueda) {
        System.out.println(criterio + " " + busqueda);
        Connection cnn = conectar.getConexion();

        ResultSet rs = null;
        try {
            CallableStatement st = cnn.prepareCall("{call SP_S_InventarioParametro(?,?)}");
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
       
         public String mostrarDatos() {
        String msj;
        msj = ("\n\nIdInventario: " + getIdInventario()
                + "\nIdProducto: " + getIdProducto()
                + "\nIdProveedor: " + getIdProveedor()
                + "\nFechaCompra: " + getFechaCompra()
                + "\nFechaElaboracion: " + getFechaElaboracion()
                + "\nFechaExpiracion: " + getFechaExpiracion()
                + "\nStok: "           + getStock()
                + "\nPrecio: "      + getPrecio());
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

            String sql = "DELETE FROM inventario WHERE idInventario = " + getIdInventario();
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
    
    
      public void guardar() {
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;

        String sql;

        sql = "INSERT INTO inventario (idProducto,idProveedor,invFechaCompra,invFechaElaboracion,invFechaExpiracion,invStok,invPrecio)VALUES (?,?,?,?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setInt(1, getIdProducto());
            ps.setInt(2, getIdProveedor());
            ps.setString(3, getFechaCompra());
            ps.setString(4, getFechaElaboracion());
            ps.setString(5, getFechaExpiracion());
            ps.setInt(6,     getStock());
            ps.setDouble(7, getPrecio());

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
    
    
       public void actualizar() {

        if (pregunta("¿Esta seguro de Actualizar el registro?", "Actualizar Datos") == JOptionPane.YES_OPTION) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "UPDATE inventario SET invFechaCompra=?, invFechaElaboracion=?,invFechaExpiracion=?, invStok=?, invPrecio=? WHERE idInventario=" + getIdInventario();

            try {
                ps = cnn.prepareStatement(sql);
                ps.setString(1, getFechaCompra());
                ps.setString(2, getFechaElaboracion());
                ps.setString(3, getFechaExpiracion());
                ps.setInt(4,    getStock());
                ps.setDouble(5, getPrecio());
                
                
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
    
    
    
    
    
       public ResultSet listarInventarioProductoPorParametro(String criterio, String busqueda) {
        System.out.println(criterio + " " + busqueda);
        Connection cnn = conectar.getConexion();

        ResultSet rs = null;
        try {
            CallableStatement st = cnn.prepareCall("{call SP_S_ProdFacturaParametro(?,?)}");
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
    
//    
//          public ArrayList<Productos> listarProductosFactura() {
//        Connection cnn = conectar.getConexion();
//        ArrayList<Productos> productoFacturaArray = new ArrayList<Productos>();
//        try {
//            CallableStatement statement = cnn.prepareCall("{call SP_S_ProductoFactura}");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                Productos FacturaProductoArrayList = new Productos();
//                I
//            }
//            return productoFacturaArray;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//    
//    
    
    
//  public Integer consultarStock(){
//      System.out.println("\n\nBuscar Inventario\nCriterio: "+idInventario);
//      Connection cnn = conectar.getConexion();
//      ResultSet rs = null;
//      try{
//          CallableStatement st=cnn.prepareCall("{call SP_S_consultarStock(?)}");
//          st.setString("pIdInventario", idInventario.toString());
//          rs=st.executeQuery();
//          while(rs.next()){
//              String stock =rs.getString("invStok");
//              if( stock !=null){
//                  return Integer.parseInt(stock);
//              }
//          }
//       rs.close();
//      }catch (SQLException SQLex){
//          System.out.println("");
//
//          
//      }
//          return null;
//  };
//
//    
//    
//    public void actualizarStock(Integer cantidad){
//        if(pregunta("¿Esta seguro de actualizar el registro?","Actualizar Datos")==
//                JOptionPane.YES_OPTION){
//            Connection cnn= conectar.getConexion();
//            PreparedStatement ps=null;
//            String sql ="UPDATE inventario SET invStok=? WHERE IDINVENTARIO=" +getIdInventario();
//            try{
//                ps=cnn.prepareStatement(sql);
//                Integer totalStock=0,stockDB;
//                stockDB = consultarStock();
//                totalStock = stockDB - cantidad;
//                ps.setString(1,totalStock.toString());
//                System.out.println(sql);
//                int r=ps.executeUpdate();
//                cnn.close();
//                ps.close();
//                if(r>0){
//                    JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Actualizar Registro",JOptionPane.INFORMATION_MESSAGE);
//                
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Registro","Actualizar Registro",JOptionPane.ERROR_MESSAGE);
//                }
//                
//            }catch(SQLException e){
//                System.out.println("No se logro actualizar el Registro.." +e);
//            }
//        }else{
//            System.out.println("Actualizacion Cancelada");
//        }
//    }
//
//    public int actualizarStock(int cantidad,int idInventario){
//        String sql="UPDATE inventario set invStock=? WHERE idInventario= "+getIdInventario();
//        Connection cnn = conectar.getConexion();
////        ResultSet rs=null;
////        PreparedStatement ps=null;
////        
//        try {
//          
//           ps=con.prepareStatement(sql);
//           ps.setInt(1, cantidad);
//           
//           ps.setInt(2, idInventario);
//           ps.executeQuery();
//           
//        }catch (Exception e){
//            
//        }
//        return r;
//    }
    
//    
    
//    public Inventario listarID(int id){
//        Inventario in=new Inventario();
//        String sql="select * from inventario WHERE idInventario=?";
//         Connection cnn = conectar.getConexion();
////        ResultSet rs;
////        PreparedStatement ps=null;
//        try {
//          
//           ps=con.prepareStatement(sql);
//           ps.setInt(1, id);
//          rs = ps.executeQuery();
//          while(rs.next()){
//              in.setIdInventario(rs.getInt(1));
//              in.setIdProducto(rs.getInt(2));
//              in.setIdProveedor(rs.getInt(3));
//              in.setFechaCompra(rs.getString(4));
//              in.setFechaElaboracion(rs.getString(5));
//              in.setFechaExpiracion(rs.getString(6));
//              in.setStock(rs.getInt(7));
//              in.setPrecio(rs.getDouble(8));
//              
//          }
//        }catch (Exception e){
//            
//        }
//           return in; 
//            
//    }
//    
    
//    
//    public void actualizarStock() throws SQLException {
//        Connection cnn = conectar.getConexion();
//        PreparedStatement ps = null;
//
//        String sql;
//        sql = "UPDATE inventario SET  invStok=? WHERE idInventario=" + getIdInventario();
//
//        try {
//            ps = cnn.prepareStatement(sql);
//            ps.setInt(0, getIdInventario());
//            ps.setInt(3, getStock());
//             
//
//            System.out.println(sql);
//            int ru = ps.executeUpdate();
//            cnn.close();
//            ps.close();
//            if (ru > 0) {
//                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa", "Cambio de Clave", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//
//                JOptionPane.showMessageDialog(null, "Actualizacion fallida", "Actualizacion Exitosa", JOptionPane.ERROR_MESSAGE);
//
//            }
//        } catch (SQLException ex) {
//            System.out.println("No se logro acualizar el registro usuarios: " + ex);
//            //Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    } 
    
       
//         public boolean actualizarStock(int cantidad,int idInventario){
//        String sql="UPDATE inventario set invStok=? WHERE idInventario=?";
//        Connection cnn = conectar.getConexion();
////        ResultSet rs=null;
////        PreparedStatement ps=null;
//        
//        try {
//           con = cn.getConexion();
//           ps.setInt(1, cantidad);
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
