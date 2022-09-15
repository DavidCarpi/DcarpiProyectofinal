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


public class usuarios {
    private Integer idUsuario;
    private Integer idEmpleado;
    private String usuUsuario;
    private String usuClave;
    private String paUsuario;
    private String usuFechaCreacion;
     conectar cn=new conectar();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
 

    public usuarios(Integer idUsuario, Integer idEmpleado, String usuUsuario, String usuClave, String paUsuario, String usuFechaCreacion) {
        this.idUsuario = idUsuario;
        this.idEmpleado = idEmpleado;
        this.usuUsuario = usuUsuario;
        this.usuClave = usuClave;
        this.paUsuario = paUsuario;
        this.usuFechaCreacion = usuFechaCreacion;
    }

    public usuarios(Integer idEmpleado, String usuUsuario, String usuClave, String paUsuario, String usuFechaCreacion) {
        this.idEmpleado = idEmpleado;
        this.usuUsuario = usuUsuario;
        this.usuClave = usuClave;
        this.paUsuario = paUsuario;
        this.usuFechaCreacion = usuFechaCreacion;
    }

    

    public usuarios() {
    }
    

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public String getPaUsuario() {
        return paUsuario;
    }

    public void setPaUsuario(String paUsuario) {
        this.paUsuario = paUsuario;
    }

    public String getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(String usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

        
 
    public void guardar(){
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;
        
        String sql;

        sql="INSERT INTO usuarios (idEmpleado,usuUsuario,usuClave,paUsuario,usuFechaCreacion)VALUES (?,?,?,?,?)";
        try {
            ps=cnn.prepareStatement(sql);
            
            ps.setString(1,getIdEmpleado().toString());
            ps.setString(2,getUsuUsuario());
            ps.setString(3,getUsuClave());
            ps.setString(4,getPaUsuario());
            ps.setString(5,getUsuFechaCreacion());
            
            
            int n = ps.executeUpdate();
            
            if (n > 0){
                JOptionPane.showMessageDialog(null,"Registrado con exito", "Grabar Registro",JOptionPane.INFORMATION_MESSAGE);
            }
            
            cnn.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se logro grabar el Registro..."+ex, "Grabar Registro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public boolean actualizar() throws SQLException {
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;
        
        String sql;
        sql = "UPDATE usuarios SET idUsuario=?, usuUsuario=?,usuClave=? WHERE idUsuario="+ getIdUsuario();
        ps = cnn.prepareStatement(sql);
        ps.setString(1,getIdUsuario().toString());
        ps.setString(2,getUsuUsuario());
        ps.setString(3,getUsuClave());
        //ps.setString(11,per.getCli_tipo());

            
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null,"Actualización Exitosa", "Actualizar Registro",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"No se pudo Actualizar el Registro", "Actualizar Registro",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public String consultarUsuario(String cod) {
        
        Connection cnn = conectar.getConexion();
        
        PreparedStatement ps = null;
        
        ResultSet res;
        
        
        String sql;
        sql = "SELECT idUsuario, usuUsuario FROM usuarios WHERE usuUsuario = '" + cod+ "'";
        try{
            ps = cnn.prepareStatement(sql);
            res = ps.executeQuery();
            while(res.next()){
                String usucod = res.getString("idUsuario");
                if ( usucod != null ){
                    //JOptionPane.showMessageDialog(null, "Expediente encontrado: " + cerexa, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    return usucod;
                } 
            }
            res.close();            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
        
    }
    
    public boolean consultarContrasena(String cod, String contrasena) {
        
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;
        ResultSet res;
        
        String sql;
        
        sql = "SELECT idUsuario, usuClave FROM usuarios WHERE idUsuario = '" + cod + "' AND usuClave = '" + contrasena+ "'";
        try{
            ps = cnn.prepareStatement(sql);
            res = ps.executeQuery();
            while(res.next()){
                String usucon = res.getString("usuClave");
                if ( usucon != null ){
                    return true;
                } 
            }
            res.close();            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
        
    }
      public  ResultSet listarUsuarioPorParametro(String criterio, String busqueda) throws Exception {
        Connection cnn = conectar.getConexion();
        
        ResultSet rs = null;
        try {
            CallableStatement st = cnn.prepareCall("{call SP_S_UsuarioParametro(?,?)}");
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
         public String mostrarDatos() {
        String msj;
        msj = ("\n\nIdUsuario: " + getIdUsuario()
                + "\nIdEmpleado: " + getIdEmpleado()
                + "\nUsuario: " + getUsuUsuario()
                + "\nClave: " + getUsuClave()
                + "\nNombreUsuario: " + getPaUsuario()
                + "\nFechaCreacion: " + getUsuFechaCreacion()
                );
        return msj;
    }
   public void eliminarUsuario() {

        if (pregunta("Esta seguro de Eliminar el registro?", "Eliminar Datos") == JOptionPane.YES_OPTION) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "DELETE FROM usuarios WHERE idUsuario = " + getIdUsuario();
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

//        public String actualizarClave(String clave) throws SQLException {
//        Connection cnn = conectar.getConexion();
//        
//
//        String sql;
//        sql = "UPDATE usuarios SET  usuClave=? WHERE idUsuario=" + getIdUsuario();
//
//        try {
//            
//              ps=cnn.prepareStatement(sql);
//     
//         
//            
//            ps.setString(1, getUsuClave());
//            System.out.println(sql);
//            rs = ps.executeQuery();
//            cnn.close();
//            ps.close();
//           
//        } catch (SQLException ex) {
//            System.out.println("No se logro acualizar el registro usuarios: " + ex);
//            //Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return clave;
//    }
   
   
    public void actualizarClave() throws SQLException {
        Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;

        String sql;
        sql = "UPDATE usuarios SET  usuClave=? WHERE idUsuario= " + getIdUsuario();

        try {
            ps = cnn.prepareStatement(sql);
            ps.setString(1, getUsuClave());
            System.out.println(sql);
            int ru = ps.executeUpdate();
            cnn.close();
            ps.close();
            if (ru > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa", "Cambio de Clave", JOptionPane.INFORMATION_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(null, "Actualizacion fallida", "Actualizacion Exitosa", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException ex) {
            System.out.println("No se logro acualizar el registro usuarios: " + ex);
            //Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
