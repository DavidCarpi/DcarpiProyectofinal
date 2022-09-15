/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo;

import bd.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DetalleFactura {
    
    private Integer idDetalle;
    private Integer idEncabezado;
    private Integer idInventario;
    private String fecha;
    private Double subtotal;
    private Double iva;
    private Double total;

    public DetalleFactura(Integer idDetalle, Integer idEncabezado, Integer idInventario, String fecha, Double subtotal, Double iva, Double total) {
        this.idDetalle = idDetalle;
        this.idEncabezado = idEncabezado;
        this.idInventario = idInventario;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public DetalleFactura(Integer idEncabezado, Integer idInventario, String fecha, Double subtotal, Double iva, Double total) {
        this.idEncabezado = idEncabezado;
        this.idInventario = idInventario;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public DetalleFactura() {
    }

    
    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdEncabezado() {
        return idEncabezado;
    }

    public void setIdEncabezado(Integer idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    
     public void guardarDetalle() {
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;

        String sql;

        sql = " INSERT INTO detallefacturas(idEncabezado,idInventario,detFecha,detSubTotal,detIva,detTotal)VALUES (?,?,?,?,?,?)";
        try {

            ps = cnn.prepareStatement(sql);
            
            ps.setInt(1, getIdEncabezado());
            ps.setInt(2, getIdInventario());
            ps.setString(3, getFecha());
            ps.setDouble(4, getSubtotal());
            ps.setDouble(5, getIva());
            ps.setDouble(6, getTotal());
            
            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("Grabacion exitosa");
                JOptionPane.showMessageDialog(null, "Registrado con exito", "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
            }

            cnn.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el Producto");
            System.out.println("No se logro guardar el Registro.." + e);
        }

    }    
    
    
   
     
     
     
     

}

    
    
    
    
    
    
    
    
    
    

