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

public class Clientes {

    private Integer idCliente;
    private String apellidos;
    private String nombres;
    private String cedula;
    private String correo;
    private String telefono;
    private String direccion;

    public Clientes(Integer idCliente, String apellidos, String nombres, String cedula, String correo, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Clientes(String apellidos, String nombres, String cedula, String correo, String telefono, String direccion) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Clientes() {
        this.idCliente = 0;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public void guardar() {
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;

        String sql;

        sql = "INSERT INTO clientes (cliApellidos,cliNombres,cliCedula,cliCorreo,cliTelefono,cliDireccion)VALUES (?,?,?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setString(1, getApellidos());
            ps.setString(2, getNombres());
            ps.setString(3, getCedula());
            ps.setString(4, getCorreo());
            ps.setString(5, getTelefono());
            ps.setString(6, getDireccion());

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

    public void buscar() {

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

            String sql = "DELETE FROM clientes WHERE idCliente = " + getIdCliente();
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

    public void validar() {

    }



    public ResultSet listarClientesPorParametro(String criterio, String busqueda) {
        System.out.println(criterio + " " + busqueda);
        Connection cnn = conectar.getConexion();

        ResultSet rs = null;
        try {
            CallableStatement st = cnn.prepareCall("{call SP_S_ClienteParametro(?,?)}");
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

    

    public void actualizar() {

        if (pregunta("¿Esta seguro de Actualizar el registro?", "Actualizar Datos") == JOptionPane.YES_OPTION) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "UPDATE clientes SET cliApellidos=?, cliNombres=?,cliCedula=?, cliCorreo=?, cliTelefono=?, cliDireccion=? WHERE idCliente=" + getIdCliente();

            try {
                ps = cnn.prepareStatement(sql);
                ps.setString(1, getApellidos());
                ps.setString(2, getNombres());
                ps.setString(3, getCedula());
                ps.setString(4, getCorreo());
                ps.setString(5, getTelefono());
                ps.setString(6, getDireccion());
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

    public String mostrarDatos() {
        String msj;
        msj = ("\n\nIdCliente: " + getIdCliente()
                + "\nApellidos: " + getApellidos()
                + "\nNombres: " + getNombres()
                + "\nCedula: " + getCedula()
                + "\nCorreo: " + getCorreo()
                + "\nTelefono: " + getTelefono()
                + "\nDireccion: " + getDireccion());
        return msj;
    }

  public ArrayList<Clientes> listarClientes() {
//        db.conectar con = new conectar();
        Connection cnn = conectar.getConexion();        
        ArrayList<Clientes> clienteusuarios = new ArrayList<Clientes>();
                
        try {
            
            CallableStatement statement = cnn.prepareCall("{call SP_S_Cliente}");
            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Clientes cli5 = new Clientes();

                cli5.setIdCliente(rs.getInt("idCliente"));
                cli5.setApellidos(rs.getString("cliApellidos"));
                cli5.setNombres(rs.getString("cliNombres"));
                cli5.setCedula(rs.getString("cliCedula"));
                cli5.setCorreo(rs.getString("cliCorreo"));
                cli5.setTelefono(rs.getString("cliTelefono"));
                cli5.setDireccion(rs.getString("cliDireccion"));                
                
                clienteusuarios.add(cli5);
            }
            return clienteusuarios;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
